/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milosevic
 */
@WebServlet(name = "ServletAPI", urlPatterns = {"/ServletAPI"})
public class ServletAPI extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
    
        
//        BazaKlasa bazaklasa=new BazaKlasa();
       ArrayList<Lokal> lista=new ArrayList<>();
       ArrayList<Komentar> listaKomentara=new ArrayList<>();
    
        try {
//                
                 BazaKlasa bk=new BazaKlasa();
                 listaKomentara=bk.vratiListuKomentara();
                 ResultSet rs=bk.vratiSetLokala("");
                  while(rs.next()){
                  Lokal lokal=new Lokal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(8),rs.getString(7));
                  lista.add(lokal);
                  }
       //
        } catch (SQLException ex) {
            Logger.getLogger(ServletAPI.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
            response.addHeader("Access-Control-Allow-Origin", "*");
              response.addHeader("Access-Control-Allow-Methods", "*");
                 String comment = request.getParameter("comment");
                   
        try (PrintWriter out = response.getWriter()) {

                            out.println("{");
                            
                            out.println("\"nizLokala\":[");
             for(int i=0;i<lista.size();i++){ 
                 Komentar kom=new Komentar();
                  out.println("{\"id\":\""+lista.get(i).id+"\",\"name\":\""+lista.get(i).name+"\", \"adress\":\""+lista.get(i).adress+"\","
                          + " \"img\":\""+lista.get(i).img+"\", \"type\":\""+lista.get(i).type+"\", \"rating\":\""+lista.get(i).rating+"\""
                                  + ",\"avgPrice\":\"" + lista.get(i).avgPrice +"\",\"capacity\":\""+ lista.get(i).capacity +"\" , \"nizKomentara\":["
                          +kom.vratiPodudarneKomentare(lista.get(i), listaKomentara)+"] }"); 

             if(i!=lista.size()-1){ out.println(",");}
             }
              out.println("], \"nizImena\":[1,1,1,2,5]");
//                  if(comment!=null){
//                           response.addHeader("Access-Control-Allow-Origin", "*");
//              response.addHeader("Access-Control-Allow-Methods", "*");
//                  out.println(",\"komentar\":\""+comment+"\"");
//                  }
               out.println("}");
               
               



          

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
