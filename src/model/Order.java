package model;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private String customerId;
    private String orderDate;
    private String orderTime;
    private double cost;
    private ArrayList<PlantDetails> plants;

    public Order() {
    }

    public Order(String orderId, String customerId, String orderDate, String orderTime, double cost, ArrayList<PlantDetails> plants) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.cost = cost;
        this.plants = plants;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<PlantDetails> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<PlantDetails> plants) {
        this.plants = plants;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", cost=" + cost +
                ", plants=" + plants +
                '}';
    }
}
