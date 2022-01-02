package com.example.quanlyxe;

import java.time.Year;
import java.util.ArrayList;

public class SmallCar extends Car {
    private final static int SmallCarPrice = 1000000;

    public SmallCar(int ID,int carNumber, String carOwner, int month) {
        super(ID,carNumber, carOwner, month);
        setTypeCar("Xe con");
        this.Price= PriceCalculate();
        this.PriceInt = (int)Price;
        this.Date =DateConvert();
        setWeight(0);
    }

    public SmallCar() {
    }

    @Override
    public double PriceCalculate() {
        Price = SmallCarPrice;
        if (Month > 60) {
            Price = Price - (Price * 0.2);
        }
        setPrice(Price);
        return Price;
    }

    public String DateConvert(){
        int newMonth = Month % 12;
        int year = Month/12;
        return newMonth+" tháng "+ year +" năm";
    }

    public void InThongTin() {
        System.out.println("ID:"+getID()+"||Loai xe:" + getTypeCar() + "||Bien so Xe:" + getCarNumber() +
                "||Chu xe:" + getCarOwner() + " " +
                "||thoi gian duoc trong:" + getDate() + " " +
                "||Tien:" + PriceCalculate());
    }
}