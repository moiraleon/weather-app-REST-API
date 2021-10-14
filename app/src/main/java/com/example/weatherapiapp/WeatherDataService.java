package com.example.weatherapiapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_CITY_ID ="https://www.metaweather.com/api/location/search/?query=";

    Context context;
    String cityID;

    public WeatherDataService(Context context) {
        this.context = context;
    }
    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String cityID);
    }

    public void getCityID(String cityName, VolleyResponseListener volleyResponseListener){
        // Instantiate the RequestQueue.
//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url =QUERY_FOR_CITY_ID+ cityName;//adding the value from  our data input to the url =et_dataInput.getText().toString()
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                cityID = "";
                //get specific parts of the JSONObject Array
                //specifying in the array to grab the first Object by stating index of 0
                //then specifying which key value to grab based on its key
                try {
                    JSONObject cityInfo = response.getJSONObject(0);
                    cityID = cityInfo.getString("woeid"); //stating that if this string name exists grab the value
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //this works but doesn't return ID to main
                //Toast.makeText(context, "City ID = "+ cityID, Toast.LENGTH_SHORT).show();
                volleyResponseListener.onResponse(cityID);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(context, "An error occurred", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Error");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request );

        //returns null because gets run while other is in queue and loading so cityID has not yet been assigned
        //return cityID;

    }

//    public List<WeatherReportModel> getCityForecastByID(String cityID){
//
//    }
//    public List<WeatherReportModel> getCityForecastByName(String cityName){
//
//    }


}