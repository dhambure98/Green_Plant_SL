package controller;

import Tm.SupplierTable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierFormController {
    public TextField id;
    public TextField name;
    public TextField address;
    public TextField company;
    public TextField contact;
    public TableView<SupplierTable> supTable;
    public TableColumn supId;
    public TableColumn supName;
    public TableColumn supAddress;
    public TableColumn supCompany;
    public TableColumn supContact;
    public TextField search;
    public Button btnAddSupplier;
    public Button btnUpdateSupplier;
    public Button btnDeleteSupplier;

    public void initialize() {
        supId.setCellValueFactory(new PropertyValueFactory<>("supId"));
        supName.setCellValueFactory(new PropertyValueFactory<>("supName"));
        supAddress.setCellValueFactory(new PropertyValueFactory<>("supAddress"));
        supCompany.setCellValueFactory(new PropertyValueFactory<>("supCompany"));
        supContact.setCellValueFactory(new PropertyValueFactory<>("supContact"));

        supTable.getColumns().setAll( supId , supName , supAddress , supCompany , supContact );

        loadData();

        search.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    List<Supplier> suppliers = SupplierController.searchSupplier(newValue);
                    loadTableData(suppliers);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void loadTableData(List<Supplier> allSupplier) {
        ObservableList<SupplierTable> tableData = FXCollections.observableArrayList();
        for (Supplier supplier : allSupplier) {
            tableData.add(new SupplierTable(
                    supplier.getSupId(),
                    supplier.getSupName(),
                    supplier.getSupAddress(),
                    supplier.getSupCompany(),
                    supplier.getSupContact()
            ));
            System.out.println(supplier.getSupId() + " ===== " + supplier.getSupName() + " ===== " + supplier.getSupAddress() + " ===== " + supplier.getSupCompany() + " ===== " + supplier.getSupContact() );
        }
        supTable.getItems().setAll(tableData);
    }

    private void loadData() {
        try {
            loadTableData( SupplierController.getAllSupplier());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addSupplierOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = SupplierController.saveSupplier(new Supplier(
                    id.getText(),
                    name.getText(),
                    address.getText(),
                    company.getText(),
                    Integer.parseInt(contact.getText())
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

    public void updateSupplierOnAction(ActionEvent actionEvent) {
    }

    public void deleteSupplierOnaction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = SupplierController.deleteSupplier(supTable.getSelectionModel().getSelectedItem().getSupId());
            if(isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Successful Delete .....").show();
                loadData();
            }else {
                new Alert(Alert.AlertType.WARNING,"Field Delete .....").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
