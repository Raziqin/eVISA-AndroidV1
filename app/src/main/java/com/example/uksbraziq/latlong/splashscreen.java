package com.example.uksbraziq.latlong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.R.animator.fade_in;
import static android.R.transition.fade;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread myThread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                    Intent intent =new Intent(getApplicationContext(),login_new.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }; myThread.start();

    }
}
