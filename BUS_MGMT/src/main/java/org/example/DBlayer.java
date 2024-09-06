package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class DBlayer {
//    public static String  LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
//    public static String URL = "jdbc:mysql://localhost:3306/busmngtdb";
//    public static String PASSWORD="983223@Raj";
//    public static String USERNAME = "root";

    public static void main(String[] args) {
        BusService busService = new BusService();
        Bus howrahStationToSectorVPrivateBus = new Bus("215A","TATA",50,"Raj Mukherjee","Sarbojit Roy");
        Bus howrahStationToSectorVGovtBus = new Bus("S12","TATA",75,"Anjan Sarkar","Maharnob Upadhay");
        Bus howrahStationToSectorVGovtBusAC = new Bus("AC12","TATA",75,"Jishnu Panda","Samay Mondal");
        Bus kolkataStationToNewtown = new Bus("K1","TATA",50,"Ritolibdho Gomesh","Badhan Nandi");
        Bus howrahStationToSector2 = new Bus("206","TATA",50,"Dipanjan Panda","Shreyan Shinha");
        Bus SectorVToJadavpur = new Bus("S22","TATA",75,"Rohan Basu","Khushi Bera");

//        adding Data in DB
        System.out.println("Adding Buses in DataBase:- ");
        busService.addBus(howrahStationToSectorVPrivateBus);
        busService.addBus(howrahStationToSectorVGovtBus);
        busService.addBus(howrahStationToSectorVGovtBusAC);
        busService.addBus(kolkataStationToNewtown);
        busService.addBus(howrahStationToSector2);
        busService.addBus(SectorVToJadavpur);

//        fetch data from DB
        System.out.println("Select a Specific Bus from the DataBase and Find out all information about the bus:- ");
        System.out.println("Enter the bus serial number=> ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bus bus = busService.getBusByNumber(n);
        System.out.println("Bus Data : "+bus);

//        updating bus Data
        System.out.println("Update the bus driver name that you specifically selected=> ");
        System.out.println("Enter the new Driver name:- ");
        String driverOld = bus.getDriverName();
        String driverNew = sc.next();
        bus.setDriverName(driverNew);
        System.out.println("Check the updatetion is completed of not:-");
        if(driverOld!=bus.getDriverName()) {
            busService.updateBus(bus);
            System.out.println("Updation completed!");
            System.out.println("Updated truck data : " + busService.getBusByNumber(n));
        }{
            System.out.println("Updation not completed!");
            System.out.println("New Driver name as same as Old Driver");
        }

//        get all bus data
        List<Bus> allBus = busService.getAllBus();
        System.out.println("All bus in DB :");
        for(Bus bus1:allBus){
            System.out.println(bus1);
        }

//        delete bus data
        int rowAffected = busService.deleteBus(2);
        if(rowAffected==0){
            System.out.println("failed to delete data");
        }else{
            System.out.println("successfully deleted data from row: "+rowAffected);
        }

        allBus = busService.getAllBus();
        System.out.println("All bus after all operation: ");
        System.out.println(allBus);
    }
}
