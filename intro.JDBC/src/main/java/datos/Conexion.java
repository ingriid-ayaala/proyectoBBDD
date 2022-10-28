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
    //TODA ESTA CONEXION DESAPARECERA YA QUE HAY OTROS SOFTWARE QUE SE ENCARGAN DE LAS CONEXIONES CONCAT 
    
    //tres constantes url,usuario y contraseña, para no mezclar funcionalidades 
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/test?useSSL=false"+
                    "&useTimezone=true&serverTimezone=UTC"+
                    "&allowPublicKeyRetrival=true";
    private static final String JDBC_USER ="root";
    private static final String JDBC_PASSWORD ="1234";
    //metodo para establecer la conexion 
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    //conjunto de metodos de cierre 
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
