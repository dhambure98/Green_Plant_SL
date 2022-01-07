package Tm;

public class EmployeeTable {
    private String Id ;
    private String Name ;
    private String Address ;
    private String Contact ;
    private String Type ;
    private Double salary;

    public EmployeeTable() {
    }

    public EmployeeTable(String id, String name, String address, String contact, String type, Double salary) {
        Id = id;
        Name = name;
        Address = address;
        Contact = contact;
        Type = type;
        this.salary = salary;
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

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
