package com.dot.Pops.helper.map;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.dot.Pops.service.CourierService;
import com.dot.Pops.service.ServiceFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Win7 on 04/05/2016.
 */
public class MapDirection {

    private String MODE_DRIVING = "driving";

    GoogleMap mMap;
    Distance dataDistance;

    public MapDirection(GoogleMap mMap, Distance dataDistance){
        this.mMap       = mMap;
        this.dataDistance = dataDistance;
    }

    public void loadMap(Context context, LatLng start, LatLng end){

        CourierService service = ServiceFactory.createRetrofitService(context, CourierService.class, CourierService.SERVICE_ENDPOINT_MAP);
        service.getDirectionMap(start.latitude+","+start.longitude, end.latitude+","+end.longitude, MODE_DRIVING)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelMap>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error_map", e.getMessage());
                    }

                    @Override
                    public void onNext(ModelMap modelMap) {
                        addPolyline(drawDirection(modelMap));
                    }
                });
    }

    private void addPolyline(List<LatLng> result){
        PolylineOptions lineOptions = new PolylineOptions();
        lineOptions.addAll(result);
        lineOptions.width(10);
        lineOptions.color(Color.BLUE);
        // Drawing polyline in the Google Map for the i-th route
        mMap.addPolyline(lineOptions);
    }

    private List<LatLng> drawDirection(ModelMap modelMap){
        List<LatLng> routes = new ArrayList<>();
        for (ModelMap.Route rt: modelMap.routes){
            for (ModelMap.Route.Leg leg: rt.legs){
                dataDistance.locationDistance(leg.distance.value+"");
            }
            routes.addAll(decodePoly(rt.overview_polyline.points));
        }
        return routes;
    }

    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

    public interface Distance{
        public void locationDistance(String distance);
    }
}
