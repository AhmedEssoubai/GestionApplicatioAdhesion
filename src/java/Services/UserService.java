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

/**
 *
 * @author Zed
 */
public class UserService implements iServices<Utilisateur>{
    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    
    public UserService() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		assistant = DBContexte.getAssistant();
	}
    @Override
    public boolean _Add(Utilisateur obj) {
try
		{
			preparedStatement = assistant.prepareStatement("INSERT INTO UTILISATEURS(EMAIL,PASSWORD)VALUES(?,?)");	
			preparedStatement.setString(1, obj.getEmail());
                        preparedStatement.setString(2, obj.getPassword());
			preparedStatement.execute();
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;    }

    @Override
    public Utilisateur _get(int id) {
        Utilisateur utilisateur = null;
		try
		{
			preparedStatement = assistant.prepareStatement("SELECT * FROM UTILISATEURS WHERE id = ?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next())
			{
				utilisateur = new Utilisateur(result.getInt(1), result.getString(2), result.getString(3));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
    }

    @Override
    public ArrayList<Utilisateur> _getAll() {
         ArrayList<Utilisateur> result_list= new ArrayList<Utilisateur>();
        try
		{
			ResultSet result = assistant.createStatement().executeQuery("SELECT * FROM UTILISATEURS ");
			
			while (result.next())
			{
				result_list.add(new Utilisateur(result.getInt(1), result.getString(2), result.getString(3)));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result_list;
    
    }

    @Override
    public boolean _delete(Utilisateur obj) {
        try
		{
			preparedStatement = assistant.prepareStatement("DELETE FROM UTILISATEURS WHERE id = ?");
			preparedStatement.setInt(1, obj.getID());
			preparedStatement.execute();
                        
                        return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

    @Override
    public boolean _update(int id, Utilisateur obj) {
        try
		{
			preparedStatement = assistant.prepareStatement("UPDATE UTILISATEURS SET EMAIL=?,PASSWORD=? WHERE id=?");	
			
                        preparedStatement.setString(1, obj.getEmail());
                        preparedStatement.setString(2, obj.getPassword());
                        preparedStatement.setInt(3, id);
			preparedStatement.execute();
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
    
    
    }
    /*public ArrayList<Utilisateur> _getAll_byFamily(int ID_Famille) {
        ArrayList<Utilisateur> result_list= new ArrayList<Enfant>();
        try
		{
			
			
			preparedStatement = assistant.prepareStatement("SELECT * FROM ENFANTS WHERE ID_FAMILLE=?");
                        preparedStatement.setInt(1, ID_Famille);
			
			ResultSet result = preparedStatement.executeQuery();
			
			while (result.next())
			{
				result_list.add(new Enfant(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5), result.getString(6), result.getString(7), result.getInt(8)));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result_list;
    }*/
}
