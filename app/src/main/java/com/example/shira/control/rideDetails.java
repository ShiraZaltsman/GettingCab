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

public class rideDetails extends AppCompatActivity implements View.OnClickListener{

 /*   public void showTimePickerDialog(View view) {
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }*/


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
        setContentView(R.layout.activity_ride_details);
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
    }

    //thats important incase we create more than one button. And we will create.
    @Override
    public void onClick(View v){
        if (v == button_Done)
        {
            Firebase_DBManager tmp=new Firebase_DBManager();
            Ride newRide=new Ride();
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

