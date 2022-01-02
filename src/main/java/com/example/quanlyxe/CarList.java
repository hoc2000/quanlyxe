package com.example.quanlyxe;

import java.util.ArrayList;
import java.util.Scanner;

public class CarList {
    private static ArrayList<Car> listCars;

    // ham main de chay chuong trinh
    public static void main(String[] args) {
        int choice;
        String typeCar;
        listCars = new ArrayList<>();

        Car car1 = new SmallCar(1, 6543, "Hoc", 71);
        Car car2 = new Truck(2, 1234, "Anh", 60, 3);
        Car car3 = new SmallCar(3, 4567, "Long", 81);

        listCars.add(car1);
        listCars.add(car2);
        listCars.add(car3);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=================MENU=================");
            System.out.println("1.Them oto moi.");
            System.out.println("2.Tim xe voi gia hang thang lon hon 1 so nhap vao.");
            System.out.println("3.Tinh tong tien.");
            System.out.println("4.Tìm xe");
            System.out.println("5.InDS");
            System.out.println("6.Sửa đổi thông tin");
            System.out.println("7.Xóa xe");
            System.out.println("0.Thoat ung dung");
            System.out.println("Lua chon cua ban ?");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case (0): System.out.println("thoat ra, Xin cam on");
                break;
                case (1): ThemXe();
                break;
                case (2): DSXeHonPhi();
                break;
                case (3): Tong(listCars);
                break;
                case (4): FindCar(listCars);
                break;
                case (5): InDS();
                break;
                case (6): EditCar();
                break;
                case (7): Delete();
                break;
            }
        } while (choice != 0);
    }

///// CAC YEU CAU CUA DE BAI//////


    //Yeu cau 1: Them, Xoa, Sua
    // Them
    public static void ThemXe() {
        int choice;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập loại xe");
            System.out.println("1.Xe con");
            System.out.println("2.Xe tải");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            System.out.println("nhập ID:");
            int ID = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Nhập biển số xe:");
            int CarNum = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Nhập tên chủ xe:");
            String CarOwner = scanner.nextLine();

            System.out.println("nhập tháng muốn xe được trông:");
            int month = scanner.nextInt();

            Car newsmallcar = new SmallCar(ID, CarNum, CarOwner, month);
            listCars.add(newsmallcar);
        }
        if (choice == 2) {
            System.out.println("Nhập ID:");
            int ID = scanner.nextInt();
            scanner.nextLine();

            System.out.println("nhập biển số xe:");
            int CarNum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Nhập chủ xe");
            String CarOwner = scanner.nextLine();

            System.out.println("Nhập tháng muốn được trông:");
            int month = scanner.nextInt();

            System.out.println("nhập trọng tải(đv:tấn):");
            int weight = scanner.nextInt();
            Car newtruck = new Truck(ID, CarNum, CarOwner, month, weight);
            listCars.add(newtruck);
        }
    }
    // Xoa
    public static void Delete() {
        InDS();
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn ID của xe muốn bị xóa");
        int ID = sc.nextInt();
        listCars.removeIf(car -> ID == car.getID());
    }
    // Sua
    public static void EditCar() {

        InDS();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chon ID muon sua");
        int ID = scanner.nextInt();

        for (Car car : listCars) {
            if (car.getID() == ID) {

                System.out.println("nhập biển số xe muốn sửa:");
                int CarNum = scanner.nextInt();
                car.setCarNumber(CarNum);

                scanner.nextLine();

                System.out.println("Nhập chủ xe muốn sửa");
                String CarOwner = scanner.nextLine();
                car.setCarOwner(CarOwner);

                System.out.println("Nhập tháng muốn được trông muốn sửa:");
                int month = scanner.nextInt();
                car.setMonth(month);
                car.setDate(car.DateConvert());

                System.out.println("nhập trọng tải(đv:tấn) muốn sửa:");
                int weight = scanner.nextInt();
                car.setWeight(weight);

                car.setPriceInt((int) car.PriceCalculate());
                System.out.println("Cập nhật thành công");
            }
        }
    }

    // Yeu cau 2: Tìm xe theo ten, so xe, loai xe.
    public static void FindCar(ArrayList<Car> list) {
        Car[] cars = new Car[listCars.size()];
        list.toArray(cars);

        int input, numberCar;
        String name, type;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Chon phuong thuc tim kiem");
            System.out.println("1. Tim theo ten");
            System.out.println("2. Tim theo bien so xe");
            System.out.println("3. Tim theo loai xe");
            input = sc.nextInt();

            switch (input) {
                case (1):
                    System.out.println(" Nhap ten nguoi so huu ");
                    name = sc.next();

                    for (int i = 0; i < cars.length; i++) {
                        if (name.trim().equalsIgnoreCase(cars[i].getCarOwner())) {
                            cars[i].InThongTin();
                        }
                    }
                    break;

                case (2):
                    System.out.println(" Nhap bien so xe ");
                    numberCar = sc.nextInt();

                    for (int i = 0; i < cars.length; i++) {
                        if (numberCar == cars[i].getCarNumber()) {
                            cars[i].InThongTin();
                        }
                    }
                    break;

                case (3):
                    System.out.println(" Nhap loai xe ");
                    type = sc.next();

                    for (int i = 0; i < cars.length; i++) {
                        if (type.equalsIgnoreCase("SmallCar") && cars[i] instanceof SmallCar) {
                            cars[i].InThongTin();
                        }
                        if (type.equalsIgnoreCase("Truck") && cars[i] instanceof Truck){
                            cars[i].InThongTin();
                        }
                    }
                    break;
                default:
                    System.out.println("Nhan nut bat ky de thoat");
                    break;
            }
        }while (input == 1 || input == 2 || input == 3);
    }

    //yêu cầu 3
    public static void DSXeHonPhi() {
        Car[] cars = new Car[listCars.size()];
        listCars.toArray(cars);

        Scanner scanner = new Scanner(System.in);
        System.out.println("So phi muon so sanh: ");
        double phi = scanner.nextInt();

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].PriceCalculate() > phi) {
                System.out.println("Xe so " + (i + 1) + ":");
                cars[i].InThongTin();
            }
        }
    }
    // Yeu cau 4
    public static void Tong(ArrayList<Car> list) {
        Car[] cars = new Car[listCars.size()];
        list.toArray(cars);

        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so thang de tinh chi phi:");
        int monthtp = input.nextInt();
        int Tong = 0;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].getMonth() < monthtp){
                Tong += cars[i].getMonth() * cars[i].getPrice();
            }else{
                Tong += monthtp * cars[i].getPrice();
            }
        }
        System.out.println("Tong: " + Tong);
    }
    ///..............
    ///0. in DAnh SAch
    public static void InDS() {
        Car[] cars = new Car[listCars.size()];
        listCars.toArray(cars);
        if (cars.length == 0) {
            System.out.println("chua co xe nao");
        } else {
            for (int i = 0; i < cars.length; i++) {
                System.out.println("Xe so " + (i + 1) + ":");
                cars[i].InThongTin();
                System.out.println(cars[i].PriceInt);
            }
        }
    }
}
