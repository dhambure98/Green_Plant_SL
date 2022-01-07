package controller;

import db.DbConnection;
import model.Plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantController {
    public static boolean savePlant(Plant plant) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Plant VALUES(?,?,?,?,?,?,?)");
        pstm.setObject(1, plant.getPlaId());
        pstm.setObject(2, plant.getPlaName());
        pstm.setObject(3, plant.getPlaType());
        pstm.setObject(4, plant.getPlaQty());
        pstm.setObject(5, plant.getPlaCategory());
        pstm.setObject(6, plant.getPlaDescription());
        pstm.setObject(7, plant.getPlaPrice());
        return pstm.executeUpdate() > 0;
    }

    public static List<Plant> getAllPlant() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Plant");
        ResultSet rs = pstm.executeQuery();

        List<Plant> plants = new ArrayList<>();

        while (rs.next()) {
            plants.add(new Plant(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDouble(7)
            ));
        }

        return plants;
    }

    public static List<Plant> searchPlant(String value) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Plant WHERE plantName LIKE '%" + value + "%'");
        ResultSet rs = pstm.executeQuery();
        List<Plant> plants = new ArrayList<>();

        while (rs.next()) {
            plants.add(new Plant(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDouble(7)
            ));
        }
        return plants;
    }

    public List<String> getAllPlantIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().
                prepareStatement("SELECT * FROM Plant").executeQuery();
        List<String> ids= new ArrayList<>();
        while (rst.next()){
            ids.add(
                    rst.getString(1)
            );
        }
        return ids;
    }

    public Plant getPlant(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Plant WHERE plantId='" + id + "'").executeQuery();
        if (rs.next()){
            return new Plant(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDouble(7)
            );
        }else{
            return null;
        }
    }

    public static boolean deletePlant(String id) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("DELETE FROM Plant WHERE plantId=?");
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }
}
