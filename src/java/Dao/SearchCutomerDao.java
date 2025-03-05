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
import model.Customer;
import mylib.MyConnection;

/**
 *
 * @author BAO MINH
 */
public class SearchCutomerDao {

    public ArrayList<Customer> getAllCustomersByName(String name) {
        ArrayList<Customer> result = new ArrayList<>();
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
            if (cn != null) {
                //step 2:
                String sql = "select custID, custName, phone, sex, cusAddress"
                + " FROM Customer"
                + " WHERE custName like ?";
             
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                ResultSet table = pst.executeQuery();
                //step 3:
                if (table != null) {
                    while (table.next()) {
                        int custid = table.getInt("custID");
                        String custname = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String address = table.getString("cusAddress");
                        Customer cu = new Customer(custid, custname, phone, sex, address);
                        result.add(cu);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
