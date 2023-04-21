/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Acer
 */
public class DatabaseOperations {
    // Set or delete data from the database
    public static void setDataOrDeleteData(String Query, String message){
        try{
            Connection c = connectionToDatabase.getConnection();
            Statement s = c.createStatement();
            s.executeUpdate(Query);
            if(!message.equals(""))
                JOptionPane.showMessageDialog(null, message);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
            }
    }
    // Return the data called by the query
    public static ResultSet getData(String query){
        try{
            Connection c = connectionToDatabase.getConnection();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(query);
            return r;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
