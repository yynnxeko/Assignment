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
 * @author ASUS
 */
public class CustomerDAO {

    public Customer checkLogin(String name, String phone) {
        Customer rs = null;
        Connection cn = null;
        try {
            cn = MyConnection.getConnection();
            if (cn != null) {
                String sql = "select custID,custName,phone,sex,cusAddress"
                        + "\n from Customer"
                        + "\n where custName like N'" + name + "'and phone =?";
                PreparedStatement st = cn.prepareStatement(sql);
//              st.setString(1, name);
                st.setString(1, phone);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int custid = table.getInt("custID");
                        String custname = table.getString("custName");
                        String sex = table.getString("sex");
                        String custadd = table.getString("cusAddress");
                        rs = new Customer(custid, custname, phone, sex, custadd);

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ArrayList<Customer> getAllCustomersById(int id) {
        ArrayList<Customer> result = new ArrayList<>();
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
            if (cn != null) {
                //step 2:
                String sql = "select custID, custName, phone, sex, cusAddress"
                        + " FROM Customer"
                        + " WHERE custID = " + id;

                PreparedStatement pst = cn.prepareStatement(sql);

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

    public void updateCustomer(int cusID, String custName, String phone, String sex, String cusAddress) {
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
        if (cn != null) {
            //step 2:
            String sql = "UPDATE Customer\n"
                    + " SET \n"
                    + " custName = ?,\n"
                    + " phone = ?,\n"
                    + " sex = ?,\n"
                    + " cusAddress = ?\n"
                    + " WHERE custID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, custName);
            pst.setString(2, phone);
            pst.setString(3, sex);
            pst.setString(4, cusAddress);
            pst.setInt(5, cusID);
            pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
