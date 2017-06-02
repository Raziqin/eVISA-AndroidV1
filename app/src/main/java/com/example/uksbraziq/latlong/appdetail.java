package com.example.uksbraziq.latlong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class appdetail extends AppCompatActivity {

    String appNo;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appdetail);

        tv= (TextView) findViewById(R.id.tv_appNo);


        appNo = getIntent().getStringExtra(String.valueOf(profile.app));

        tv.setText(getIntent().getStringExtra(String.valueOf(profile.app)));

        System.out.println("App Number is " + appNo);
    }
}
