package model.datasource;
import model.backend.Backend;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.ArrayList;
import entities.Ride;
import model.backend.BackendFactory;

public class Firebase_DBManager implements Backend{


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

    /*
     * Insert Ride with the data from the user to firebase database
     * @param ride - the ride initialized with user's data.
     * @param action - implementation of Action interface, which defines what will happen in the insertion of the data
     * @throws Exception when succeded or failed.
     *********************************************** it should be static, but i can't do it for some reason...
     * */
    public void addRide(final Ride ride, final Action<Long> action) {

        String key=((Long)ride.getRideID()).toString();

        RidesRef.child(key).setValue(ride).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                action.onSuccess(ride.getRideID());
                action.onProgress("upload ride data", 100);
            }
        }).addOnFailureListener( new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                action.onFailure(e);
                action.onProgress("error upload ride data", 100);
            }
        });
    }

}

