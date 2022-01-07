package model;

public class User {
    private String id;
    private String empId;
    private String userName;
    private String password;
    private String type;

    public User(String id, String empId, String userName, String password, String type) {
        this.id = id;
        this.empId = empId;
        this.userName = userName;
        this.password = password;
        this.setType(type);
    }

    public User() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
