package entities;

import java.text.SimpleDateFormat;
enum RideStatus {Available,InProcess,Done};

public class Ride {

    private  static long RideID=0;//זה מספר רץ שהקונסטרקטור מכניס
    public static long generateId() {
        return ++RideID;
    }

    private long rideID;
    private RideStatus Status;
    private String StartPoint;
    private String EndPoint;
    private String StartTime;
    private String EndTime;
    private String ClientName;
    private String ClientPhoneNumber;
    private String ClientEmail;

    public Ride() {
        this.generateId();
        this.rideID = RideID;
        this.Status = RideStatus.Available;//צריך לבדוק איך זה עובד
        this.StartPoint = "";
        this.EndPoint = "";
        this.StartTime ="";
        this.EndTime = "";
        this.ClientName = "";
        this.ClientPhoneNumber ="";
        this.ClientEmail = "";
    }
    public Ride( RideStatus status, String startPoint, String endPoint, String startTime, String endTime, String clientName, String clientPhoneNumber, String clientEmail) {
        rideID = RideID;
        Status = status;
        StartPoint = startPoint;
        EndPoint = endPoint;
        StartTime = startTime;
        EndTime = endTime;
        ClientName = clientName;
        ClientPhoneNumber = clientPhoneNumber;
        ClientEmail = clientEmail;
    }

    public long getRideID() {
        return rideID;
    }

    public RideStatus getStatus() {
        return Status;
    }
    public void setStatus(RideStatus status) {
        Status = status;
    }

    public String getStartPoint() {
        return StartPoint;
    }
    public void setStartPoint(String startPoint) {
        StartPoint = startPoint;
    }

    public String getEndPoint() {
        return EndPoint;
    }
    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public String getStartTime() {
        return StartTime;
    }
    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }
    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getClientName() {
        return ClientName;
    }
    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientPhoneNumber() {
        return ClientPhoneNumber;
    }
    public void setClientPhoneNumber(String clientPhoneNumber) {
        ClientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return ClientEmail;
    }
    public void setClientEmail(String clientEmail) {
        ClientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Ride ride = (Ride) obj;
        return (
                rideID == ride.getRideID() &&
                ClientEmail == ride.getClientEmail()&&
                StartPoint==ride.getStartPoint()&&
                EndPoint==ride.getEndPoint()&&
                ClientName==ride.getClientName()&&
                StartTime==ride.getStartTime()&&
                EndTime==ride.getEndTime()&&
                Status==ride.getStatus()&&
                ClientPhoneNumber==ride.getClientPhoneNumber()
        );
    }

}

//test

