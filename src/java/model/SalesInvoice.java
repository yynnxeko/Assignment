/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class SalesInvoice {
    private int invoiceID;
    private Date createdate;
    private int saleID;    
    private int carID;
    private int custID;

    public SalesInvoice(int custID) {
        this.custID = custID;
    }

    public SalesInvoice(int invoiceID, Date createdate, int saleID, int carID, int custID) {
        this.invoiceID = invoiceID;
        this.createdate = createdate;
        this.saleID = saleID;
        this.carID = carID;
        this.custID = custID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    
}
