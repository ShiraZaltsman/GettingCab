package model.backend;
import java.util.ArrayList;
import entities.Ride;
import model.datasource.Action;
import model.datasource.Firebase_DBManager;

public interface Backend {


    /*1)*/
     void addRide(final Ride ride, final Firebase_DBManager.Action<Long> action);
    //void addRide(Ride ride, final Action<String> action) throws Exception;



}