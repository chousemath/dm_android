package com.jochoi.docandme;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String[] specialtySelectionArray;
    static String[] stationSelectionArray;
    static String[] hospitalLanguageSelectionArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("\n\n\nI am loaded...\n\n\n");

        // stub for Volley code to get specialty, station, language selections...

        // first define size of specialty selection array...
        specialtySelectionArray = new String[2];
        // loop through server provided specialty selection and populate array
        specialtySelectionArray[0] = "specialty-1";
        specialtySelectionArray[1] = "specialty-2";

        // define size of station selection array...
        stationSelectionArray = new String[2];
        // loop through server provided station selection and populate array
        stationSelectionArray[0] = "station-1";
        stationSelectionArray[1] = "station-2";

        // define size of language selection array...
        hospitalLanguageSelectionArray = new String[2];
        // loop through server provided language selection and populate array
        hospitalLanguageSelectionArray[0] = "language-1";
        hospitalLanguageSelectionArray[1] = "language-2";
    }

    public void openSpecialtySelectionDialog(View view) {
        AlertDialog.Builder specialtySelectionAlert = new AlertDialog.Builder(this);
        specialtySelectionAlert.setTitle("Select a medical specialty");
        specialtySelectionAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when clicking this button goes here...
                System.out.println("reset specialty selection has been clicked");
            }
        });
        specialtySelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when clicking this button goes here...
                System.out.println("specialty selection has been canceled");
            }
        });
        specialtySelectionAlert.setItems(specialtySelectionArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when actually clicking a specialty goes here...
                System.out.println("specialty selected!!!!");
            }
        });
        specialtySelectionAlert.show();
    }

    public void openStationSelectionDialog(View view) {
        AlertDialog.Builder stationSelectionAlert = new AlertDialog.Builder(this);
        stationSelectionAlert.setTitle("Select a subway station near you");
        stationSelectionAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when clicking this button goes here...
                System.out.println("reset station selection has been clicked");
            }
        });
        stationSelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when click this button goes here...
                System.out.println("station selection has been canceled");
            }
        });
        stationSelectionAlert.setItems(stationSelectionArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when actually clicking a station goes here...
                System.out.println("station selected!!!");
            }
        });
        stationSelectionAlert.show();
    }

    public void openHospitalLanguageSelectionDialog(View view) {
        AlertDialog.Builder hospitalLanguageSelectionAlert = new AlertDialog.Builder(this);
        hospitalLanguageSelectionAlert.setTitle("Select the hospital's operating language");
        hospitalLanguageSelectionAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButon) {
                // action when clicking this button goes here...
                System.out.println("reset hospital language selection has been clicked");
            }
        });
        hospitalLanguageSelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when click this button goes here...
                System.out.println("hospital language selection has been canceled");
            }
        });
        hospitalLanguageSelectionAlert.setItems(hospitalLanguageSelectionArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when actually selecting a hospital language...
                System.out.println("hospital language selected!!!");
            }
        });
        hospitalLanguageSelectionAlert.show();
    }

    public void performSearch(View view) {
        Toast searchToast = Toast.makeText(this, "Performing your search now...", Toast.LENGTH_SHORT);
        searchToast.show();
    }
}
