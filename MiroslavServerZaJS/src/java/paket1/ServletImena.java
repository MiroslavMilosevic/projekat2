/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milosevic
 */
@WebServlet(name = "ServletImena", urlPatterns = {"/ServletImena"})
public class ServletImena extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
//       String username = request.getParameter("username");
//        String password = request.getParameter("password");
        BazaKlasa bk=new BazaKlasa();
        ArrayList<Osoba> lista=new ArrayList<>();
        lista=bk.vratiArrayListuImena();
        try (PrintWriter out = response.getWriter()) {

              response.addHeader("Access-Control-Allow-Origin", "*");
           
            out.println("{ \"nizImena\":[");
                    for(int i=0;i<lista.size();i++){
                    out.println("{\"username\":\""+lista.get(i).username+"\" , \"password\":\""+lista.get(i).password+"\"}");
                    if(i<lista.size()-1){
                    out.println(",");
                    }
                    }
            
             out.println("]}");
                        
            
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
