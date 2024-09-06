package org.example;

public class Bus {
//    number int primary key auto_increment,
//    name varchar(10),
//    model varchar(20),
//    seatCapacity int not null,
//    driverName varchar(30),
//    conductorName varchar(30)
    private int number;
    private String name;
    private String model;
    private int seatCapacity;
    private String driverName;
    private String conductorName;
    Bus(){

    }
    public Bus(String name, String model, int seatCapacity, String driverName, String conductorName) {
        this.number = number;
        this.name = name;
        this.model = model;
        this.seatCapacity = seatCapacity;
        this.driverName = driverName;
        this.conductorName = conductorName;
    }

    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Bus Details: \n" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", driverName='" + driverName + '\'' +
                ", conductorName='" + conductorName+'\'';
    }
}
