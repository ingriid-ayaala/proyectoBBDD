/*
 programa de testeo conexión base de datos msql
la capa a de negocio lo que hace es implementar(instanciar) una interfaz
y no puede ver
de esta interfaz la capa de negocio busca el emtodo que va utlizar 
 */
package com.mycompany.intro.jdbc;


import dominio.Persona;
import dominio.PersonaDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ingri
 * 
 */
public class TestMsql {
    public static void main(String[] args) {
//        //defino la url de conexcion  a nuestra base de datos y sus paramtros
//            String url = "jbc:msql://localhost:3306/test?useSSL=false"+
//                    "&useTimezone=true&serverTimezone=UTC"+
//                    "&allowPublickeyRetrival=true";
//        try {
//            //ahora tratamos de establecer la conexion con nuestra bbdd
//            //esta sentencia puede crear una excepcion 
//            Connection conexion = DriverManager.getConnection(url,"root","1234");
//            //creo un Statement para poder ejecutar mis consultas msql
//            Statement instruccion = conexion.createStatement();
//            //defino mi consulta msql
//            String sql = "SELECT * FROM persona";
//            
//            ResultSet resultado = instruccion.executeQuery(sql);
//            
//            while (resultado.next()){
//                System.out.println("idPersona:"+resultado.getInt("idPersona"));
//                System.out.println("nombre:"+resultado.getString("nombre"));
//                System.out.println("apellido:"+resultado.getString("apellido"));
//                System.out.println("email:"+resultado.getString("email"));
//                System.out.println("telefono:"+resultado.getString("telefono"));
//            
//            }
//            resultado.close();
//            instruccion.close();
//            conexion.close();
//        } catch (SQLException ex) {
//            //Logger.getLogger(TestMsql.class.getName()).log(Level.SEVERE, null, ex);
//            ex.printStackTrace(System.out);
//        }
    PersonaDao personaDao=new PersonaDao();
        try {
            List<Persona>personas= personaDao.seleccionar();
            personas.forEach(persona ->{
                System.out.println("persona: "+persona);
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
   }
}
