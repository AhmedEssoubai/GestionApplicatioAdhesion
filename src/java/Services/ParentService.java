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

    Parents parent = null;
		try
		{
			preparedStatement = assistant.prepareStatement("SELECT * FROM PARENTS WHERE id = ?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next())
			{
				parent = new Parents(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return parent;
    
    }

    @Override
    public ArrayList<Parents> _getAll() {
         ArrayList<Parents> result_list= new ArrayList<Parents>();
        try
		{	
			ResultSet result = assistant.createStatement().executeQuery("SELECT * FROM  PARENTS ");
			
			while (result.next())
			{
				result_list.add(new Parents(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8)));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result_list;
    
    
    }
    public ArrayList<Parents> _getAll_byFamily(int ID_Famille) {
        ArrayList<Parents> result_list= new ArrayList<Parents>();
        try
		{
			
			
			preparedStatement = assistant.prepareStatement("SELECT * FROM PARENTS WHERE ID_FAMILLE=?");
                        preparedStatement.setInt(1, ID_Famille);
			
			ResultSet result = preparedStatement.executeQuery();
			
			while (result.next())
			{
				result_list.add(new Parents(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8)));
                        }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result_list;
    }

    
    @Override
    public boolean _delete(Parents obj) {
             try
		{
			preparedStatement = assistant.prepareStatement("DELETE FROM PARENTS WHERE id = ?");
			preparedStatement.setInt(1, obj.getID());
			preparedStatement.execute();
                        //enfant should be deleted from family's arraylist 
                        try{ 
                            FamillieService e = new FamillieService();
                            UserService u = new UserService();
                            Famille myfamily = e._get(obj.getID_famille());
                                myfamily.delete_Tut(obj);
                            u._delete(u._get(obj.getID()));
                                }catch(Exception e){
                            System.out.println(e.getMessage());
                                    } 
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

    @Override
    public boolean _update(int id, Parents obj) {

         try
		{
			preparedStatement = assistant.prepareStatement("UPDATE PARENTS SET PRENOM=?,NOM=?,CIN=?,TEL=?,EMAIL=?,PROFESSION=?,ID_FAMILLE=? WHERE ID=?");	
			
                        preparedStatement.setString(1,obj.getPrenom() );
                        preparedStatement.setString(2,obj.getNom() );
                        preparedStatement.setString(3, obj.getCin());
                        preparedStatement.setString(4,obj.getTel()); 
			preparedStatement.setString(5, obj.getEmail());
                        preparedStatement.setString(6, obj.getProfession());
			preparedStatement.setInt(7, obj.getID_famille());
                        preparedStatement.setInt(8, id);
			preparedStatement.execute();
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
    
    }
    
}
