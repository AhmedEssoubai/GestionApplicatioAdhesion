/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Models.*;
import DbContexte.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParentService implements iServices<Parents>{

    
    
    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    
    
    public ParentService() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		assistant = DBContexte.getAssistant();
	}
    
    
    
    @Override
    public boolean _Add(Parents obj) {
 try
		{
			preparedStatement = assistant.prepareStatement("INSERT INTO PARENTS(PRENOM,NOM,CIN,TEL,EMAIL,PROFESSION,ID_FAMILLE)VALUES(?,?,?,?,?,?,?)");	
			preparedStatement.setString(1, obj.getPrenom());
                        preparedStatement.setString(2, obj.getNom());
                        preparedStatement.setString(3, obj.getCin());
                        preparedStatement.setString(4,obj.getTel()); 
			preparedStatement.setString(5, obj.getEmail());
                        preparedStatement.setString(6, obj.getProfession());
			preparedStatement.setInt(7, obj.getID_famille());
			preparedStatement.execute();
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
    
    
    }

    @Override
    public Parents _get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Parents> _getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean _delete(Parents obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean _update(int id, Parents obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
