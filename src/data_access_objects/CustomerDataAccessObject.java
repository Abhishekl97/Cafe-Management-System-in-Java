/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;

import basic_models.Customer;
/**
 *
 * @author Acer
 */
public class CustomerDataAccessObject {
    public static void saveValue(Customer customer){
        String query = "insert into user(name, email,mobile_number, password, confirm_password, security_question, answer) values('"+customer.getName()+"','"+customer.getEmail()+"''"+customer.getMobilenumber()+"','"+customer.getPassword()+"',"
                        + "'"+customer.getConfirmPassword()+"','"+customer.getSecurityQuestion()+"','"+customer.getAnswer()+"')";
        
        DatabaseOperations.setDataOrDeleteData(query, "Registered Sucessfully!");
    }
}
