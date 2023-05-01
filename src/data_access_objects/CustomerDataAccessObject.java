 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;

import basic_models.Customer;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Acer
 */
public class CustomerDataAccessObject{
    // Insert Customer details
    public static void saveValue(Customer customer){
        String query = "INSERT into customer(id, name, email ,mobile_number, password, security_question, answer) VALUES('"+customer.getId()+"','"+customer.getName()+"',"
                + "'"+customer.getEmail()+"','"+customer.getMobilenumber()+"','"+customer.getPassword()+"','"+customer.getSecurityQuestion()+"','"+customer.getAnswer()+"')";
        
        DatabaseOperations.setDataOrDeleteData(query, "Registered Sucessfully!");
    }
    // Authenticate Customer data
    public static Customer login(String email, String password){
        Customer customer = null;
        try{
            ResultSet r = DatabaseOperations.getData("SELECT * FROM customer WHERE email ='"+email+"' AND password='"+password+"'");
            if (r.next()) {
                customer = new Customer();
                customer.setId(r.getInt("id"));
                customer.setName(r.getString("name"));
                customer.setEmail(r.getString("email"));
                customer.setMobilenumber(r.getString("mobile_number"));
                customer.setPassword(r.getString("password"));
                customer.setSecurityQuestion(r.getString("security_question"));
                customer.setAnswer(r.getString("answer"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return customer;
    }
    
    // Get Security Question and Answer
    public static Customer getSecurityQuestion(String email){
        Customer customer = null;
        try{
            ResultSet r = DatabaseOperations.getData("select * from customer where email = '"+email+"'");
            while(r.next()){
                customer = new Customer();
                customer.setSecurityQuestion(r.getString("security_question"));
                customer.setAnswer(r.getString("answer"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return customer;
    }
    //Reset Customer Password
    public static void reset_password(String email, String new_password){
        String query = "update Customer set password = '"+new_password+"' where email = '"+email+"'";
        DatabaseOperations.setDataOrDeleteData(query, "Password Changed susccessfully");
    }
    //Change Customer Password
    public static void change_password(String email, String old_password, String new_password){
        try{
            ResultSet r = DatabaseOperations.getData("select * from Customer where email = '"+email+"' and password = '"+old_password+"'");
            if(r.next()){
                reset_password(email,new_password);
            }
            else{
                JOptionPane.showMessageDialog(null, "Old Password is Incorrect");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
