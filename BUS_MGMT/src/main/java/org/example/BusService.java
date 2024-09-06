package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusService {
    public void addBus(Bus bus){
        String sql = "insert into Bus (name,model,seatCapacity,driverName,conductorName) values (?,?,?,?,?)";
        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bus.getName());
            preparedStatement.setString(2,bus.getModel());
            preparedStatement.setInt(3,bus.getSeatCapacity());
            preparedStatement.setString(4,bus.getDriverName());
            preparedStatement.setString(5,bus.getConductorName());
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Inserted :"+rowAffected);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Bus getBusByNumber(int number){
        String query = "select * from Bus where number=?";
        Bus bus = new Bus();
        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,number);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                bus.setNumber(resultSet.getInt("number"));
                bus.setName(resultSet.getString("name"));
                bus.setModel(resultSet.getString("model"));
                bus.setSeatCapacity(resultSet.getInt("seatCapacity"));
                bus.setDriverName(resultSet.getString("driverName"));
                bus.setConductorName(resultSet.getString("conductorName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bus;
    }
    public void updateBus(Bus bus){
        String sql = "update Bus set name=?,model=?,seatCapacity=?,driverName=?,conductorName=? where number=?";
        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bus.getName());
            preparedStatement.setString(2,bus.getModel());
            preparedStatement.setInt(3,bus.getSeatCapacity());
            preparedStatement.setString(4,bus.getDriverName());
            preparedStatement.setString(5,bus.getConductorName());
            preparedStatement.setInt(6,bus.getNumber());
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("Row updated : "+rowAffected);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Bus> getAllBus(){
        String sql = "select * from Bus";
        List<Bus> buses = new ArrayList<>();
        try {
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Bus bus = new Bus();
                bus.setNumber(resultSet.getInt("number"));
                bus.setName(resultSet.getString("name"));
                bus.setModel(resultSet.getString("model"));
                bus.setSeatCapacity(resultSet.getInt("seatCapacity"));
                bus.setDriverName(resultSet.getString("driverName"));
                bus.setConductorName(resultSet.getString("conductorName"));
                buses.add(bus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return buses;
    }
    public int deleteBus(int number){
        String deleteQuery = "delete from Bus where number=?";
        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,number);
            return preparedStatement.executeUpdate();
//            System.out.println("Row Deleted: " +rowAffected);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
