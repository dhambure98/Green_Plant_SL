package controller;

import db.DbConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    public static boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?)");
        pstm.setObject(1, customer.getcId());
        pstm.setObject(2, customer.getcName());
        pstm.setObject(3, customer.getcAddress());
        pstm.setObject(4, customer.getNIC());
        pstm.setObject(5, customer.getcContact());
        return pstm.executeUpdate() > 0;
    }

    public static List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Customer");
        ResultSet rs = pstm.executeQuery();

        List<Customer> customers = new ArrayList<>();

        while (rs.next()) {
            customers.add(new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            ));
        }

        return customers;
    }

    public static List<Customer> searchCustomer(String value) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Customer WHERE cName LIKE '%" + value + "%'");
        ResultSet rs = pstm.executeQuery();
        List<Customer> customer = new ArrayList<>();

        while (rs.next()) {
            customer.add(new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            ));
        }

        return customer;
    }

    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("DELETE FROM Customer WHERE cId=?");
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }

    public static boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("UPDATE Customer SET cName=?, cAddress=?, NIC=?, cContact=? WHERE cId=?");
        pstm.setObject(1, customer.getcName());
        pstm.setObject(2, customer.getcAddress());
        pstm.setObject(3, customer.getNIC());
        pstm.setObject(4, customer.getcContact());
        pstm.setObject(5, customer.getcId());
        return pstm.executeUpdate() > 0;
    }

    public static Customer searchCustomerOnNic(String nic) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Customer WHERE CONCAT(NIC)=?");
        stm.setObject(1, nic);

        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );

        } else {
            return null;
        }
    }

//    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {
//        ResultSet rst = DbConnection.getInstance().
//                getConnection().prepareStatement("SELECT * FROM Customer").executeQuery();
//        List<String> ids = new ArrayList<>();
//        while (rst.next()) {
//            ids.add(
//                    rst.getString(1)
//            );
//        }
//        return ids;
//    }
}
