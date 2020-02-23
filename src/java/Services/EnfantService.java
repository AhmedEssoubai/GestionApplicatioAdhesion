/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zed
 */
public class EnfantService implements iServices<Enfant>{
    
    @Override
    public boolean _Add(Enfant e) {
        
            
          try {
              st=con.createStatement();
              String Query = "insert into enfant values";
              st.executeQuery(Query);
              st.close();
              con.close();
              return true;
           }catch(SQLException ex){ System.out.println("connexion non établit KEKW") ; return false; }
          
    }

    @Override
    public Enfant _get(int id) {
        try {
                Enfant e1 = null;
              //st=con.createStatement();
              String Query = "select * from enfant where id="+id;
              ResultSet res = st.executeQuery(Query);
              
               if(res.next())
            {
               
                Date date_naissence = new SimpleDateFormat("dd/MM/yyyy").parse(res.getString("date_naissence"));
                 e1 = new Enfant(id,res.getString("nom"),res.getString("prenom"),res.getString("cne"),res.getString("email"),date_naissence,res.getString("grade"),res.getInt("ID_Famille"));
                st.close();
                //con.close();
                
            }      //
             return e1;
           }catch(SQLException ex){ System.out.println("connexion non établit") ;  } 
            catch (ParseException ex) {Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);}
            
             return null;
    }

    @Override
    public ArrayList<Enfant> _getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean _delete(Enfant T) {
        try {
              //st=con.createStatement();
              String Query = "delete from enfant values";
              st.executeQuery(Query);
              st.close();
              //con.close();
              return true;
           }catch(SQLException ex){ System.out.println("connexion non établit KEKW") ; return false; }
    }

    

    @Override
    public boolean _update(int id,Enfant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    

    
    
}
