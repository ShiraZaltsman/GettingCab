package entities;

        import java.text.SimpleDateFormat;
enum RideStatus {Available,InProcess,Done};

public class Ride {
    private int RideID;//זה מספר רץ שהקונסטרקטור מכניס
    private RideStatus Status;
    private String StartPoint;
    private String EndPoint;
    private SimpleDateFormat StartTime = new SimpleDateFormat("kk:mm:ss");
    private SimpleDateFormat EndTime = new SimpleDateFormat("kk:mm:ss");
    private String ClientName;
    private long ClientPhoneNumber;
    private String ClientEmail;

    public Ride() {
        RideID = 0;//לטפל בזה
        this.Status = RideStatus.Available;//צריך לבדוק איך זה עובד
        this.StartPoint = "";
        this.EndPoint = "";
        this.StartTime = new SimpleDateFormat("00:00:00");
        this.EndTime = new SimpleDateFormat("00:00:00");
        this.ClientName = "";
        this.ClientPhoneNumber = 0;
        this.ClientEmail = "";
    }
    public Ride( RideStatus status, String startPoint, String endPoint, SimpleDateFormat startTime, SimpleDateFormat endTime, String clientName, long clientPhoneNumber, String clientEmail) {
        RideID = 0;//לטפל בזה
        Status = status;
        StartPoint = startPoint;
        EndPoint = endPoint;
        StartTime = startTime;
        EndTime = endTime;
        ClientName = clientName;
        ClientPhoneNumber = clientPhoneNumber;
        ClientEmail = clientEmail;
    }

    public int getRideID() {
        return RideID;
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

    public SimpleDateFormat getStartTime() {
        return StartTime;
    }
    public void setStartTime(SimpleDateFormat startTime) {
        StartTime = startTime;
    }

    public SimpleDateFormat getEndTime() {
        return EndTime;
    }
    public void setEndTime(SimpleDateFormat endTime) {
        EndTime = endTime;
    }

    public String getClientName() {
        return ClientName;
    }
    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public long getClientPhoneNumber() {
        return ClientPhoneNumber;
    }
    public void setClientPhoneNumber(long clientPhoneNumber) {
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
        return (RideID == ride.getRideID() &&
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

