package com.example.quanlyxe;

public abstract class Car {

    //    private String CarType;
    protected int ID;
    protected int weight;
    private int CarNumber;
    private String CarOwner;
    protected int Month;
    protected double Price;
    protected String TypeCar;
    protected int PriceInt;
    protected String Date;

    public Car() {}

    public Car(int ID,int carNumber, String carOwner, int month) {
        this.ID=ID;
        this.CarNumber = carNumber;
        this.CarOwner = carOwner;
        this.Month = month;
    }

    public Car(int carNumber, String carOwner) {
        this.CarNumber = carNumber;
        this.CarOwner = carOwner;
    }

    public int getID() {return ID;}

    public int getWeight() { return weight; }
    public void setWeight(int weight){ this.weight=weight; }

    public int getCarNumber() { return CarNumber; }
    public void setCarNumber(int carNumber) { this.CarNumber = carNumber; }

    public String getCarOwner() { return CarOwner; }
    public void setCarOwner(String carOwner) { this.CarOwner = carOwner; }

    public int getMonth() { return Month; }
    public void setMonth(int month) { Month = month; }

    public String getDate() { return Date; }
    public void setDate(String date) { Date = date; }

    public double getPrice() { return Price; }
    public void setPrice(double price) { this.Price = price; }

    public int getPriceInt() { return PriceInt; }
    public void setPriceInt(int priceInt) { PriceInt = priceInt; }

    public String getTypeCar() { return TypeCar; }
    public void setTypeCar(String carType) { TypeCar = carType; }

    abstract public void InThongTin();
    abstract public String DateConvert();
    abstract public double PriceCalculate();

    public void setCount(int id) { ID = id; }
}
