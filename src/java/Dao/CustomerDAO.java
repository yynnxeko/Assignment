/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;
import mylib.MyConnection;

/**
 *
 * @author ASUS
 */
public class CustomerDAO {
    public Customer checkLogin(String name, String phone){
        Customer rs=null;
        Connection cn=null;
        try{
          cn=MyConnection.getConnection();
          if(cn!=null){
              String sql = "select custID,custName,phone,sex,cusAddress"
                      + "\n from Customer"
                      + "\n where custName = N'"+ name +"'and phone=?";
              PreparedStatement st=cn.prepareStatement(sql);
//              st.setString(1, name);
              st.setString(1, phone);
              ResultSet table=st.executeQuery();
                if(table!=null){
                  while(table.next()){
                      int custid=table.getInt("custID");
                      String custname=table.getString("custName");
                      String sex=table.getString("sex");
                      String custadd=table.getString("cusAddress");
                      rs=new Customer(custid, custname, phone, sex, custadd);
                      
                  }
              }
          }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}
