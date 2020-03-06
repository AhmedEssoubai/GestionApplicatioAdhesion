package Controllers;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

@DataSourceDefinition(
        name="java:app/env/jdbc/app",
        className="org.apache.derby.jdbc.ClientDataSource",
        portNumber = 1527,
        user="root",
        password="123456",
        serverName = "localhost",
        databaseName = "g-app-adhesion"
 )
/**
 *
 * @author ahmed
 */
public abstract class Controller extends HttpServlet {
    @Resource(lookup = "java:app/env/jdbc/app")
    private DataSource data;
    
    protected DataSource getData()
    {
        return data;
    }
}
