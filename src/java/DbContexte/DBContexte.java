/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbContexte;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.Resource;

@DataSourceDefinition(name = "jdbc:derby://localhost:1527/g-app-adhesion",   
className = "org.apache.derby.jdbc.ClientDataSource",   
portNumber = 1527,   
serverName = "localhost",   
databaseName = "g-app-adhesion")


public class DBContexte {
    @Resource(lookup = "jdbc:derby://localhost:1527/g-app-adhesion") 
    private DataSource data;
    private Connection connexion;
    private static DBContexte assistant;
    
    private DBContexte() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
        connexion = data.getConnection("root","123456");
	}
    public static DBContexte getAssistant() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		if (assistant == null)
			assistant = new DBContexte();
		return assistant;
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException
	{
		return connexion.prepareStatement(sql);
	}
	
	public PreparedStatement prepareStatement(String sql, int statement) throws SQLException
	{
		return connexion.prepareStatement(sql, statement);
	}
	
	public Statement createStatement() throws SQLException
	{
		return connexion.createStatement();
	}
    
    
    
    
    
    
    
    
    
    
    
}
