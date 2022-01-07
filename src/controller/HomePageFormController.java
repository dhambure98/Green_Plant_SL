package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;

public class HomePageFormController {
    public PieChart pieHash;
    public Pane adminPaneOne;

    public void initialize() {
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
}
