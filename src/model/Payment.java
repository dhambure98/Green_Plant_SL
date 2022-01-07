package model;

public class Payment {
    private String id;
    private String paymentId;
    private Double salary;
    private String date;
    private String paymentType;

    public Payment() {
    }

    public Payment(String id, String paymentId, Double salary, String date, String paymentType) {
        this.id = id;
        this.paymentId = paymentId;
        this.salary = salary;
        this.date = date;
        this.paymentType = paymentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
