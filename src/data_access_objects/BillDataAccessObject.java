/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;

import basic_models.Bill;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class BillDataAccessObject {
    public static String getId(){
        int id = 1;
        try{
            ResultSet r = DatabaseOperations.getData("SELECT MAX(id) FROM billdetailstable");
            if(r.next()){
                id = r.getInt(1);
                id = id + 1;
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void saveValue(Bill bill){
        String query = "INSERT INTO billdetailstable VALUES('"+bill.getId()+"', '"+bill.getName()+"', '"+bill.getMobile_number()+"', '"+bill.getEmail()+"', '"+bill.getDate()+"', '"+bill.getTotal()+"', '"+bill.getCreatedBy()+"')";
        DatabaseOperations.setDataOrDeleteData(query,"Bill Details Added!");
    }
}
