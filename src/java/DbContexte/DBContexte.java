/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbContexte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Zed
 */
public class DBContexte {
    private Connection connexion;
    private static DBContexte assistant;
    
    private DBContexte() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		
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
