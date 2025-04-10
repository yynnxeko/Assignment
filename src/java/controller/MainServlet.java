/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BAO MINH
 */
public class MainServlet extends HttpServlet {

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
        String url = "error.jsp";
        try {
            request.setCharacterEncoding("utf-8");
            String a = request.getParameter("action");
            if (a == null) {
                a = "home";
            }
            switch (a) {
                case "CustomerLogin":
                    url = "LoginCustServlet";
                    break;
                case "custhome":
                    url = "loginCustPage.jsp";
                    break;
                case "custdashboard":
                    url = "customerDashboard.jsp";
                    break;
                case "Search_Invoice":
                    url = "SearchInvoiceServlet";
                    break;
                case "home":
                    url = "loginSalePage.jsp";
                    break;
                case "Login":
                    url = "LoginSaleServlet";
                    break;
                case "dashboard":
                    url = "salePersonDashboard.jsp";
                    break;
                case "Find_Customer":
                    url = "SearchCutomerServlet";
                    break;
                case "find_car":
                    url = "SearchCarServlet";
                    break;
                case "error":
                    url = "error.jsp";
                    break;
                case "Update_Customer":
                    url = "UpdateCustServlet";
                    break;                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
