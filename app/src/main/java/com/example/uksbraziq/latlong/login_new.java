package com.example.uksbraziq.latlong;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uksbraziq.bean.UserBean;
import com.example.uksbraziq.bean.UserListBean;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class login_new extends AppCompatActivity implements View.OnClickListener {


    public static String KEY_EMAIL ;
    public static String KEY_PASSWORD = "password";
    public static int KEY_USERID;

    private EditText et_email;
    private EditText et_password;
    private Button bt_signin;

    private String email;
    private String password;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_signin = (Button) findViewById(R.id.bt_signin);
        bt_signin.setOnClickListener(this);
    }
    private void userLogin() {
        email = et_email.getText().toString().trim();
        password = et_password.getText().toString().trim();
        KEY_EMAIL = email;
        KEY_PASSWORD = password;
        KEY_USERID = id;

        String THE_URL = "http://192.168.1.164:8080/myaidservices/webapi/locationtag/login/" + email + "/" + password;
        StringRequest stringRequest = new StringRequest(Request.Method. GET, THE_URL, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals(response)) {

                            KEY_USERID = Integer.parseInt(response);
                            openProfile();

                        } else {
                            Toast.makeText(login_new.this, "FAILED", Toast.LENGTH_LONG).show();
                        }
                    }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login_new.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_EMAIL, email);
                map.put(KEY_PASSWORD, password);
                map.put("KEY_USERID" , String.valueOf(id));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void openProfile(){
        id = KEY_USERID;

        Intent intent = new Intent(this, profile.class);
        intent.putExtra("KEY_USERID", id);
        intent.putExtra(String.valueOf(KEY_USERID),Integer.toString(id));
        System.out.println("User ID is :" + KEY_USERID);
        System.out.println("Email is  "+ KEY_EMAIL);
        startActivity(intent);

    }

    @Override
    public void onClick(View v){
        userLogin();

    }
}




