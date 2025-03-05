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
import model.Customer;
import model.SalesInvoice;
import mylib.MyConnection;

/**
 *
 * @author ASUS
 */
public class SearchInvoiceDAO {

    public ArrayList<SalesInvoice> searchAllInvoiceById(int custid) {
        ArrayList<SalesInvoice> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = MyConnection.getConnection();
            if (cn != null) {
                String sql = "SELECT invoiceID, invoiceDate, salesID, carID, s.custID\n"
                        + "FROM SalesInvoice s\n"
                        + "LEFT JOIN Customer c ON s.custID = c.custID\n"
                        + "where c.custName = '" + custid + "'";

                PreparedStatement pst = cn.prepareStatement(sql);
//                pst.setString(1, "%" + custid + "%");
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while(table.next()) {
                    int invoiceID = table.getInt("invoiceID");
                    Date invoiceDate = table.getDate("invoiceDate");
                    int salesID = table.getInt("salesID");
                    int carID = table.getInt("carID");
                    int custID = table.getInt("custID");
                    SalesInvoice invoice = new SalesInvoice(invoiceID, invoiceDate, salesID, carID, custID);
                    list.add(invoice);
                    }
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
