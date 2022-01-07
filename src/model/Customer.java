package model;

public class Customer {
    private String cId ;
    private String cName ;
    private String cAddress ;
    private String NIC ;
    private String cContact ;

    public Customer() {
    }

    public Customer(String cId, String cName, String cAddress, String NIC, String cContact) {
        this.setcId(cId);
        this.setcName(cName);
        this.setcAddress(cAddress);
        this.setNIC(NIC);
        this.setcContact(cContact);
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getcContact() {
        return cContact;
    }

    public void setcContact(String cContact) {
        this.cContact = cContact;
    }
}
