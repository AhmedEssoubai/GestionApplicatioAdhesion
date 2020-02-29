/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbContexte;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.Resource;




public class DBContexte {
    @Resource(lookup = "jdbc:derby://localhost:1527/g-app-adhesion")
    private DataSource data;
    private Connection con;
    private static DBContexte assistant;
    
    private DBContexte() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/g-app-adhesion","root","123456");
	}
    public static DBContexte getAssistant() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		if (assistant == null)
			assistant = new DBContexte();
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
