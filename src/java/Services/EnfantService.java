package Services;

import Models.*;
import DbContexte.*;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;


/**
 *
 * @author Zed
 */
public class EnfantService implements IServices<Enfant>{
    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    
    public EnfantService(DataSource data) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        assistant = DBContexte.getAssistant(data);
    }

    
    @Override
    public int add(Enfant e) {
        try
        {
            preparedStatement = assistant.prepareStatement("INSERT INTO ENFANTS(NOM,PRENOM,CNE,DATE_NAISSENCE,GRADE,ASSURANCE,ID_FAMILLE)VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);	
            preparedStatement.setString(1, e.getNom());
            preparedStatement.setString(2, e.getPrenom());
            preparedStatement.setString(3, e.getCne());
            preparedStatement.setDate(4, new java.sql.Date(e.getDate_naissence().getDate())); 
            preparedStatement.setString(5, e.getGrade());
            preparedStatement.setString(6, e.getAssurance());
            preparedStatement.setInt(7, e.getID_famille());
            preparedStatement.execute();
            
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return (int)generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating failed, no ID obtained.");
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Enfant get(int id) {
        Enfant enfant = null;
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT * FROM ENFANTS WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next())
            {
                enfant = new Enfant(result.getInt(1), result.getString(3), result.getString(2), result.getString(4), result.getDate(5), result.getString(6), result.getString(7), result.getInt(8));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return enfant;
    }

    @Override
    public ArrayList<Enfant> getAll() {
        ArrayList<Enfant> result_list= new ArrayList<>();
        try
        {
            ResultSet result = assistant.createStatement().executeQuery("SELECT * FROM ENFANTS ");

            while (result.next())
            {
                result_list.add(new Enfant(result.getInt(1), result.getString(3), result.getString(2), result.getString(4), result.getDate(5), result.getString(6), result.getString(7), result.getInt(8)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result_list;
    }
    
    public ArrayList<Enfant> getByFamily(int ID_Famille) {
        ArrayList<Enfant> result_list= new ArrayList<>();
        try
	{
            preparedStatement = assistant.prepareStatement("SELECT * FROM ENFANTS WHERE ID_FAMILLE=?");
            preparedStatement.setInt(1, ID_Famille);
			
            ResultSet result = preparedStatement.executeQuery();
			
            while (result.next())
            {
                result_list.add(new Enfant(result.getInt(1), result.getString(3), result.getString(2), result.getString(4), result.getDate(5), result.getString(6), result.getString(7), result.getInt(8)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result_list;
    }
    
    public int getCountByFamily(int ID_Famille) {
        int count = 0;
        try
	{
            preparedStatement = assistant.prepareStatement("SELECT COUNT(*) FROM ENFANTS WHERE ID_FAMILLE=?");
            preparedStatement.setInt(1, ID_Famille);
			
            ResultSet result = preparedStatement.executeQuery();
			
            if (result.next())
                count = result.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean delete(Enfant T) {
        try
        {
            preparedStatement = assistant.prepareStatement("DELETE FROM ENFANTS WHERE id = ?");
            preparedStatement.setInt(1, T.getID());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    

    @Override
    public boolean update(int id,Enfant obj) {
        try
        {
            preparedStatement = assistant.prepareStatement("UPDATE ENFANTS SET NOM=?,PRENOM=?,CNE=?,DATE_NAISSENCE=?,GRADE=?,ASSURANCE=?,ID_FAMILLE=? WHERE id=?");	

            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.setString(3, obj.getCne());
            preparedStatement.setDate(4,new java.sql.Date(obj.getDate_naissence().getDate())); 
            preparedStatement.setString(5, obj.getGrade());
            preparedStatement.setString(6, obj.getAssurance());
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
