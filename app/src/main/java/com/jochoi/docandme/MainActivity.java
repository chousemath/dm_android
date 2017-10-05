package com.jochoi.docandme;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("\n\n\nI am loaded...\n\n\n");
    }

    public void openSpecialtySelectionDialog(View view) {
        AlertDialog.Builder specialtySelectionAlert = new AlertDialog.Builder(this);
        specialtySelectionAlert.setTitle("Select a medical specialty");
        specialtySelectionAlert.setPositiveButton("Select", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when clicking this button goes here...
                System.out.println("specialty selection has been made");
            }
        });
        specialtySelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when clicking this button goes here...
                System.out.println("specialty selection has been canceled");
            }
        });
        specialtySelectionAlert.show();
    }

    public void openStationSelectionDialog(View view) {
        AlertDialog.Builder stationSelectionAlert = new AlertDialog.Builder(this);
        stationSelectionAlert.setTitle("Select a subway station near you");
        stationSelectionAlert.setPositiveButton("Select", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when clicking this button goes here...
                System.out.println("station selection has been made");
            }
        });
        stationSelectionAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // action when click this button goes here...
                System.out.println("station selection has been canceled");
            }
        });
        stationSelectionAlert.show();
    }

    public void performSearch(View view) {
        Toast searchToast = Toast.makeText(this, "Performing your search now...", Toast.LENGTH_SHORT);
        searchToast.show();
    }
}
