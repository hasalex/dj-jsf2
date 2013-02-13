package org.librairie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public abstract class AbstractDao {
    protected boolean resource = true; //false  = hors conteneur; true = avec conteneur (Tomcat, JBoss)

    public AbstractDao() {}
    
    public AbstractDao(boolean resource) {
        this.resource = resource;
    }

    // Ouverture connexion
    protected Connection getConnection() throws Exception {
        Connection connection = null;
        if (resource) {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/LibrairieDS");
            connection = ds.getConnection();
        }
        else {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:tcp://localhost/librairie";
            connection = DriverManager.getConnection(url, "sa", "");
        }
        return connection;
    }

    //Fermeture des ressources
    protected void close(Connection connection) {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {}
    }
}
