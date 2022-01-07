package controller;

import db.DbConnection;
import model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierController {
    public static List<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Supplier");
        ResultSet rs = pstm.executeQuery();

        List<Supplier> suppliers = new ArrayList<>();

        while (rs.next()) {
            suppliers.add(new Supplier(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5)
            ));
        }

        return suppliers;
    }

    public static boolean saveSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Supplier VALUES(?,?,?,?,?)");
        pstm.setObject(1, supplier.getSupId());
        pstm.setObject(2, supplier.getSupName());
        pstm.setObject(3, supplier.getSupAddress());
        pstm.setObject(4, supplier.getSupCompany());
        pstm.setObject(5, supplier.getSupContact());
        return pstm.executeUpdate() > 0;
    }

    public static List<Supplier> searchSupplier(String value) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Supplier WHERE supName LIKE '%" + value + "%'");
        ResultSet rs = pstm.executeQuery();
        List<Supplier> suppliers = new ArrayList<>();

        while (rs.next()) {
            suppliers.add(new Supplier(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5)
            ));
        }

        return suppliers;
    }

    public static boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("DELETE FROM Supplier WHERE supId=?");
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }
}
