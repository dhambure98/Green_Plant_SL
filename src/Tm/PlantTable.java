package Tm;

public class PlantTable {
    private String plaId;
    private String plaName;
    private String plaType;
    private Integer plaQty;
    private String plaCategory;
    private Double plaPrice;
    private String plaDescription;

    public PlantTable() {
    }

    public PlantTable(String plaId, String plaName, String plaType, Integer plaQty, String plaCategory, Double plaPrice, String plaDescription) {
        this.setPlaId(plaId);
        this.setPlaName(plaName);
        this.setPlaType(plaType);
        this.setPlaQty(plaQty);
        this.setPlaCategory(plaCategory);
        this.setPlaPrice(plaPrice);
        this.setPlaDescription(plaDescription);
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
}
