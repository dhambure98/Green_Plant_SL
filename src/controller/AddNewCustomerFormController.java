package controller;

import Tm.CustomerTable;
import db.DbConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Customer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.util.List;

public class AddNewCustomerFormController {

    public TextField id;
    public TextField name;
    public TextField nic;
    public TextField tp;
    public TableView<CustomerTable> cusTable;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colNic;
    public TableColumn colTp;
    public TextArea address;
    public TextField search;
    public Button btnCustomerReport;
    public Button btnAddCustomer;
    public Button btnUpdateCustomer;

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colTp.setCellValueFactory(new PropertyValueFactory<>("Contact"));

        cusTable.getColumns().setAll(colId, colName, colAddress, colNic, colTp);

        loadData();

        search.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    List<Customer> customer = CustomerController.searchCustomer(newValue);
                    loadTableData(customer);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void loadTableData(List<Customer> allCustomers) {
        ObservableList<CustomerTable> tableData = FXCollections.observableArrayList();
        for (Customer customer : allCustomers) {
            tableData.add(new CustomerTable(
                    customer.getcId(),
                    customer.getcName(),
                    customer.getcAddress(),
                    customer.getNIC(),
                    customer.getcContact()
            ));
            System.out.println(customer.getcId() + " ===== " + customer.getcName() + " ===== " + customer.getcAddress() + " ===== " + customer.getNIC() + " ===== " + customer.getcContact() + " ===== ");
        }
        cusTable.getItems().setAll(tableData);
    }

    public void loadData() {
        try {
            loadTableData(CustomerController.getAllCustomers());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addCustomerOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = CustomerController.saveCustomer(new Customer(
                    id.getText(),
                    name.getText(),
                    address.getText(),
                    nic.getText(),
                    tp.getText()
            ));
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Success").show();
                loadData();

            } else {
                new Alert(Alert.AlertType.WARNING, "Failed").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void customerReportEvent(MouseEvent mouseEvent) {
//        try {
//            /*01-Lets catch the report file*/
//            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("../view/reports/CustomerReport.jrxml"));
//
//            /*02- Lets compile the jasper design */
//            JasperReport compileReport = JasperCompileManager.compileReport(design);
//
//            /*03- Set the resources for the compiled report*/
//            /*1- Complied report*/
//            /*2- Parameters = null*/
//            /*2- DataSource = JREmpty Data Source*/
//            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, new JREmptyDataSource(1));
//
//            /*04- Lets view the report*/
//            JasperViewer.viewReport(jasperPrint, false);
//
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/Reports/CustomerReport.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(design);

            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomerOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = CustomerController.deleteCustomer(cusTable.getSelectionModel().getSelectedItem().getId());
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

    public void updateCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Customer c1= new Customer(
                id.getText(),
                name.getText(),
                address.getText(),
                nic.getText(),
                tp.getText()
        );


        if (new CustomerController().updateCustomer(c1))
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
    }
}
