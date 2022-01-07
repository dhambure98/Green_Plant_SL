package controller;

import Tm.PlantTable;
import db.DbConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlantFormController {
    public TextField id;
    public TextField name;
    public TextField type;
    public TextField qty;
    public TextField category;
    public TextField price;
    public TextArea description;
    public TableView<PlantTable> plaTable;
    public TableColumn plaId;
    public TableColumn plaName;
    public TableColumn plaType;
    public TableColumn plaQty;
    public TableColumn plaCategory;
    public TableColumn plaPrice;
    public TableColumn plaDescription;
    public TextField search;
    public Button btnDeletePlant;
    public Button btnAddPlant;
    public Button btnUpdatePlantOnAction;

    public void initialize() {
        plaId.setCellValueFactory(new PropertyValueFactory<>("plaId"));
        plaName.setCellValueFactory(new PropertyValueFactory<>("plaName"));
        plaType.setCellValueFactory(new PropertyValueFactory<>("plaType"));
        plaQty.setCellValueFactory(new PropertyValueFactory<>("plaQty"));
        plaCategory.setCellValueFactory(new PropertyValueFactory<>("plaCategory"));
        plaPrice.setCellValueFactory(new PropertyValueFactory<>("plaPrice"));
        plaDescription.setCellValueFactory(new PropertyValueFactory<>("plaDescription"));

        plaTable.getColumns().setAll(plaId, plaName, plaType, plaQty, plaCategory, plaPrice, plaDescription);

        loadData();

        search.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    List<Plant> plants = PlantController.searchPlant(newValue);
                    loadTableData(plants);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void loadTableData(List<Plant> allPlants) {
        ObservableList<PlantTable> tableData = FXCollections.observableArrayList();
        for (Plant plant : allPlants) {
            tableData.add(new PlantTable(
                    plant.getPlaId(),
                    plant.getPlaName(),
                    plant.getPlaType(),
                    plant.getPlaQty(),
                    plant.getPlaCategory(),
                    plant.getPlaPrice(),
                    plant.getPlaDescription()
            ));
            System.out.println(plant.getPlaId() + " ===== " + plant.getPlaName() + " ===== " + plant.getPlaType() + " ===== " + plant.getPlaQty() + " ===== " + plant.getPlaCategory() + " ===== " + plant.getPlaPrice() + " ===== " + plant.getPlaDescription() + " ===== ");
        }
        plaTable.getItems().setAll(tableData);
    }

    private void loadData() {
        try {
            loadTableData( PlantController.getAllPlant());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void addPlantOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = PlantController.savePlant(new Plant(
                    id.getText(),
                    name.getText(),
                    type.getText(),
                    Integer.parseInt(qty.getText()),
                    category.getText(),
                    description.getText(),
                    Double.parseDouble(price.getText())
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


    public void deletePlantOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = PlantController.deletePlant(plaTable.getSelectionModel().getSelectedItem().getPlaId());
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
