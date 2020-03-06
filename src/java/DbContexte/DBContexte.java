package DbContexte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


/**
 *
 * @author Zed
 */
public class DBContexte {
    private Connection con;
    private static DBContexte assistant;
    
    private DBContexte(DataSource d) 
        throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        con = d.getConnection();
    }
    
    public static DBContexte getAssistant(DataSource d)
        throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (assistant == null)
                assistant = new DBContexte(d);
        return assistant;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException
    {
        return con.prepareStatement(sql);
    }

    public PreparedStatement prepareStatement(String sql, int statement) throws SQLException
    {
        return con.prepareStatement(sql, statement);
    }

    public Statement createStatement() throws SQLException
    {
        return con.createStatement();
    }
}
