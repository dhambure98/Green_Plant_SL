package model;

public class Delivery {
    private String delId;
    private String delDate;
    private String delTime;
    private String delStatus;

    public Delivery() {
    }

    public Delivery(String delId, String delDate, String delTime, String delStatus) {
        this.delId = delId;
        this.delDate = delDate;
        this.delTime = delTime;
        this.delStatus = delStatus;
    }

    public String getDelId() {
        return delId;
    }

    public void setDelId(String delId) {
        this.delId = delId;
    }

    public String getDelDate() {
        return delDate;
    }

    public void setDelDate(String delDate) {
        this.delDate = delDate;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }
}
