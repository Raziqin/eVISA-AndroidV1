package com.example.uksbraziq.latlong;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class listview extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        String[] animal = {"Rat" , "Cat" , "Lion" , "Tiger"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_expandable_list_item_1, animal);
        getListView().setAdapter(adapter);
    }
}
