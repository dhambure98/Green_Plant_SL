package controller;

import Tm.DeliveryTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Delivery;

import java.sql.SQLException;
import java.util.List;

public class DeliveryFormController {
    public TextField id;
    public TextField date;
    public TextField time;
    public TextField status;
    public Button btnAddDeliver;
    public TableColumn delId;
    public TableColumn delDate;
    public TableColumn delTime;
    public TableColumn delStatus;
    public TableView delTable;
    public Button btnDeleteDelivery;

    public void initialize() {
        delId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        delDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        delTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        delStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

        delTable.getColumns().setAll( delId , delDate , delTime , delStatus );

        loadData();
    }

    private void loadTableData(List<Delivery> allDelivery) {
        ObservableList<DeliveryTable> tableData = FXCollections.observableArrayList();
        for (Delivery delivery : allDelivery) {
            tableData.add(new DeliveryTable(
                    delivery.getDelId(),
                    delivery.getDelDate(),
                    delivery.getDelTime(),
                    delivery.getDelStatus()
            ));
            System.out.println(delivery.getDelId() + " ===== " + delivery.getDelDate() + " ===== " + delivery.getDelTime() + " ===== " + delivery.getDelStatus() );
        }
        delTable.getItems().setAll(tableData);
    }

    private void loadData() {
        try {
            loadTableData( DeliveryController.getAllDelivery());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addDeliverOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = DeliveryController.saveDelivery(new Delivery(
                    id.getText(),
                    date.getText(),
                    time.getText(),
                    status.getText()
            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Success").show();
                loadData();

            }else {
                new Alert(Alert.AlertType.WARNING,"Failed").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteDeliveryOnAction(ActionEvent actionEvent) {
//        try {
//            boolean isDeleted = DeliveryController.deleteDelivery(delTable.getSelectionModel().getSelectedItem().getId());
//            if(isDeleted){
//                new Alert(Alert.AlertType.INFORMATION,"Successful Delete .....").show();
//                loadData();
//            }else {
//                new Alert(Alert.AlertType.WARNING,"Field Delete .....").show();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
//        }
    }
}
