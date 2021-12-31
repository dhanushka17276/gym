/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.connections;


import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Dhanushka
 */
public class DBConnection {
    
    
    public static void main(String[] args) {
        connect();
    }
    
    public static Connection connect(){
          Connection conn =null;
        try {
                 
             Class.forName("com.mysql.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "");
           
           
            System.out.println("Database coonected");
        
        } catch (Exception  e) {
            System.out.println("Cannot connect the database! "+ e);
        }
  
  return conn;
    }
    
    
    
}
