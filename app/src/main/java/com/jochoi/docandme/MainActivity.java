package com.jochoi.docandme;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static String[] specialtySelectionArray;
    private static String[] stationSelectionArray;
    private static String[] hospitalLanguageSelectionArray;
    private static final String apiBaseUrl = "https://simplwe.herokuapp.com/";
    private static String selectionOptionsUrl = apiBaseUrl + "mobile_home_8zVITR21iSmPAlwIkvP8Ig";
    private static String updateStationsUrl = apiBaseUrl + "return_stations_mobile_8zVITR21iSmPAlwIkvP8Ig";
    private static String selectedSpecialty = "";
    private static String selectedStation = "";
    private static String selectedLanguage = "";
    private static RequestQueue requestQueue;

    Button specialtySelectButton;
    Button stationSelectButton;
    Button languageSelectButton;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this line instructs Android to actually display everything on the screen
        setContentView(R.layout.activity_main);

        specialtySelectButton = (Button)findViewById(R.id.button_specialty_select);
        stationSelectButton = (Button)findViewById(R.id.button_station_select);
        languageSelectButton = (Button)findViewById(R.id.button_language_select);
        searchButton = (Button)findViewById(R.id.button_search);

        // stub for Volley code to get specialty, station, language selections...
        // in Java, the final keyword is used for variables that will not change
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjectRequest = new JsonObjectRequest(Request.Method.GET, selectionOptionsUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray specialtySelectables = response.getJSONArray("specialties");
                    specialtySelectionArray = new String[specialtySelectables.length()];
                    for (int i = 0; i < specialtySelectables.length(); i++) {
                        specialtySelectionArray[i] = specialtySelectables.getString(i);
                    }

                    JSONArray stationSelectables = response.getJSONArray("stations");
                    stationSelectionArray = new String[stationSelectables.length()];
                    for (int i = 0; i < stationSelectables.length(); i++) {
                        stationSelectionArray[i] = stationSelectables.getString(i);
                    }

                    JSONArray hospitalLanguageSelectables = response.getJSONArray("languages");
                    hospitalLanguageSelectionArray = new String[hospitalLanguageSelectables.length()];
                    for (int i = 0; i < hospitalLanguageSelectables.length(); i++) {
                        hospitalLanguageSelectionArray[i] = hospitalLanguageSelectables.getString(i);
                    }
                } catch(JSONException e) {
                    e.printStackTrace();
                }
                // requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                // requestQueue.stop();
            }
        });

        requestQueue.add(jsObjectRequest);

        View.OnClickListener specialtySelectButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder specialtySelectionAlert = new AlertDialog.Builder(MainActivity.this);
                specialtySelectionAlert.setTitle("Select a medical specialty");
                specialtySelectionAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when clicking this button goes here...
                        selectedSpecialty = "";
                        dialog.dismiss();
                    }
                });
                specialtySelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when clicking this button goes here...
                        System.out.println("specialty selection has been canceled");
                        dialog.dismiss();
                    }
                });
                specialtySelectionAlert.setItems(specialtySelectionArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when actually clicking a specialty goes here...
                        specialtySelectButton.setText(specialtySelectionArray[whichButton]);
                        selectedSpecialty = specialtySelectionArray[whichButton];
                        updateStations(selectedSpecialty);
                        dialog.dismiss();
                    }
                });
                specialtySelectionAlert.show();
            }
        };

        View.OnClickListener stationSelectButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder stationSelectionAlert = new AlertDialog.Builder(MainActivity.this);
                stationSelectionAlert.setTitle("Select a subway station near you");
                stationSelectionAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when clicking this button goes here...
                        selectedStation = "";
                        dialog.dismiss();
                    }
                });
                stationSelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when click this button goes here...
                        System.out.println("station selection has been canceled");
                        dialog.dismiss();
                    }
                });
                stationSelectionAlert.setItems(stationSelectionArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when actually clicking a station goes here...
                        stationSelectButton.setText(stationSelectionArray[whichButton]);
                        selectedStation = stationSelectionArray[whichButton];
                        dialog.dismiss();
                    }
                });
                stationSelectionAlert.show();
            }
        };

        View.OnClickListener languageSelectButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder hospitalLanguageSelectionAlert = new AlertDialog.Builder(MainActivity.this);
                hospitalLanguageSelectionAlert.setTitle("Select the hospital's operating language");
                hospitalLanguageSelectionAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButon) {
                        // action when clicking this button goes here...
                        selectedLanguage = "";
                        dialog.dismiss();
                    }
                });
                hospitalLanguageSelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when click this button goes here...
                        System.out.println("hospital language selection has been canceled");
                        dialog.dismiss();
                    }
                });
                hospitalLanguageSelectionAlert.setItems(hospitalLanguageSelectionArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // action when actually selecting a hospital language...
                        languageSelectButton.setText(hospitalLanguageSelectionArray[whichButton]);
                        selectedLanguage = hospitalLanguageSelectionArray[whichButton];
                        dialog.dismiss();
                    }
                });
                hospitalLanguageSelectionAlert.show();
            }
        };

        View.OnClickListener searchButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast searchToast = Toast.makeText(MainActivity.this, "Performing your search now...", Toast.LENGTH_SHORT);
                searchToast.show();
                Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
                startActivity(intent);
            }
        };

        specialtySelectButton.setOnClickListener(specialtySelectButtonListener);
        stationSelectButton.setOnClickListener(stationSelectButtonListener);
        languageSelectButton.setOnClickListener(languageSelectButtonListener);
        searchButton.setOnClickListener(searchButtonListener);
    }

    public void updateStations(String specialty) {
        System.out.println("UPDATE STATIONS HAS BEEN ACTIVATED");
        JSONObject jsonBody;
        try {
            jsonBody = new JSONObject("{\"selected_specialty\":\"" + specialty + "\"}");
        } catch(JSONException e) {
            e.printStackTrace();
            return;
        }
        JsonObjectRequest updateStationsRequest = new JsonObjectRequest(Request.Method.POST, updateStationsUrl, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("UPDATE STATIONS: " + response.toString());
                try {
                    JSONArray stationSelectables = response.getJSONArray("stations");
                    stationSelectionArray = new String[stationSelectables.length()];
                    for (int i = 0; i < stationSelectables.length(); i++) {
                        stationSelectionArray[i] = stationSelectables.getString(i);
                    }

                    JSONArray hospitalLanguageSelectables = response.getJSONArray("languages");
                    hospitalLanguageSelectionArray = new String[hospitalLanguageSelectables.length()];
                    for (int i = 0; i < hospitalLanguageSelectables.length(); i++) {
                        hospitalLanguageSelectionArray[i] = hospitalLanguageSelectables.getString(i);
                    }
                } catch(JSONException e) {
                    e.printStackTrace();
                }
                // requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                // requestQueue.stop();
            }
        });
        requestQueue.add(updateStationsRequest);
    }
}
