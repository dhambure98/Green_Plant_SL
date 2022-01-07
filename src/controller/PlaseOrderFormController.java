package controller;

import Tm.CartTable;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import jdk.nashorn.internal.ir.CatchNode;
import jdk.nashorn.internal.objects.annotations.Property;
import model.Customer;
import model.Order;
import model.Plant;
import model.PlantDetails;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlaseOrderFormController {

    public ComboBox<String> cmbPlantIds;
    public TextField txtCustomerName;
    public TextField txtCustomerNumber;
    public TextField txtPlantName;
    public TextField txtPlantType;
    public TextField txtQuantity;
    public TextField txtPlantCategory;
    public TextField txtUnitPrice;
    public TextArea txtAddress;
    public TextArea txtDescription;
    public TableView<CartTable> tblCart;
    public TableColumn callOrderId;
    public TableColumn callPlantId;
    public TableColumn callQuantity;
    public TableColumn callUnitPrice;
    public TableColumn callTotalCost;
    public TextField txtQty;
    public TextField txtCustomerNIC;
    public Label txtTtl;
    public AnchorPane lblOrderId;
    public Button btnAddToCart;
    public Button btnClear;
    public Button btnPlaceOrder;
    public Button btnSearch;
    public Label txtCustomerId;

    int cartSelectedRowForRemove = -1;

    public void initialize() {

        callOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        callPlantId.setCellValueFactory(new PropertyValueFactory<>("plaId"));
        callQuantity.setCellValueFactory(new PropertyValueFactory<>("qty"));
        callUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        callTotalCost.setCellValueFactory(new PropertyValueFactory<>("total"));

        try {
            loadPlantIds();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbPlantIds.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setPlantData(newValue);
                        System.out.println(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });



        tblCart.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            cartSelectedRowForRemove = (int) newValue;
        });
    }

    private void setPlantData(String plantCode) throws SQLException, ClassNotFoundException {
        Plant p1 = new PlantController().getPlant(plantCode);
        if (p1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtPlantName.setText(p1.getPlaName());
            txtDescription.setText(p1.getPlaDescription());
            txtPlantCategory.setText(p1.getPlaCategory());
            txtPlantType.setText(p1.getPlaType());
            txtQuantity.setText(String.valueOf(p1.getPlaQty()));
            txtUnitPrice.setText(String.valueOf(p1.getPlaPrice()));
        }
    }


    private void loadPlantIds() throws SQLException, ClassNotFoundException {
        List<String> plantIds = new PlantController().getAllPlantIds();
        cmbPlantIds.getItems().addAll(plantIds);
    }

    ObservableList<CartTable> obList = FXCollections.observableArrayList();
    public void addToCartOnAction(ActionEvent actionEvent) {

        String description = txtDescription.getText();
        int qtyOnHand = Integer.parseInt(txtQuantity.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qtyForCustomer = Integer.parseInt(txtQty.getText());
        double total = qtyForCustomer * unitPrice;

        if(qtyOnHand<qtyForCustomer){
            new Alert(Alert.AlertType.WARNING,"Invalid QTY").show();
            return;
        }

        CartTable table = new CartTable(
                cmbPlantIds.getValue(),
                description,
                qtyForCustomer,
                unitPrice,
                total

        );

        int rowNumber=isExists(table);

        // Add new Value
        if (isExists(table)==-1){
            obList.add(table);

        }else {
            // Update Value
            CartTable temp = obList.get(rowNumber);
            CartTable newTable = new CartTable(
                    temp.getOrderId(),
                    temp.getPlaId(),
                    temp.getQty()+qtyForCustomer,
                    unitPrice,
                    total+temp.getTotal()
            );
            obList.remove(rowNumber);
            obList.add(newTable);
        }
        tblCart.setItems(obList);
        calculateCost();
    }

    private int isExists(CartTable table){

        for (int i = 0; i < obList.size(); i++) {
            if (table.getOrderId().equals(obList.get(i).getOrderId())){
                return i;
            }
        }
        return -1;
    }

    void calculateCost(){
        double ttl=0;
        for (CartTable table : obList){
            ttl+=table.getTotal();
        }
        txtTtl.setText(ttl+" /=");
    }


    public void clearOnAction(ActionEvent actionEvent) {
        if (cartSelectedRowForRemove==-1){
            new Alert(Alert.AlertType.WARNING,"Please Select a Row").show();
        }else{
            obList.remove(cartSelectedRowForRemove);
            calculateCost();
            tblCart.refresh();
        }
    }

    public void plaseOrderOnAction(ActionEvent actionEvent) {
//        if (tblCart.getItems().isEmpty()){
//            new Alert(Alert.AlertType.WARNING, "Please Add To Item From Cart ....").show();
//        }else {
//            ArrayList<PlantDetails> plants = new ArrayList<>();
//            for (CartTable tempTm : obList) {
//                plants.add(new PlantDetails(
//                        tempTm.getItemCode(),
//                        new SimpleDateFormat("dd MM yyyy").format(new Date()),
//                        "null",
//                        tempTm.getQty(),
//                        tempTm.getPriceForOneDay(),
//                        0,
//                        "Rent",
//                        0
//                ));
//
//            }
//
//            Order rent = new Order(
//                    lblRentId.getText(),
//                    txtCId.getText(),
//                    items
//            );
//
//            if (new PlaseOrderController().placeRent(rent)) {
//                new Alert(Alert.AlertType.CONFIRMATION, "Success").show();
//                setOrderId();
//                clearCustomerDetails();
//                clearItemDetails();
//            } else {
//                new Alert(Alert.AlertType.WARNING, "Try Again").show();
////            }
//        }
//        ArrayList<PlantDetails> plants= new ArrayList<>();
//        double total=0;
//        for (CartTable tempTable:obList
//        ) {
//            total+=tempTable.getTotal();
//            plants.add(new PlantDetails(
//                    tempTable.getOrderId(),
//                    tempTable.getPlaId(),
//                    tempTable.getQty(),
//                    tempTable.getUnitPrice(),
//                    tempTable.getTotal()
//                    )
//            );
//        }
//
//        Order order= new Order(lblOrderId.getText(), cmbCustomerIds.getValue(),
//                lblDate.getText(),
//                lblTime.getText(),
//                total,
//                items
//        );
//
//        if (new OrderController().placeOrder(order)){
//            new Alert(Alert.AlertType.CONFIRMATION, "Success").show();
//            setOrderId();
//        }else{
//            new Alert(Alert.AlertType.WARNING, "Try Again").show();
//        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            Customer customer = CustomerController.searchCustomerOnNic(txtCustomerNIC.getText());
            if (customer != null) {
                txtCustomerId.setText(customer.getcId());
                txtCustomerNIC.setText(customer.getNIC());
                txtCustomerName.setText(customer.getcName());
                txtCustomerNumber.setText(customer.getcContact());
                txtAddress.setText(customer.getcAddress());
            }else{
                new Alert(Alert.AlertType.WARNING, "This Customer Is not Save. Please Add Customer ...... ").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


//    private void loadCustomerIds() throws SQLException, ClassNotFoundException {
//        List<String> customerIds = new CustomerController()
//                .getCustomerIds();
//        cmbCustomerIds.getItems().addAll(customerIds);
//    }
}
