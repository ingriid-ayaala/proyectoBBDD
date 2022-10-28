/*
 el conjunto de operaciones que yo voy a poder realizar 
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ingri
 */
public class PersonaDao {
    //POR CADA OBJETO CON EL QUE QUIERO TRABAJAR TENGO QUE DEFINIR EN DATOS 
    private static final String SQL_SELECT ="SELECT * FROM persona";
    private static final String SQL_INSERT ="INSERT INTO persona(nombre,apellido,email,telefono) values(?,?,?,?)";
    //LA CAPA DE NEGOCIO INSTANCIA UN NUEVO OBJETO 
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?,apellido = ?,email = ?,telefono = ? WHERE idPersona= ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";
    
    //METODO QUE NOS LISTA  TODAS LAS PERSONAS DE NUESTRO SISTEMA 
    public List<Persona>  seleccionar() throws SQLException{
    //iniciliazo mis varaiables
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        conn = getConnection();//ES UN METODO QUE SE APOYA EN CONEXION 
        stmt = conn.prepareStatement(SQL_SELECT);//PARA EJECUTAR ESA SENTENCIA 
        rs = stmt.executeQuery();//Y A TRAVES DE ESO TE DVEUEKVE UN LISTADO DE REGISTROS 
        //LEE OBJETOS Y LA PASA A LA CAPA DE ARRIBA 
        //rs, la primera columna 
        while   (rs.next()){
            //POR CADA REGISTRO 
            //SE ALMACENA EN UN CONJUNTO DE VARIABLES 
            int idPersona= rs.getInt("idPersona");
            String nombre=rs.getString("nombre");
            String apellido= rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            
            //INSTANCIO UN NUEVO OBJETO
            personas.add(new Persona(idPersona,nombre, apellido,email,telefono));
     
    }
    //SE CIERRA EN SENTIDO INVERSO 
    close(rs);
    close(stmt);
    close(conn);
    
    return personas;

    }

    //METODO QUE INSERTA UN PERSONA EN MI TABLA O SISTEMA 
    
    public int insertar (Persona persona){
        Connection conn=null;
        PreparedStatement stmt = null;
        int registros =0;
        
        try {
            //1.establecer la conexion
            conn = getConnection();
            //2.PARA EJCUTARLA CONTRA LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_INSERT);
            //DAR VALOR A LOS INTERROGANTES DE LA CONSULTA, APOYANDOME EN 
            
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            //3.ejecuto la query
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       
        return registros;
    }
    
    //metodo actualizar
    public int actualizar(Persona persona){
    Connection conn = null;
    PreparedStatement stmt = null;
    int registros=0;
        try {
            //1.establecer la conexion
            conn = getConnection();
            //2.PARA EJCUTARLA CONTRA LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_UPDATE);
            //DAR VALOR A LOS INTERROGANTES DE LA CONSULTA, APOYANDOME EN 
            
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            
            stmt.setInt(1,persona.getIdPersona());
            //3.ejecuto la query
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    //metodo eliminar
    public int delete (Persona persona){
    Connection conn = null;
    PreparedStatement stmt = null;
    int registros=0;
        try {
            //1.establecer la conexion
            conn = getConnection();
            //2.PARA EJCUTARLA CONTRA LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_DELETE);
            //DAR VALOR A LOS INTERROGANTES DE LA CONSULTA, APOYANDOME EN 
            /*
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            */
            stmt.setInt(1,persona.getIdPersona());
            //3.ejecuto la query
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}

    
