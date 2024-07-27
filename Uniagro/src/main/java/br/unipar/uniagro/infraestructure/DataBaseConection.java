/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 00236544
 */
public class DataBaseConection {
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/app",
                "postgres",
                "postgres"
        );
            
    }
    
}
