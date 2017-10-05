package com.jochoi.docandme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void performSearch(View view) {
        Toast searchToast = Toast.makeText(this, "Performing your search now...", Toast.LENGTH_SHORT);
        searchToast.show();
    }
}
