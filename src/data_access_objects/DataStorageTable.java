/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;

import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class DataStorageTable {
    public static void main(String[] args){
        try{
           String customerTable = "CREATE table customer(id int AUTO_INCREMENT primary key, name VARCHAR(200), email VARCHAR(200),"
                                + " mobile_number VARCHAR(10), password VARCHAR(200), security_question VARCHAR(200), answer VARCHAR(200), UNIQUE(email));";
           String managerDetails = "insert into customer(name, email, mobile_number, password, security_question, answer) VALUES ('Manager','manager@gmail.com','1234567890','admin','What city do you live in?','Boulder');";
           DatabaseOperations.setDataOrDeleteData(customerTable, "Customer Table Created!");
           DatabaseOperations.setDataOrDeleteData(managerDetails, "Manager Details Added Successfully!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
