/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milosevic
 */
@WebServlet(name = "PostIProveraServlet", urlPatterns = {"/PostIProveraServlet"})
public class PostIProveraServlet extends HttpServlet {


  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//           String comment="";
           String comment=request.getParameter("comment");
           String id=request.getParameter("id");
           String like=request.getParameter("like");
           BazaKlasa bk=new BazaKlasa();

           
           bk.upisiKomentarUBazu("INSERT INTO js_proba1.comments (lok_id, com_comment)VALUES ("+id+",'"+comment+"');");
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            response.addHeader("Access-Control-Allow-Origin", "*");
            
            out.println("{ \"komentar\":\""+comment+"\" ,\"id\":\""+id+"\"  }");
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
