package model;

public class Employee {
    private String empId;
    private String empName;
    private String empAddress;
    private String empContact;
    private String empType;
    private Double salary;

    public Employee() {
    }

    public Employee(String empId, String empName, String empAddress, String empContact, String empType, Double salary) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empContact = empContact;
        this.empType = empType;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpContact() {
        return empContact;
    }

    public void setEmpContact(String empContact) {
        this.empContact = empContact;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
