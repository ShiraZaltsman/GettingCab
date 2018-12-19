package model.datasource;

import java.util.ArrayList;

import entities.Ride;
import model.backend.Backend;

public class DatabaseList implements Backend {

    @Override
    public void addRide(Ride ride) throws Exception {
       // for (Ride rideItem : rides)
            
    }

    @Override
    public void deleteRide(long rideID) throws Exception {

    }

    @Override
    public void updateShop(Ride ride) throws Exception {

    }

    @Override
    public ArrayList<Ride> getRideList() throws Exception {
        return null;
    }
}
