/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cars;
import model.Customer;
import mylib.MyConnection;

/**
 *
 * @author BAO MINH
 */
public class CarsDao {

    public ArrayList<Cars> getCarsBySerialNumber_model_year(String serialNumber, String model, int year) {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
            if (cn != null) {
                //step 2:
                String sql = "select[carID],[serialNumber],[model],[colour],[year]"
                        + " FROM Cars"
                        + " WHERE serialNumber = ?"
                        + " OR model = ?"
                        + " OR year = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, serialNumber);
                pst.setString(2, model);
                pst.setInt(3, year);
                ResultSet table = pst.executeQuery();
                //step 3:
                if (table != null) {
                    while (table.next()) {
                        int carID = table.getInt("carID");
                        String serial_number = table.getString("serialNumber");
                        String modelCar = table.getString("model");
                        String color = table.getString("colour");
                        int Year = table.getInt("year");
                        Cars cars = new Cars(carID, serial_number, modelCar, color, Year);
                        result.add(cars);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Cars> getAllCar() {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
            if (cn != null) {
                //step 2:
                String sql = "select *"
                        + " FROM Cars";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                //step 3:
                if (table != null) {
                    while (table.next()) {
                        int CarID = table.getInt("CarID");
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        int year = table.getInt("year");
                        Cars car = new Cars(CarID, serialNumber, model, colour, year);
                        result.add(car);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteCustomer(String carId) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = MyConnection.getConnection();
            if (cn != null) {
                String sqlDeleteCar = "DELETE FROM Cars WHERE carID = ?";
                PreparedStatement preparedStatement = cn.prepareStatement(sqlDeleteCar);
                preparedStatement.setString(1, carId); // carId là giá trị ID của xe bạn muốn xóa
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cars> getCarById(String carID) {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
            if (cn != null) {
                //step 2:
                String sql = "select *"
                        + " FROM Cars"
                        + " WHERE carID = ?";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, carID);
                ResultSet table = pst.executeQuery();
                //step 3:
                if (table != null) {
                    while (table.next()) {
                        int CarID = table.getInt("CarID");
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        int year = table.getInt("year");
                        Cars car = new Cars(CarID, serialNumber, model, colour, year);
                        result.add(car);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateCar(int carID, String serialNumber, String model, String colour, int year) {
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
            if (cn != null) {
                //step 2:
                String sql = "UPDATE Cars\n"
                        + "SET\n"
                        + "serialNumber = ?,\n"
                        + "model = ?,\n"
                        + "colour = ?,\n"
                        + "[year] = ?\n"
                        + "where carID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, carID);
                pst.setString(2, serialNumber);
                pst.setString(3, model);
                pst.setString(4, colour);
                pst.setInt(5, year);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
