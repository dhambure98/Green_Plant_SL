package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class AdminDashboardFormController {

    public Label lblTime;
    public Label lblDate;
    public AnchorPane adminDashboardPageContext;

    public AnchorPane loardPane;
    public AnchorPane adminCotext;
    public VBox admindashboardAnchorPane;
    public Pane adminPaneOne;
    public PieChart pieHash;
    public Button btnAdminHome;
    public Button btnPlantCategories;
    public Button btnAddPlant;
    public Button btnEmployee;
    public Button btnSupplier;
    public Button btnCustomer;
    public Button btnPayment;
    public Button btnSettings;
    public Button btnLogOut;

    public void initialize() {
        loadDateAndTime();
        loadHash(pieHash);
    }

    // pie charts
    private void loadHash (PieChart pieChart){
        ObservableList<PieChart.Data> data =
                FXCollections.observableArrayList(
                        new PieChart.Data("Hash", 25),
                        new PieChart.Data("Key", 75)
                );
        pieChart.setData(data);
    }

    private void loadDateAndTime() {
        // load Date
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        // load Time
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/HomePageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(load);
    }

    public void plantProductionOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PlantForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(load);
    }

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EmployeeForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void supplierOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SupplierForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void settingsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SettingsForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginPageForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        adminCotext.getChildren().add(loard);
    }

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddNewCustomerForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void plantCategoriesOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PlantCategoriesForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void paymentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PaymentForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

//    public void adminHomeOnAction(ActionEvent actionEvent) throws IOException {
//        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
//        Parent loard = FXMLLoader.load(resource);
//        loardPane.getChildren().clear();
//        loardPane.getChildren().add(loard);
//    }
}
