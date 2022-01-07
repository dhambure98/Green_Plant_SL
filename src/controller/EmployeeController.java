package controller;

import db.DbConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    public static List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Employee");
        ResultSet rs = pstm.executeQuery();

        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            employees.add(new Employee(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDouble(6)
            ));
        }

        return employees;
    }

    public static boolean saveEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?,?)");
        pstm.setObject(1, employee.getEmpId());
        pstm.setObject(2, employee.getEmpName());
        pstm.setObject(3, employee.getEmpAddress());
        pstm.setObject(4, employee.getEmpContact());
        pstm.setObject(5, employee.getEmpType());
        pstm.setObject(6, employee.getSalary());
        return pstm.executeUpdate() > 0;
    }

    public static List<Employee> searchEmployee(String value) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Employee WHERE empName LIKE '%" + value + "%'");
        ResultSet rs = pstm.executeQuery();
        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            employees.add(new Employee(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDouble(6)
            ));
        }

        return employees;
    }

    public static boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("DELETE FROM Employee WHERE empId=?");
        pstm.setObject(1,id);
        return pstm.executeUpdate() > 0;
    }
}
