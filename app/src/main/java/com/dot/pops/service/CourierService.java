package com.dot.Pops.service;

import com.dot.Pops.helper.map.ModelMap;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Win7 on 03/05/2016.
 */
public interface CourierService {
    String SERVICE_ENDPOINT = "http://development.ayowes.com/rajapindah/api/v1/";
    String SERVICE_ENDPOINT_JSON = "http://103.195.31.181/dummy/apiboongan/";

    // google map direction
    String SERVICE_ENDPOINT_MAP = "http://maps.googleapis.com/maps/api/directions/";

    // google map direction
    @GET("json?sensor=false&units=metric")
    Observable<ModelMap> getDirectionMap(@Query("origin") String origin,
                                         @Query("destination") String destination,
                                         @Query("mode") String mode);

}
