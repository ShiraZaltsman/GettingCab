package model.backend;
import android.content.Context;
public final class BackendFactory {
    /*1)*/ static Backend instance = null;

    /*2)*/ public static String
            mode = "lists";

    /*3)*/
    public final static Backend

    getInstance(Context context) {
        /*3.1)*/
        if (mode == "lists") {
            if (instance == null)
                instance = new model.datasource.DatabaseList();
            return instance;
        }
        /*3.2)*/
        if (mode == "sql") {
            if (instance == null)
                // instance = new model.datasource.DatabaseSqlite(context);
                return instance;
        }
        /*3.3)*/
        if (mode == "Service") {
            if (instance == null)
                //    instance = new model.datasource.DatabeseService();
                return instance;
        } else {
            return null;
        }
        return null;
    }
}
