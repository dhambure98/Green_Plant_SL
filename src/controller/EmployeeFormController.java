package controller;

import Tm.EmployeeTable;
import db.DbConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.util.List;

public class EmployeeFormController {
    public TextField id;
    public TextField name;
    public TextArea address;
    public TextField tp;
    public TextField type;
    public TextField salary;
    public TableView<EmployeeTable> empTable;
    public TableColumn empId;
    public TableColumn empName;
    public TableColumn empAddress;
    public TableColumn empTp;
    public TableColumn empType;
    public TableColumn empSalary;
    public TextField search;
    public Button btnDeleteEmployee;
    public Button btnUpdateEmployee;
    public Button btnEmployeeReport;

    public void initialize() {
        empId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        empName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        empAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        empTp.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        empType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        empSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        empTable.getColumns().setAll( empId , empName , empAddress , empTp , empType , empSalary  );

        loadData();

        search.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    List<Employee> employees = EmployeeController.searchEmployee(newValue);
                    loadTableData(employees);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void loadTableData(List<Employee> allEmployees) {
        ObservableList<EmployeeTable> tableData = FXCollections.observableArrayList();
        for (Employee employee : allEmployees) {
            tableData.add(new EmployeeTable(
                    employee.getEmpId(),
                    employee.getEmpName(),
                    employee.getEmpAddress(),
                    employee.getEmpContact(),
                    employee.getEmpType(),
                    employee.getSalary()
            ));
            System.out.println(employee.getEmpId() + " ===== " + employee.getEmpName() + " ===== " + employee.getEmpAddress() + " ===== " + employee.getEmpContact() + " ===== " + employee.getEmpType() + " ===== " + employee.getSalary() + " ===== ");
        }
        empTable.getItems().setAll(tableData);
    }

    private void loadData() {
        try {
            loadTableData( EmployeeController.getAllEmployees());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = EmployeeController.saveEmployee(new Employee(
                    id.getText(),
                    name.getText(),
                    address.getText(),
                    tp.getText(),
                    type.getText(),
                    Double.parseDouble(salary.getText())
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

    public void EmployeeReportEvent(MouseEvent mouseEvent) {
        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/Reports/EmployeeReport.jrxml"));
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

    public void deleteEmployeeOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = EmployeeController.deleteEmployee(empTable.getSelectionModel().getSelectedItem().getId());
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

    public void updateEmployeeOnAction(ActionEvent actionEvent) {
    }


}