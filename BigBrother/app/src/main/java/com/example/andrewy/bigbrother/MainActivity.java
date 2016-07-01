package com.example.andrewy.bigbrother;

import android.Manifest;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.connect_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Register device in server
            }
        });


    }

    private  void checkPermissions(){
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_CALENDAR);
    }
}
