package model.backend;
import java.util.ArrayList;
import entities.Ride;

public interface Backend {


    /*1)*/
    public void addRide(Ride ride) throws Exception;

    /*2)*/
    public void deleteRide(long rideID) throws Exception;

    /*3)*/
    public void updateRide(Ride ride) throws Exception;

    /*4)*/ public ArrayList<Ride> getRideList () throws Exception;

}