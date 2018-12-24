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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.Gravity;
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
import android.widget.Toast;

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
        //enables adRide Button only if all the textboxes are filled in
        if (!(nameEdit.getText().length() == 0 || phoneEdit.getText().length() == 0|| startEdit.getText().length() == 0
                || emailEdit.getText().length() == 0 || locationEdit.getText().length() == 0 || DestinationEdit.getText().length() == 0  ))
        {
            button_Done.setEnabled(true);
        }
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
        button_Done.setEnabled(false);//will be enable when all fields will be filled

        nameEdit.addTextChangedListener(DetailTextWatcher);
        emailEdit.addTextChangedListener(DetailTextWatcher);
        phoneEdit.addTextChangedListener(DetailTextWatcher);
        startEdit.addTextChangedListener(DetailTextWatcher);
        locationEdit.addTextChangedListener(DetailTextWatcher);
        DestinationEdit.addTextChangedListener(DetailTextWatcher);

    }

    //this func activait when  any text change and enable "done" button when all fields has new text in them
private TextWatcher DetailTextWatcher=new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String nameInput=nameEdit.getText().toString().trim();
        String phoneInput =phoneEdit.getText().toString().trim();
        String emailInput=emailEdit.getText().toString().trim();
        String timeInput=startEdit.getText().toString().trim();
        String locInput = locationEdit.getText().toString().trim();
        String DesInput = DestinationEdit.getText().toString().trim();
        if (!locInput.isEmpty())
        {
            Toast toastM =Toast.makeText(DetailRideActivity.this, "current location",
                    Toast.LENGTH_SHORT);

            toastM.setGravity(Gravity.END, 0, 0);
            toastM.show();
        }
        button_Done.setEnabled(!(nameInput.isEmpty() || phoneInput.isEmpty() || emailInput.isEmpty() ||timeInput.isEmpty() ||locInput.isEmpty() ||DesInput.isEmpty()));
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
};
    //thats important incase we create more than one button. And we will create.
    @Override
    public void onClick(View v) {


        if (v == button_Done) {
            istValidText = false;
            validate();// chack if data is valid befor saving
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

                Toast toast =Toast.makeText(DetailRideActivity.this, "Your cab is on the way!",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
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



