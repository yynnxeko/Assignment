/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.SearchInvoiceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.SalesInvoice;

/**
 *
 * @author ASUS
 */
public class SearchInvoiceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Customer us = (Customer) session.getAttribute("customer");

            if (us == null) {
                request.setAttribute("ERROR", "Wrong InvoiceID");
                request.getRequestDispatcher("MainServlet?action=custdashboard").forward(request, response);
            } else {
                try {
                    SearchInvoiceDAO invoiceDAO = new SearchInvoiceDAO();
                    ArrayList<SalesInvoice> invoiceList = invoiceDAO.searchAllInvoiceById(11013);

                    if (invoiceList == null || invoiceList.isEmpty()) {
                        request.setAttribute("ERROR", "No invoices found for the given ID");
                    } else {
                        request.setAttribute("RESULT_INVOICE", invoiceList);
                    }
                    request.getRequestDispatcher("MainServlet?action=custdashboard").forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("ERROR", "Invalid Invoice ID format");
                    request.getRequestDispatcher("MainServlet?action=custdashboard").forward(request, response);
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
