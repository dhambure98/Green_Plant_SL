package Tm;

public class PaymentTable {
    private String paymentId;
    private String id;
    private Double salary;
    private String date;
    private String paymentMethord;

    private PaymentTable() {
    }

    public PaymentTable(String paymentId, String id, Double salary, String date, String paymentMethord) {
        this.paymentId = paymentId;
        this.id = id;
        this.salary = salary;
        this.date = date;
        this.paymentMethord = paymentMethord;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPaymentMethord() {
        return paymentMethord;
    }

    public void setPaymentMethord(String paymentMethord) {
        this.paymentMethord = paymentMethord;
    }
}
