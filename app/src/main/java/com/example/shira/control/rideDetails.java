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

public class rideDetails extends AppCompatActivity {

    public void showTimePickerDialog(View view) {
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
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_details);

        Button button_Done = (Button) findViewById(R.id.buttonDone);
        Button button_TimePick = (Button) findViewById(R.id.PickTimeButton);
        final EditText nameEdit   = (EditText)findViewById(R.id.clientNameStr);
        final EditText emailEdit   = (EditText)findViewById(R.id.emailAddStr);
        final EditText phoneEdit   = (EditText)findViewById(R.id.phoneNumStr);
        final EditText startEdit   = (EditText)findViewById(R.id.PickUpTimeText);
        final EditText locationEdit   = (EditText)findViewById(R.id.loctionAddress);
        final EditText DestinationEdit   = (EditText)findViewById(R.id.destinationTtext);
        button_Done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Ride newRide=new Ride();
                        newRide.setClientName(nameEdit.getText().toString());
                        newRide.setClientPhoneNumber(phoneEdit.getText().toString());
                        newRide.setClientEmail(emailEdit.getText().toString());
                        newRide.setStartTime(startEdit.getText().toString());
                        newRide.setStartPoint(locationEdit.getText().toString());
                        newRide.setEndPoint(DestinationEdit.getText().toString());
                        //SimpleDateFormat sdf=new SimpleDateFormat("kk:mm");
                        //newRide.setStartTime(sdf.parse(startEdit.).getTime());

                    }
                });





            }

        }

