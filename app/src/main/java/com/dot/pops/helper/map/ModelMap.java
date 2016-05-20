package com.dot.Pops.helper.map;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win7 on 04/05/2016.
 */
public class ModelMap {

    @SerializedName("routes")
    public List<Route> routes = new ArrayList<Route>();

    public class Route {

        @SerializedName("legs")
        public List<Leg> legs = new ArrayList<Leg>();

        @SerializedName("overview_polyline")
        public OverviewPolyline overview_polyline;

        public class Leg {

            @SerializedName("distance")
            public Distance distance;

            public class Distance {

                @SerializedName("text")
                public String text;
                @SerializedName("value")
                public Integer value;

            }

        }

        public class OverviewPolyline {
            @SerializedName("points")
            public String points;

        }

    }
}