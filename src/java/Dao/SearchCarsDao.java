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
import mylib.MyConnection;

/**
 *
 * @author BAO MINH
 */
public class SearchCarsDao {

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
}
