/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket1;

import java.util.ArrayList;

/**
 *
 * @author Milosevic
 */
public class Komentar {
    String idKometara;
    String idLokala;
    String komentar;
    public Komentar(String idKometara, String idLokala, String komentar){
    this.idKometara=idKometara;
    this.idLokala=idLokala;
    this.komentar=komentar;
    }
      public Komentar(){
  
    }
    
    public String vratiPodudarneKomentare(Lokal lokal, ArrayList<Komentar> lista2){
     ArrayList<String> lista=new ArrayList<>();
     
     for(int i=0;i<lista2.size();i++){
//  
     if(lista2.get(i).idLokala.equals(String.valueOf(lokal.id))){     
     lista.add(lista2.get(i).komentar);
     }
     
     }
     String str="";
     for(int j=0;j<lista.size();j++){
     str+="\""+lista.get(j)+"\"";
     if(j<lista.size()-1){
        str+=",";
     }
     
     }
        
        

return str;
}
    
}


