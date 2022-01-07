package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

public class CashierDashboardFormController {

    public Label lblTime;
    public Label lblDate;
    public AnchorPane loardPane;
    public AnchorPane cashierContext;
    public VBox cashierdashboardAnchorPane;
    public AnchorPane cashierDashboardPageContext;
    public Pane adminPaneOne;
    public Button btnPlaceOrder;
    public Button btnHomeCashier;
    public Button btnPlantCategories;
    public Button btnAddPlant;
    public Button btnCustomer;
    public Button btnDelivery;
    public Button btnSettings;
    public Button btnLogOut;

    public void initialize() {
        loadDateAndTime();
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

    public void placeOrderOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PlaseOrderForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddNewCustomerForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void plantOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PlantForm.fxml");
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
        cashierContext.getChildren().add(loard);
    }

    public void deliveryOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DeliveryForm.fxml");
        Parent loard = FXMLLoader.load(resource);
        loardPane.getChildren().clear();
        loardPane.getChildren().add(loard);
    }

    public void cashierHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CashierHomeForm.fxml");
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

}
