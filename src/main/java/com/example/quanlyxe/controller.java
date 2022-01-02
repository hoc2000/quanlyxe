package com.example.quanlyxe;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class controller implements Initializable {


    @FXML
    private TextField CarNuminput;

    @FXML
    private ChoiceBox<String> ChoiceType;

    @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private TableColumn<Car, Integer> CarNum;

    @FXML
    private TextField Monthinput;


    @FXML
    private TextField weightinput;

    @FXML
    private TextField IDinput;


    @FXML
    private TableColumn<Car, String> Time;

    @FXML
    private TableColumn<Car, Integer> Price;


    @FXML
    private TableColumn<Car, Integer> IDcar;

    @FXML
    private TableColumn<Car, String> CarType;

    @FXML
    private TableView<Car> CarManage;

    @FXML
    private TableColumn<Car, Integer> weight;

    @FXML
    private TableColumn<Car, String> CarOwner;

    @FXML
    private TextField CarOwnerinput;

    //=========================================================================================//
    @FXML
    private TableView<Car> Findtable;

    @FXML
    private TableColumn<Car, Integer> FindID;

    @FXML
    private TableColumn<Car, String> FindCarType;

    @FXML
    private TableColumn<Car, String> FindCarOwner;

    @FXML
    private TableColumn<Car, Integer> FindPrice;

    @FXML
    private TableColumn<Car, String> FindTime;

    @FXML
    private TableColumn<Car, Integer> Findweight;

    @FXML
    private TableColumn<Car, Integer> FindCarNum;


    @FXML
    private ChoiceBox<String> FindChoice;


    @FXML
    private TextField inputCompare;


    @FXML
    private TextField FindOwner;


    @FXML
    private TextField FindNum;


    @FXML
    private TextField countMonth;

    @FXML
    private TextArea Sum;




//=========================================================================================//

    ObservableList<Car> list = FXCollections.observableArrayList(
            new SmallCar(1, 1234, "Vũ Tự Học", 61),
            new Truck(2, 5678, "Nguyễn Mạnh Long", 71, 6),
            new SmallCar(3, 9101, "Đặng Trung Anh", 54),
            new SmallCar(4, 1121, "Quang Trung", 32),
            new Truck(5, 3141, "Nguyễn Huệ", 45, 4)
    );

    public controller() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceType.getItems().addAll("Xe con", "Xe tải");

        IDcar.setCellValueFactory(new PropertyValueFactory<Car, Integer>("ID"));
        CarNum.setCellValueFactory(new PropertyValueFactory<Car, Integer>("CarNumber"));
        CarOwner.setCellValueFactory(new PropertyValueFactory<Car, String>("CarOwner"));
        Time.setCellValueFactory(new PropertyValueFactory<Car, String>("Date"));
        CarType.setCellValueFactory(new PropertyValueFactory<Car, String>("TypeCar"));
        weight.setCellValueFactory(new PropertyValueFactory<Car, Integer>("weight"));
        Price.setCellValueFactory(new PropertyValueFactory<Car, Integer>("PriceInt"));

        FindChoice.getItems().addAll("Xe con", "Xe tải");
        FindID.setCellValueFactory(new PropertyValueFactory<Car, Integer>("ID"));
        FindCarNum.setCellValueFactory(new PropertyValueFactory<Car, Integer>("CarNumber"));
        FindCarOwner.setCellValueFactory(new PropertyValueFactory<Car, String>("CarOwner"));
        FindTime.setCellValueFactory(new PropertyValueFactory<Car, String>("Date"));
        FindCarType.setCellValueFactory(new PropertyValueFactory<Car, String>("TypeCar"));
        Findweight.setCellValueFactory(new PropertyValueFactory<Car, Integer>("weight"));
        FindPrice.setCellValueFactory(new PropertyValueFactory<Car, Integer>("PriceInt"));

        CarManage.setItems(list);
    }

    //button add
    @FXML
    void Add(javafx.event.ActionEvent event) {
        String selection = ChoiceType.getSelectionModel().getSelectedItem();

        ObservableList<Car> cars = CarManage.getItems();
        if (Objects.equals(selection, "Xe con")) {
            //upcasting
            Car smallcar = new SmallCar(Integer.parseInt(IDinput.getText()), Integer.parseInt(CarNuminput.getText()),
                    CarOwnerinput.getText(),
                    Integer.parseInt(Monthinput.getText()));
            cars.add(smallcar);
        } else if (Objects.equals(selection, "Xe tải")) {
            Car truck = new Truck(Integer.parseInt(IDinput.getText()), Integer.parseInt(CarNuminput.getText()),
                    CarOwnerinput.getText(),
                    Integer.parseInt(Monthinput.getText()),
                    Integer.parseInt(weightinput.getText()));
            cars.add(truck);
        }


        CarManage.setItems(cars);

    }

    // if (Objects.equals(car.getCarNumber(), Integer.parseInt(FindNum.getText()))) {
//        if (Objects.equals(car.getTypeCar(), selection)) {
    @FXML
    void FindName(javafx.event.ActionEvent event) {
        String selection = FindChoice.getSelectionModel().getSelectedItem();
        ObservableList<Car> cars = Findtable.getItems();
        Findtable.getItems().removeAll(cars);
        ObservableList<Car> currentCar = CarManage.getItems();
        for (Car car : currentCar) {
            if (Objects.equals(car.getCarOwner(), FindOwner.getText())) {
                cars.add(car);

            }

            Findtable.setItems(cars);
            Findtable.refresh();
        }
    }

    @FXML
    void FindOwner(javafx.event.ActionEvent event) {

        String selection = FindChoice.getSelectionModel().getSelectedItem();
        ObservableList<Car> cars = Findtable.getItems();
        Findtable.getItems().removeAll(cars);
        ObservableList<Car> currentCar = CarManage.getItems();
        for (Car car : currentCar) {
            if (Objects.equals(car.getCarNumber(), Integer.parseInt(FindNum.getText()))) {
                cars.add(car);
            }

        }

        Findtable.setItems(cars);
        Findtable.refresh();
    }

    @FXML
    void FindType(javafx.event.ActionEvent event) {
        String selection = FindChoice.getSelectionModel().getSelectedItem();

        ObservableList<Car> cars = Findtable.getItems();
        Findtable.getItems().removeAll(cars);
        ObservableList<Car> currentCar = CarManage.getItems();
        for (Car car : currentCar) {
            if (Objects.equals(car.getTypeCar(), selection)) {
                cars.add(car);
            }
        }

        Findtable.setItems(cars);
        Findtable.refresh();
    }

    @FXML
    void FindCompare(javafx.event.ActionEvent event) {
        String selection = FindChoice.getSelectionModel().getSelectedItem();
        ObservableList<Car> cars = Findtable.getItems();
        Findtable.getItems().removeAll(cars);
        ObservableList<Car> currentCar = CarManage.getItems();
        for (Car car : currentCar) {
            if (car.getPriceInt() > Integer.parseInt(inputCompare.getText())) {
                cars.add(car);
            }
        }

        Findtable.setItems(cars);
        Findtable.refresh();

    }

    @FXML
    void Sum(javafx.event.ActionEvent event){
        Sum.clear();
        ObservableList<Car> currentCar = CarManage.getItems();
        int month = Integer.parseInt(countMonth.getText());
        int Tong =0;
        for (Car car : currentCar) {
            Tong+=car.getPriceInt();
            }
        Tong=Tong*month;
        Sum.appendText(Integer.toString(Tong));
    }


    @FXML
    void Delete(javafx.event.ActionEvent event) {
        int select = CarManage.getSelectionModel().getSelectedIndex();
        CarManage.getItems().remove(select);
    }

    @FXML
    void rowClicked(javafx.scene.input.MouseEvent event) {
        Car clicked = CarManage.getSelectionModel().getSelectedItem();
        IDinput.setText(String.valueOf(clicked.getID()));
        ChoiceType.setValue(String.valueOf(clicked.getTypeCar()));
        CarNuminput.setText(String.valueOf(clicked.getCarNumber()));
        CarOwnerinput.setText(String.valueOf(clicked.getCarOwner()));
        Monthinput.setText(String.valueOf(clicked.getMonth()));
        weightinput.setText(String.valueOf(clicked.getWeight()));

    }

    //lmao cái này sai vl
    @FXML
    void change(javafx.event.ActionEvent event) {
        int currentnumber = Integer.parseInt(IDinput.getText());
        ObservableList<Car> currentCar = CarManage.getItems();
        for (Car car : currentCar) {
            if (car.getID() == currentnumber) {
                car.setCarNumber(Integer.parseInt(CarNuminput.getText()));
                car.setCarOwner(CarOwnerinput.getText());

                car.setMonth(Integer.parseInt(Monthinput.getText()));
                car.setDate(car.DateConvert());
//                String select =ChoiceType.getSelectionModel().getSelectedItem();
//                car.setTypeCar(select);

                car.setWeight(Integer.parseInt(weightinput.getText()));
                car.setPriceInt((int) car.PriceCalculate());


                CarManage.setItems(currentCar);
                CarManage.refresh();
            }
        }
    }


}


