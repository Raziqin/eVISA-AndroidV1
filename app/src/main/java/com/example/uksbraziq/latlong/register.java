package com.example.uksbraziq.latlong;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class register extends AppCompatActivity {

    // Spinner

    private Spinner spin;
    String[] Nationality = {"Please Choose" , "Bangladesh" , "Bhutan" , "China" , "India" , "Montenegro" , "Myanmar" ,
    "Nepal" , "Pakistan" , "Serbia" , "Sri Lanka"};

    private Spinner spin2;
    String[] Country = {"Please Choose" , "Malaysia", "China", "Bhutan"  , "India" , "Montenegro" , "Myanmar" ,
            "Nepal" , "Pakistan" , "Serbia" , "Sri Lanka"};

    //Date picker
    private TextView pDisplayDate;
    private Button pPickDate;
    private int pYear;
    private int pMonth;
    private int pDay;
    static final int DATE_DIALOG_ID = 0;



    private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener(){

                public void onDateSet(DatePicker view, int year, int monthOfYear, int DayOfMonth){

                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = DayOfMonth;

                    updateDisplay();
                    displayToast();
                }
            };

    private void updateDisplay() {
        pDisplayDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(pMonth + 1).append("/")
                        .append(pDay).append("/")
                        .append(pYear).append(" "));
    }

    private void displayToast() {
        Toast.makeText(this, new StringBuilder().append("Date choosen is ").append(pDisplayDate.getText()),  Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spin =(Spinner) findViewById(R.id.Nationality_spinner);
        spin2 = (Spinner) findViewById(R.id.country_spinner);

        pDisplayDate = (TextView) findViewById(R.id.displayDate);
        pPickDate = (Button) findViewById(R.id.pickDate);

        pPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        final Calendar cal = Calendar.getInstance();
        pYear = cal.get(Calendar.YEAR);
        pMonth = cal.get(Calendar.MONTH);
        pDay = cal.get(Calendar.DAY_OF_MONTH);

        updateDisplay();


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Nationality);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        ArrayAdapter bb = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Country);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(bb);

    }

    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        pDateSetListener,
                        pYear, pMonth, pDay);
        }
        return null;
    }
}
