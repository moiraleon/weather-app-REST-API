package com.example.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    Button btn_cityID, btn_getWeatherByID, btn_getWeatherByName;
    EditText et_dataInput;
    ListView lv_weatherReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning values to controls on the layout
        btn_cityID = findViewById(R.id.btn_getCityID);
        btn_getWeatherByID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeatherByName = findViewById(R.id.btn_GetWeatherByCityName);

        et_dataInput = findViewById(R.id.et_dataInput);
        lv_weatherReport =findViewById(R.id.lv_weatherReports);

        //click listeners for each button

        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url ="https://www.metaweather.com/api/location/search/?query=london";

// Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "error occurred",Toast.LENGTH_SHORT).show();
//                    }
//                });

// Add the request to the RequestQueue.
//                queue.add(stringRequest);
            //    Toast.makeText(MainActivity.this,"You clicked me 1", Toast.LENGTH_SHORT).show();
            }
        });


        btn_getWeatherByID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked me 2", Toast.LENGTH_SHORT).show();
            }
        });

        btn_getWeatherByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"You typed"+et_dataInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}