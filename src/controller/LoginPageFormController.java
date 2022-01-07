package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class LoginPageFormController {
    public AnchorPane loginContext;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Pane loginLabalOne;
    public Label usernameFont;
    public Label passwordFont;
    public Button loginbtn;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException  {

            String userName = txtUserName.getText();
            String password = txtPassword.getText();

            User c1 = new UserController().getUser(userName, password);
            if (c1 == null) {
                new Alert(Alert.AlertType.WARNING, "Wrong Password ").show();
                txtPassword.clear();
            } else {
                if (c1.getType().equals("Admin")) {
                    URL resource = getClass().getResource("../view/AdminDashboardForm.fxml");
                    Parent load = FXMLLoader.load(resource);
                    Stage window = (Stage) loginContext.getScene().getWindow();
                    window.setTitle("Admin Form");
                    window.setScene(new Scene(load));
                } else {
                    URL resource = getClass().getResource("../view/CashierDashboardForm.fxml");
                    Parent load = FXMLLoader.load(resource);
                    Stage window = (Stage) loginContext.getScene().getWindow();
                    window.setTitle("Cashier Form");
                    window.setScene(new Scene(load));
                }
            }
        }
    }

