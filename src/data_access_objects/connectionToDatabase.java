/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;

import java.sql.*;

/**
 *
 * @author Acer
 */
public class connectionToDatabase {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafems?useSSL=false","root","Omkaryeole@10");
            return c; 
        }
        catch(Exception e){
            return null;
        }
    }   
}
