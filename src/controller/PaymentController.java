package controller;

import db.DbConnection;
import model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentController {
    public static List<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Employee_payment");
        ResultSet rs = pstm.executeQuery();

        List<Payment> payments = new ArrayList<>();

        while (rs.next()) {
            payments.add(new Payment(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getString(5)
            ));
        }

        return payments;
    }

    public static boolean savePayment(Payment payment) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Employee_payment VALUES(?,?,?,?,?)");
        pstm.setObject(1, payment.getPaymentId());
        pstm.setObject(2, payment.getId());
        pstm.setObject(3, payment.getSalary());
        pstm.setObject(4, payment.getDate());
        pstm.setObject(5, payment.getPaymentType());
        return pstm.executeUpdate() > 0;
    }
}
