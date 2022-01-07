package Tm;

public class DeliveryTable {
    private String Id;
    private String Date;
    private String Time;
    private String Status;

    public DeliveryTable() {
    }

    public DeliveryTable(String id, String date, String time, String status) {
        this.Id = id;
        this.Date = date;
        this.Time = time;
        this.Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


}
