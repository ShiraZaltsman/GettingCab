package model.datasource;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import entities.Ride;

public class Firebase_DBManager {
   /** public class Firebase_DBManager {
        public interface Action<T> {
            void onSuccess(T obj);

            void onFailure(Exception exception);

            void onProgress(String status, double percent);
        }

        public interface NotifyDataChange<T> {
            void OnDataChanged(T obj);

            void onFailure(Exception exception);
        }
    }

    static DatabaseReference RidesRef;
    static List<Ride> RideList;

    static {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        RidesRef = database.getReference("rides");
        RideList = new ArrayList<>();
    }
    private static void addRideToFirebase(final Ride ride, final Action<Long> action)
    {
        String key = ride.getRideID().toString();
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
    }**/
}

