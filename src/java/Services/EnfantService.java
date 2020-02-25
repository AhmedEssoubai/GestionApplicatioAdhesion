/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.*;
import DbContexte.*;
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
    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    
    
    public EnfantService() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		assistant = DBContexte.getAssistant();
	}

    
    @Override
    public boolean _Add(Enfant e) {
          
          try
		{
			preparedStatement = assistant.prepareStatement("INSERT INTO ENFANT(id,NOM,PRENOM,CNE,DATE_NAISSENCE,GRADE,ASSURANCE,ID_FAMILLE)VALUES(?,?,?,?,?,?,?)");	
			preparedStatement.setString(1, e.getPrenom());
                        preparedStatement.setString(2, e.getNom());
                        preparedStatement.setString(3, e.getCne());
                        preparedStatement.setDate(4,new java.sql.Date(e.getDate_naissence().getDate())); 
			preparedStatement.setString(5, e.getGrade());
                        preparedStatement.setString(6, e.getAssurance());
			preparedStatement.setInt(7, e.getID_famille());
			preparedStatement.execute();
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
          
    }

    @Override
    public Enfant _get(int id) {
        Enfant enfant = null;
		try
		{
			preparedStatement = assistant.prepareStatement("SELECT * FROM ENFANTS WHERE id = ?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next())
			{
				enfant = new Enfant(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5), result.getString(6), result.getString(7), result.getInt(8));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return enfant;
    }

    @Override
    public ArrayList<Enfant> _getAll() {
        ArrayList<Enfant> result_list= new ArrayList<Enfant>();
        try
		{
			
			
			
			
			ResultSet result = assistant.createStatement().executeQuery("SELECT * FROM ENFANTS ");
			
			while (result.next())
			{
				result_list.add(new Enfant(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5), result.getString(6), result.getString(7), result.getInt(8)));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result_list;
    }

    @Override
    public boolean _delete(Enfant T) {
                 try
		{
			preparedStatement = assistant.prepareStatement("DELETE FROM articles WHERE id = ?");
			preparedStatement.setInt(1, T.getID());
			preparedStatement.execute();
                        //enfant should be deleted from family's arraylist 
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

    

    @Override
    public boolean _update(int id,Enfant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    

    
    
}
