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
public class ParentService implements IServices<Parent>{

    private DBContexte assistant;
    private PreparedStatement preparedStatement;
    
    public ParentService(DataSource data) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        assistant = DBContexte.getAssistant(data);
    }
    
    @Override
    public int add(Parent obj) {
        try
        {
            preparedStatement = assistant.prepareStatement("INSERT INTO PARENTS(PRENOM, NOM, CIN, TEL, EMAIL, PROFESSION, ID_FAMILLE)VALUES(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);	
            preparedStatement.setString(1, obj.getPrenom());
            preparedStatement.setString(2, obj.getNom());
            preparedStatement.setString(3, obj.getCin());
            preparedStatement.setString(4,obj.getTel()); 
            preparedStatement.setString(5, obj.getEmail());
            preparedStatement.setString(6, obj.getProfession());
            preparedStatement.setInt(7, obj.getID_famille());
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
    public Parent get(int id) {
        Parent parent = null;
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT * FROM PARENTS WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next())
            {
                parent = new Parent(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return parent;
    
    }

    @Override
    public ArrayList<Parent> getAll() {
        ArrayList<Parent> result_list= new ArrayList<>();
        try
        {	
            ResultSet result = assistant.createStatement().executeQuery("SELECT * FROM  PARENTS ");

            while (result.next())
            {
                result_list.add(new Parent(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result_list;
    }
    
    public ArrayList<Parent> getByFamily(int ID_Famille, int except) {
        ArrayList<Parent> result_list= new ArrayList<>();
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT * FROM PARENTS WHERE ID_FAMILLE=? AND ID != ?");
            preparedStatement.setInt(1, ID_Famille);
            preparedStatement.setInt(2, except);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next())
            {
                result_list.add(new Parent(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result_list;
    }
    
    public Parent getByCin(String cin) {
        Parent p = null;   
        try
        {
            preparedStatement = assistant.prepareStatement("SELECT * FROM PARENTS WHERE cin=?");
            preparedStatement.setString(1, cin);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next())
            {
                p = new Parent(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    
    @Override
    public boolean delete(Parent obj) {
        try
        {
            preparedStatement = assistant.prepareStatement("DELETE FROM PARENTS WHERE id = ?");
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
    public boolean update(int id, Parent obj) {
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
