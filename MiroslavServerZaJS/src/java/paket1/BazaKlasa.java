/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BazaKlasa {
    public ResultSet vratiSetLokala(String sqlQuery){
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456789");
                  Statement stmt = conn.createStatement();
                  if(sqlQuery.equals("all")||sqlQuery.equals("")||sqlQuery.equals(null)){
                  rs = stmt.executeQuery("SELECT * FROM js_proba1.lokali");
                  }else if(sqlQuery.equals("")){}
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        }           
                  return rs;
}////////////////////
    public ArrayList<Komentar> vratiListuKomentara(){
        ResultSet rs=null;
        ArrayList<Komentar> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456789");
                  Statement stmt = conn.createStatement();
                 
                  rs = stmt.executeQuery("SELECT * FROM js_proba1.comments;");
                   
        while(rs.next()){
         
          lista.add(new Komentar(String.valueOf(rs.getInt(1)), String.valueOf(rs.getInt(2)), rs.getString(3)));
        }
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        }           
       
                  return lista;
                  
} 
    public void upisiKomentarUBazu(String sql){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456789");
                  Statement stmt = conn.createStatement();
                  stmt.execute(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    
    }
      public void Lajkuj(int id){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456789");
                  Statement stmt = conn.createStatement();
                  ResultSet rs=stmt.executeQuery("select lok_rating from js_proba1.lokali where lok_id='"+id+"';");
                  rs.next();
                  int rating=Integer.valueOf(rs.getString(1));
                  rating=rating+1;
                  stmt.execute("UPDATE js_proba1.lokali SET lok_rating = '"+rating+"' WHERE lok_id = '"+id+"'");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    
    }
      
      public boolean UpisiKorisnikaAkoNePostoji(String username, String password){
          boolean b=false;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456789");
                  Statement stmt = conn.createStatement();
                  ResultSet rs=stmt.executeQuery("select * from js_proba1.imena where ime_username='"+username+"';");
                  ArrayList<String> lista=new ArrayList<>();
                  while(rs.next()){
                  
                  lista.add(rs.getString(2));
                  
                  }
                  
                  if(lista.size()==0){
                   b=true;   
                  stmt.execute("insert into js_proba1.imena (ime_username, ime_password) values ('"+username+"','"+password+"');");
                  }else{
                      b=false;
                  }
                  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
      return b;
      }
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            public ArrayList<Osoba> vratiArrayListuImena(){
                ArrayList<Osoba> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456789");
                  Statement stmt = conn.createStatement();
                  ResultSet rs=stmt.executeQuery("SELECT * FROM js_proba1.imena");
                 
                  while(rs.next()){
                  
                      lista.add(new Osoba(rs.getString(2), rs.getString(3)));
                  
                  }
                  
                
                  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BazaKlasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
      return lista;
      }
      


}


