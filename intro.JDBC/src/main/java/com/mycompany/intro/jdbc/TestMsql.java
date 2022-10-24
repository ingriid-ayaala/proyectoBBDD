/*
 programa de testeo conexión base de datos msql
 */
package com.mycompany.intro.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ingri
 */
public class TestMsql {
    public static void main(String[] args) {
        //defino la url de conexcion  a nuestra base de datos y sus paramtros
            String url = "jbc:msql://localhost:3306/test?useSSL=false"+
                    "&useTimezone=true&serverTimezone=UTC"+
                    "&allowPublickeyRetrival=true";
        try {
            //ahora tratamos de establecer la conexion con nuestra bbdd
            Connection conexion = DriverManager.getConnection(url,"root","1234");
            Statement instruccion = conexion.createStatement();
            String resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()){
                System.out.println("idPersona:"+resultado.getInt("idPersona"));
            
            }
        } catch (SQLException ex) {
            //Logger.getLogger(TestMsql.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.out);
        }
    }
}
