package com.example.quanlyxe;


public class Truck extends Car {
    private final static int HeSoTien = 700000;

    public Truck() {
    }

    public Truck(int ID,int carNumber, String carOwner, int month, int weight) {
        super(ID,carNumber, carOwner, month);
        this.weight = weight;
        setTypeCar("Xe tải");
        this.Price= PriceCalculate();
        this.PriceInt = (int)Price;
        this.Date =DateConvert();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public double PriceCalculate() {
        Price = weight * HeSoTien;
        if (Month > 60) {
            Price = Price - (Price * 0.25);
        }
        return Price;

    }
    public String DateConvert(){
        int newMonth = Month % 12;
        int year = Month/12;
        return newMonth+" tháng "+ year +" năm";
    }

    public void InThongTin() {
        System.out.println("ID:"+getID()+"||Loai xe:" + getTypeCar() + "||Bien So Xe:" + getCarNumber() +
                "||Chu xe:" + getCarOwner() + " " +
                "||thoi gian duoc trong:" + getDate() + " " +
                "||trong tai:" + getWeight() + " " +
                "||Tien:" + PriceCalculate());
    }
}