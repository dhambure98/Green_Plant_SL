package model;

import java.util.Objects;

public class Plant {
    private String plaId;
    private String plaName;
    private String plaType;
    private Integer plaQty;
    private String plaCategory;
    private String plaDescription;
    private Double plaPrice;

    public Plant() {

    }

    public Plant(String plaId, String plaName, String plaType, Integer plaQty, String plaCategory, String plaDescription, Double plaPrice) {
        this.plaId = plaId;
        this.plaName = plaName;
        this.plaType = plaType;
        this.plaQty = plaQty;
        this.plaCategory = plaCategory;
        this.plaDescription = plaDescription;
        this.plaPrice = plaPrice;
    }

    public String getPlaId() {
        return plaId;
    }

    public void setPlaId(String plaId) {
        this.plaId = plaId;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public String getPlaType() {
        return plaType;
    }

    public void setPlaType(String plaType) {
        this.plaType = plaType;
    }

    public Integer getPlaQty() {
        return plaQty;
    }

    public void setPlaQty(Integer plaQty) {
        this.plaQty = plaQty;
    }

    public String getPlaCategory() {
        return plaCategory;
    }

    public void setPlaCategory(String plaCategory) {
        this.plaCategory = plaCategory;
    }

    public Double getPlaPrice() {
        return plaPrice;
    }

    public void setPlaPrice(Double plaPrice) {
        this.plaPrice = plaPrice;
    }

    public String getPlaDescription() {
        return plaDescription;
    }

    public void setPlaDescription(String plaDescription) {
        this.plaDescription = plaDescription;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "plaId='" + plaId + '\'' +
                ", plaName='" + plaName + '\'' +
                ", plaType='" + plaType + '\'' +
                ", plaQty=" + plaQty +
                ", plaCategory='" + plaCategory + '\'' +
                ", plaPrice=" + plaPrice +
                ", plaDescription='" + plaDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Objects.equals(plaId, plant.plaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plaId);
    }
}
