/*
 el conjunto de operaciones que yo voy a poder realizar 
 */
package dominio;

import static datos.Conexion.close;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author ingri
 */
public class PersonaDao {
    
    private static final String SQL_SELECT ="SELECT * FROM persona";
    
    public List<Persona>  seleccionar() throws SQLException{
    //iniciliazo mis varaiables
    Connection conn=null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Persona persona = null;
    List<Persona> personas = new ArrayList<>();
    
    conn = getConnection();
    stmt = conn.prepareStatement(SQL_SELECT);
    rs = stmt.executeQuery();
    while   (rs.next()){
     int idPersona= rs.getInt("idPersona");
     String nombre=rs.getString("nombre");
     String apellido= rs.getString("apellido");
     String email = rs.getString("email");
     String telefono = rs.getString("telefono");
     
     persona.add(new Persona(idPersona,nombre, apellido,email,telefono));
     
    }
    
    close(rs);
    close(stmt);
    close(conn);
    
    return personas;

    }

    
}

    
