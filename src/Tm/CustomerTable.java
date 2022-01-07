package Tm;

public class CustomerTable {
    private String Id ;
    private String Name ;
    private String Address ;;
    private String NIC ;
    private String Contact ;

    public CustomerTable() {
    }

    public CustomerTable(String id, String name, String address, String NIC, String contact) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setNIC(NIC);
        this.setContact(contact);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }
}
