package model.datasource;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Ride;
import model.backend.Backend;

public class Firebase_DBManager implements Backend {
        public interface Action<T> {
            void onSuccess(T obj);

            void onFailure(Exception exception);

            void onProgress(String status, double percent);
        }

        public interface NotifyDataChange<T> {
            void OnDataChanged(T obj);

            void onFailure(Exception exception);
        }

    static DatabaseReference RidesRef;
    static List<Ride> RideList;

    static {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        RidesRef = database.getReference("rides");
        RideList = new ArrayList<>();

    }
    @Override
    //public static void addRide(final Ride ride, final Action<Long> action) לא עובד עם static
    public void addRide(final Ride ride, final Action<Long> action)
    {
        String key = Long.toString(ride.getRideID());
        RidesRef.child(key).setValue(ride).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                action.onSuccess(ride.getRideID());
                action.onProgress("upload ride data", 100);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                action.onFailure(e);
                action.onProgress("error upload ride data", 100);
            }
        });
    }
   //אין לי מושג מה זה בירוק, יש מצב שזה מה שהעתקתי מהOSF ושיניתי את השנות כדי שיתאים לנו, או שזה מה שאת עשית, בכל מקרה אחרי העדכון זה היה לי הכול בהערות


  /** static DatabaseReference rideRef;
    static {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        rideRef = database.getReference("rides");
    }
   @Override
   public void addRide(final Ride ride, final Action<String> action) throws Exception {
       final Map<String, Object> dataMap = new HashMap<String, Object>();
       rideRef.push().setValue(ride).addOnSuccessListener(new OnSuccessListener<Void>() {
           @Override
           public void onSuccess(Void aVoid) {
               action.onSuccess(" insert ride");
               action.onProgress("upload ride data", 100);
           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               action.onFailure(e);
               action.onProgress("error upload ride data", 100);

           }
       });**/
       //זה העתקתי מרחלי ושזה נראה בסדר בנתיים
   }


