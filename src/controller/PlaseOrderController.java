package controller;

import db.DbConnection;
import model.Plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaseOrderController {
//    public String getPlantId() throws SQLException, ClassNotFoundException {
//        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT plantId FROM Plant ORDER BY plantId DESC LIMIT 1"
//        ).executeQuery();
//        if (rst.next()){
//
//            int tempId = Integer.
//                    parseInt(rst.getString(1).split("-")[1]);
//            tempId=tempId+1;
//            if (tempId<9){
//                return "P-00"+tempId;
//            }else if(tempId<99){
//                return "P-0"+tempId;
//            }else{
//                return "P-"+tempId;
//            }
//
//        }else{
//            return "P-001";
//        }
//    }

//    public boolean placePlant(Plant plant) {
//        Connection con=null;
//        try {
//            con= DbConnection.getInstance().getConnection();
//            con.setAutoCommit(false);
//            PreparedStatement stm =con.prepareStatement("INSERT INTO Plant VALUES(?,?,?,?)");
//
//            stm.setObject(1, rent.getRentId());
//            stm.setObject(2, rent.getCustomerId());
//            stm.setObject(3, rent.getRentDate());
//            stm.setObject(4, rent.getRentTime());
//
//            if (stm.executeUpdate() > 0){
//                if (saveRentDetail(rent.getRentId(), rent.getItems())){
//                    con.commit();
//                    return true;
//                }else{
//                    con.rollback();
//                    return false;
//                }
//            }else{
//                con.rollback();
//                return false;
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//
//                con.setAutoCommit(true);
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//
//        return false;
//    }
}
