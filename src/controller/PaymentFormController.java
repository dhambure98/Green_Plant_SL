package controller;

import Tm.PaymentTable;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Payment;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.util.List;

public class PaymentFormController {
    public TextField id;
    public TextField salary;
    public TextField date;
    public TextField paymentId;
    public TextField paymentMethord;
    public TableView<PaymentTable> payTable;
    public TableColumn payId;
    public TableColumn empId;
    public TableColumn empSalary;
    public TableColumn payDate;
    public TableColumn paymentType;
    public Button btnAddPayement;
    public Button btnPayement;


    public void initialize() {
        payId.setCellValueFactory(new PropertyValueFactory<>("PaymentId"));
        empId.setCellValueFactory(new PropertyValueFactory<>("id"));
        empSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        payDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        paymentType.setCellValueFactory(new PropertyValueFactory<>("paymentMethord"));

        payTable.getColumns().setAll(payId, empId, empSalary, payDate, paymentType);

        loadData();

    }

    private void loadTableData(List<Payment> allPayment) {
        ObservableList<PaymentTable> tableData = FXCollections.observableArrayList();
        for (Payment payment : allPayment) {
            tableData.add(new PaymentTable(
                    payment.getPaymentId(),
                    payment.getId(),
                    payment.getSalary(),
                    payment.getDate(),
                    payment.getPaymentType()
            ));
            System.out.println(payment.getPaymentId() + " ===== " + payment.getId() + " ===== " + payment.getSalary() + " ===== " + payment.getDate() + " ===== " + payment.getPaymentType() );
        }
        payTable.getItems().setAll(tableData);
    }

    private void loadData() {
        try {
            loadTableData( PaymentController.getAllPayments());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void addPaymentOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = PaymentController.savePayment(new Payment(
                    paymentId.getText(),
                    id.getText(),
                    Double.parseDouble(salary.getText()),
                    date.getText(),
                    paymentMethord.getText()
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


    public void PayementReportExport(MouseEvent mouseEvent) {
        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/Reports/PaymentReport.jrxml"));
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
}

