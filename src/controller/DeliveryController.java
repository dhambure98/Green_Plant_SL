package controller;

import db.DbConnection;
import model.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryController {
    public static List<Delivery> getAllDelivery() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Delivery");
        ResultSet rs = pstm.executeQuery();

        List<Delivery> deliveries = new ArrayList<>();

        while (rs.next()) {
            deliveries.add(new Delivery(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            ));
        }

        return deliveries;
    }

    public static boolean saveDelivery(Delivery delivery) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Delivery VALUES(?,?,?,?)");
        pstm.setObject(1, delivery.getDelId());
        pstm.setObject(2, delivery.getDelDate());
        pstm.setObject(3, delivery.getDelTime());
        pstm.setObject(4, delivery.getDelStatus());
        return pstm.executeUpdate() > 0;
    }

    public static boolean deleteDelivery(String id) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("DELETE FROM Delivery WHERE dId=?");
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }
}
