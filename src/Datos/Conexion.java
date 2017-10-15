/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Conexion {
      private Connection Connection;
	private static Conexion Instance;
   public void connectDatabase() {
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            Connection connectionx = null;
            // Database connect
            // Conectamos con la base de datos
            connectionx = DriverManager.getConnection(
                    "jdbc:postgresql://200.87.51.3:5432/db_grupo08sa",
                    "grupo08sa", "grupo08grupo08");
 
            boolean valid = connectionx.isValid(50000);
           // Connection=connectionx;
            if (connectionx != null) {
			Connection = connectionx;
		}
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }  
        
	/*private Conexion() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(
				String.format("jdbc:postgresql://%s:%s/%s", "200.87.228.58", "5432", "db_grupo08sa"),"grupo08sa",
				"grupo08grupo08");

		if (connection != null) {
			Connection = connection;
		}
	}
     */
     
	public static Conexion getInstance() throws ClassNotFoundException, SQLException {
		if (Instance == null) {
			Instance = new Conexion();
                        Instance.connectDatabase();
		}
		return Instance;
	}

	public Connection getConnection() {
		return Connection;
	}
}
