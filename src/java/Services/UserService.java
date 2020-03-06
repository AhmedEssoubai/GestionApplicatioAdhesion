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
public class UserService implements IServices<Utilisateur>{
    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    
    public UserService(DataSource data) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        assistant = DBContexte.getAssistant(data);
    }
    
    @Override
    public int add(Utilisateur obj) {
        try
        {
            preparedStatement = assistant.prepareStatement("INSERT INTO UTILISATEURS(EMAIL,PASSWORD)VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);	
            preparedStatement.setString(1, obj.getEmail());
            preparedStatement.setString(2, obj.getPassword());
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
    public Utilisateur get(int id) {
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT * FROM UTILISATEURS WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next())
            {
                return new Utilisateur(result.getInt(1), result.getString(2), result.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Utilisateur verify(String email,String password) {
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT * FROM UTILISATEURS WHERE EMAIL = ? AND PASSWORD=?");

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next())
            {
                return new Utilisateur(result.getInt(1), result.getString(2), result.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Utilisateur> getAll() {
         ArrayList<Utilisateur> result_list= new ArrayList<>();
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
    public boolean delete(Utilisateur obj) {
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
    public boolean update(int id, Utilisateur obj) {
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
