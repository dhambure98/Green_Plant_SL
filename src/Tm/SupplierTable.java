package Tm;

public class SupplierTable {
    private String supId;
    private String supName;
    private String supAddress;
    private String supCompany;
    private Integer supContact;

    public SupplierTable() {
    }

    public SupplierTable(String supId, String supName, String supAddress, String supCompany, Integer supContact) {
        this.supId = supId;
        this.supName = supName;
        this.supAddress = supAddress;
        this.supCompany = supCompany;
        this.supContact = supContact;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public String getSupCompany() {
        return supCompany;
    }

    public void setSupCompany(String supCompany) {
        this.supCompany = supCompany;
    }

    public Integer getSupContact() {
        return supContact;
    }

    public void setSupContact(Integer supContact) {
        this.supContact = supContact;
    }







}
