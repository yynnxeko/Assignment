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
import model.Ticket;
import mylib.MyConnection;

/**
 *
 * @author BAO MINH
 */
public class TicketDao {
    public ArrayList<Ticket> getAllTicket() {
        ArrayList<Ticket> result = new ArrayList<>();
        Connection cn = null;
        try {
            //step 1:
            cn = MyConnection.getConnection();
            if (cn != null) {
                //step 2:
                String sql = "select *"
                        + " FROM ServiceTicket";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                //step 3:
                if (table != null) {
                    while (table.next()) {
                        int ServiceTicketID = table.getInt("ServiceTicketID");
                        String DateReceived = table.getString("DateReceived");
                        Date DateReturned = table.getDate("DateReturned");
                        Date CustID = table.getDate("CustID");
                        int CarID = table.getInt("CarID");
                        Ticket ticket = new Ticket(ServiceTicketID, DateReturned, DateReturned, CarID, CarID);
                        result.add(ticket);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
