package model.datasource;
import model.backend.Backend;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.ArrayList;
import entities.Ride;
import model.backend.BackendFactory;

/*public class Firebase_DBManager implements Backend{


        public interface Action<T> {
            void onSuccess(T obj);

            void onFailure(Exception exception);

            void onProgress(String status, double percent);
        }

        public interface NotifyDataChange<T> {
            void OnDataChanged(T obj);

            void onFailure(Exception exception);
        }


    static private DatabaseReference RidesRef;
    static public List<Ride> RideList;
    static Backend iBeckecnd;

    static {
        FirebaseDatabase database= (FirebaseDatabase) BackendFactory.getInstance();
        RidesRef=database.getReference("Rides");
        RideList = new ArrayList<>();
    }


    private static void addRideToFirebase(final Ride ride, final Action<Long> action) {
        long key =ride.getRideID();
        RidesRef.child(key).setValue(student).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                action.onSuccess(student.getId());
                action.onProgress("upload student data", 100);
            }
        }).addOnFailureListener( new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                action.onFailure(e);
                action.onProgress("error upload student data", 100);
            }
        });
    }

}*/

