/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SalesPerson;
import mylib.MyConnection;

/**
 *
 * @author ASUS
 */
public class SalesPersonDao {

    public SalesPerson checkLogin(String name) {
        SalesPerson rs = null;
        Connection cn = null;
        try {
            cn = MyConnection.getConnection();
            if (cn != null) {
                String sql = "select salesID,salesName,birthday,sex,salesAddress "
                        + "from SalesPerson"
                        + " where salesName = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int custid = table.getInt("salesID");
                        String custname = table.getString("salesName");
                        Date birthday = table.getDate("birthday");
                        String sex = table.getString("sex");
                        String custadd = table.getString("salesAddress");
                        rs = new SalesPerson(custid, custname, birthday, sex, custadd);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
