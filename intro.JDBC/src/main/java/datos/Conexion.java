/*
 La clase conexion contiene todos los metodos para trabjar con una conexcion
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ingri
 */
public class Conexion {
    
    //tres constantes url,usuario y contraseña, para no mezclar funcionalidades 
    private static final String JDBC_URL ="jbc:msql://localhost:3306/test?useSSL=false"+
                    "&useTimezone=true&serverTimezone=UTC"+
                    "&allowPublickeyRetrival=true";
    private static final String JDBC_USER ="root";
    private static final String JDBC_PASWORD ="1234";
    
    public static Connection getConecciton() throws SQLException {
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASWORD);
    }
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
                
    }
    public static void close(Statement stm) throws SQLException {
        stm.close();
              
    }
    public static void close(PreparedStatement stm) throws SQLException {
        stm.close();
              
    }
    public static void close(Connection conn) throws SQLException {
        conn.close();
              
    }
}
