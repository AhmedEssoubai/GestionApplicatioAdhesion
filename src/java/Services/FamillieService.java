package Services;
import Models.*;
import DbContexte.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Zed
 */
public class FamillieService implements IServices<Famille>{
    
    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    
    
    public FamillieService(DataSource data) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        assistant = DBContexte.getAssistant(data);
    }
    
    @Override
    public int add(Famille obj) {
        try
        {
            preparedStatement = assistant.prepareStatement("INSERT INTO FAMILLES(ID_UTILISATEUR, delegue, recevoir)VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);	
            preparedStatement.setInt(1, obj.getID_UTILISATEUR());
            preparedStatement.setBoolean(2, obj.getDELEGUE_OPT());
            preparedStatement.setBoolean(3, obj.getRECEVOIR_OPT());
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
    public Famille get(int ID_Famille) {
        Famille famille = null;
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT * FROM FAMILLES WHERE NUM_ADHESION = ?");

            preparedStatement.setInt(1, ID_Famille);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next())
            {
                famille = new Famille(result.getInt(1),result.getInt(2) ,result.getInt(5),result.getBoolean(4), result.getBoolean(3), null, null);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return famille;
    }

    @Override
    public ArrayList<Famille> getAll() {
        ArrayList<Famille> list_famille = new ArrayList<>();
        try
        {
            ResultSet result = assistant.createStatement().executeQuery("SELECT * FROM FAMILLES");

            while (result.next())
            {
                list_famille.add(new Famille(result.getInt(1),result.getInt(2) ,result.getInt(5), result.getBoolean(4), result.getBoolean(3), null, null));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list_famille;
    }

    @Override
    public boolean delete(Famille obj) {
        try
        {
            preparedStatement = assistant.prepareStatement("DELETE FROM FAMILLES WHERE NUM_ADHESION= ?");
            preparedStatement.setInt(1, obj.getNUM_adhesion());
            preparedStatement.execute();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Famille obj) {
        try
        {
            preparedStatement = assistant.prepareStatement("UPDATE FAMILLES SET ID_UTILISATEUR=?,ID_TUTEUR=?, delegue=?, recevoir=? WHERE NUM_ADHESION= ?");	

            preparedStatement.setInt(1, obj.getID_UTILISATEUR());
            preparedStatement.setInt(2, obj.getID_TUTEUR());
            preparedStatement.setBoolean(3, obj.getDELEGUE_OPT());
            preparedStatement.setBoolean(4, obj.getRECEVOIR_OPT());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException ex) {
                ex.printStackTrace();
        }
        return false;
    }
    
    public int hasFamily(Utilisateur utilisateur) {
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT num_adhesion FROM FAMILLES WHERE id_utilisateur = ?");
            preparedStatement.setInt(1, utilisateur.getID());
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.next())
                return result.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<String> getEmails()
    {
        ArrayList<String> emails = new ArrayList<>();
        try
        {
            ResultSet result = assistant.createStatement().executeQuery("SELECT p.email FROM FAMILLES f, PARENTS p WHERE f.ID_TUTEUR = p.ID AND f.RECEVOIR");

            while (result.next())
                emails.add(result.getString(1));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return emails;
    }
}
