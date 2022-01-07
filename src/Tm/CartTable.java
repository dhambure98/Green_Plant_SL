package Tm;

public class CartTable {
     private String orderId;
     private String plaId;
     private int qty;
     private double unitPrice;
     private double total;

    public CartTable() {
    }

    public CartTable(String orderId, String plaId, int qty, double unitPrice, double total) {
        this.orderId = orderId;
        this.plaId = plaId;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPlaId() {
        return plaId;
    }

    public void setPlaId(String plaId) {
        this.plaId = plaId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartTable{" +
                "orderId='" + orderId + '\'' +
                ", plaId='" + plaId + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                '}';
    }
}
