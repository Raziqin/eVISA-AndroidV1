package com.example.uksbraziq.latlong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//import static com.example.uksbraziq.latlong.login_new.KEY_APPNUMBER;

public class application extends AppCompatActivity {

    private TextView tv_appnumber;
    public static String KEY_APPNUMBER;
    String app_number = KEY_APPNUMBER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        tv_appnumber = (TextView) findViewById(R.id.tv_appnumber);

        Intent intent = getIntent();

        //tv_appnumber.setText(intent.getStringExtra(login_new.KEY_APPNUMBER ));



        //intent.getStringExtra(login_new.KEY_APPNUMBER);

//        getIntent().getExtras().get("KEY_APPNUMBER");
       // System.out.println("This is Key Appnumber = " + intent.getStringExtra(login_new.KEY_APPNUMBER));
    }
}
