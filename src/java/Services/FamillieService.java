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
/**
 *
 * @author Zed
 */
public class FamillieService implements iServices<Famille>{
    
    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    @Override
    public boolean _Add(Famille obj) {
 try
		{
			preparedStatement = assistant.prepareStatement("INSERT INTO FAMILLES(ID_UTILISATEUR,ID_TUTEUR)VALUES(?,?)");	
			preparedStatement.setInt(1, obj.getID_UTILISATEUR());
                        preparedStatement.setInt(2, obj.getID_TUTEUR());
			preparedStatement.execute();
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
    
    
    
    }

    @Override
    public Famille _get(int ID_Famille) {
        Famille famille = null;
		try
		{
			preparedStatement = assistant.prepareStatement("SELECT * FROM FAMILLES WHERE NUM_ADHESION = ?");
			
			preparedStatement.setInt(1, ID_Famille);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next())
                        {
                            EnfantService enService = new EnfantService();
                            ParentService ParentService = new ParentService() ;
			      famille = new Famille(result.getInt(1),result.getInt(2) ,result.getInt(3) , enService._getAll_byFamily(ID_Famille), ParentService._getAll_byFamily(ID_Famille));
                         }
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return famille;
    }

    @Override
    public ArrayList<Famille> _getAll() {
            ArrayList<Famille> list_famille = null;
		try
		{
			
			
			ResultSet result = assistant.createStatement().executeQuery("SELECT * FROM FAMILLES");
			
			while (result.next())
                        {
                            EnfantService enService = new EnfantService();
                            ParentService parentService = null;
			      list_famille.add(new Famille(result.getInt(1),result.getInt(2) ,result.getInt(3) , enService._getAll_byFamily(result.getInt(1)), null));
                         }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException E){
                    E.printStackTrace();
                } catch (InstantiationException ex) {
                 Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
            Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return list_famille;
    
    
    
    }

    @Override
    public boolean _delete(Famille obj) {
        try
		{
			preparedStatement = assistant.prepareStatement("DELETE FROM FAMILLES WHERE NUM_ADHESION= ?");
			preparedStatement.setInt(1, obj.getID_famille());
			
                        EnfantService e = new EnfantService();
                        ParentService p = new ParentService();
                        obj.delete_Tut(p._get(obj.getID_TUTEUR()));
                        for(Enfant enf : e._getAll_byFamily(obj.getID_famille())){e._delete(enf);}
                        preparedStatement.execute();
                         
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FamillieService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return false;
    }

    @Override
    public boolean _update(int id, Famille obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
