package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LoadingPageFormController implements Runnable {

    public AnchorPane loadingPageContext;
    public ProgressBar loadingprograss;
    public JFXButton clickbutton;

    Double Counter=0.0;

    public void openLoginForm(ActionEvent actionEvent) throws IOException, InterruptedException {

        loadingprograss = new ProgressBar(0);
        Thread th=new Thread(new LoadingPageFormController());


        URL resource = getClass().getResource("../view/LoginPageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loadingPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    @Override
    public void run() {
        while (Counter<=1){
            Counter=Counter+0.1;
            System.out.println(Counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loadingprograss.setProgress(Counter);

        }
    }
}