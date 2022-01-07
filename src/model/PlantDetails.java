package model;

public class PlantDetails {
    private String plantCode;
    private double unitPrice;
    private int qtyForSell;

    public PlantDetails() {
    }

    public PlantDetails(String plantCode, double unitPrice, int qtyForSell) {
        this.plantCode = plantCode;
        this.unitPrice = unitPrice;
        this.qtyForSell = qtyForSell;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyForSell() {
        return qtyForSell;
    }

    public void setQtyForSell(int qtyForSell) {
        this.qtyForSell = qtyForSell;
    }

    @Override
    public String toString() {
        return "PlantDetails{" +
                "plantCode='" + plantCode + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyForSell=" + qtyForSell +
                '}';
    }
}
