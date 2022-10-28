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

    //INSTANCIO UNA PERSONA DAO
    PersonaDao personaDao=new PersonaDao();
    Persona p2 = new Persona("Emily","Ayala","ingrid@gmail.com","610375477");
    Persona p3 = new Persona(1,"Emily","Ayala","Emily@gmail.com","610375477");
    //instanciar un objeto 
    //personaDao.insertar(p2);
    //ACTUALIZAR
    //personaDao.actualizar(p3);
    personaDao.delete(p3);
    
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
