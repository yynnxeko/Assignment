/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author BAO MINH
 */
public class Ticket {
    private int ServiceTicketID;
    private Date DateReceived;
    private Date DateReturned;
    private int CustID;
    private int CarID;

    public Ticket() {
    }

    public Ticket(int ServiceTicketID, Date DateReceived, Date DateReturned, int CustID, int CarID) {
        this.ServiceTicketID = ServiceTicketID;
        this.DateReceived = DateReceived;
        this.DateReturned = DateReturned;
        this.CustID = CustID;
        this.CarID = CarID;
    }

    public int getServiceTicketID() {
        return ServiceTicketID;
    }

    public void setServiceTicketID(int ServiceTicketID) {
        this.ServiceTicketID = ServiceTicketID;
    }

    public Date getDateReceived() {
        return DateReceived;
    }

    public void setDateReceived(Date DateReceived) {
        this.DateReceived = DateReceived;
    }

    public Date getDateReturned() {
        return DateReturned;
    }

    public void setDateReturned(Date DateReturned) {
        this.DateReturned = DateReturned;
    }

    public int getCustID() {
        return CustID;
    }

    public void setCustID(int CustID) {
        this.CustID = CustID;
    }

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }
    
    
}
