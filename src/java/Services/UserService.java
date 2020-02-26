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
    @Override
    public boolean _Add(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur _get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Utilisateur> _getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean _delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean _update(int id, Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
