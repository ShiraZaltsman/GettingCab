package com.example.shira.control;

import android.Manifest;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TimePicker;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;



import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import entities.Ride;
import model.datasource.Firebase_DBManager;

public class DetailRideActivity extends AppCompatActivity implements View.OnClickListener {
    boolean istValidText;
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText phoneEdit;
    private EditText startEdit;
    private EditText locationEdit;
    private EditText DestinationEdit;
    private Button button_Done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ride);
        findViews();
    }

    private void findViews() {
        button_Done = (Button) findViewById(R.id.buttonDone);
        nameEdit = (EditText) findViewById(R.id.clientNameStr);
        emailEdit = (EditText) findViewById(R.id.emailAddStr);
        phoneEdit = (EditText) findViewById(R.id.phoneNumStr);
        startEdit = (EditText) findViewById(R.id.PickUpTimeText);
        locationEdit = (EditText) findViewById(R.id.loctionAddress);
        DestinationEdit = (EditText) findViewById(R.id.destinationTtext);
        button_Done.setOnClickListener(this);
    }

    //thats important incase we create more than one button. And we will create.
    @Override
    public void onClick(View v) {

        validate();// chack if data is valid befor saving
        if (v == button_Done) {

            if (istValidText) {
                Firebase_DBManager tmp = new Firebase_DBManager();

                Ride newRide = new Ride();
                newRide.setClientName(nameEdit.getText().toString());
                newRide.setClientPhoneNumber(phoneEdit.getText().toString());
                newRide.setClientEmail(emailEdit.getText().toString());
                newRide.setStartTime(startEdit.getText().toString());
                newRide.setStartPoint(locationEdit.getText().toString());
                newRide.setEndPoint(DestinationEdit.getText().toString());
                tmp.addRide(newRide, new Firebase_DBManager.Action<Long>() {
                    @Override
                    public void onSuccess(Long obj) {

                    }

                    @Override
                    public void onFailure(Exception exception) {

                    }

                    @Override
                    public void onProgress(String status, double percent) {

                    }
                });
            }
        }
    }

    void validate() {
        istValidText = true;
        //checking correctness of email address
        if (emailEdit.getText().length() > 0) {
            String email = emailEdit.getText().toString();
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email);
            if (!m.matches()) {
                emailEdit.setError("Invalid email address");
                istValidText = false;
            }
        }
        //checking correctness of phone number
        if (phoneEdit.getText().length() > 0) {
            if (phoneEdit.getText().toString().length() != 10) {
                phoneEdit.setError("Invalid phone number");
                istValidText = false;
            }
        }
    }
}



