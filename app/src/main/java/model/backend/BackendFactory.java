package model.backend;
import android.content.Context;
//import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public final class BackendFactory {
    /*1)*/ static Backend instance = null;

    /*2)*/ public static String mode = "firebase";

    /*3)*/   FirebaseDatabase database=FirebaseDatabase.getInstance();
    public final static Backend getInstance() {

        if (mode == "firebase") {
            if (instance == null)
                instance = (Backend) FirebaseDatabase.getInstance();
            return instance;
        }
        else {
            return null;
        }
    }
}

