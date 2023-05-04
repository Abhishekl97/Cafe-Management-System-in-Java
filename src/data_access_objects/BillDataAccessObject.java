/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;

import basic_models.Bill;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class BillDataAccessObject {
    // Get Bill ID
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
    // Save the bill details in the database
    public static void saveValue(Bill bill){
        String query = "INSERT INTO billdetailstable VALUES('"+bill.getId()+"', '"+bill.getName()+"', '"+bill.getMobile_number()+"', '"+bill.getEmail()+"', '"+bill.getDate()+"', '"+bill.getTotal()+"', '"+bill.getCreatedBy()+"')";
        DatabaseOperations.setDataOrDeleteData(query,"Bill Details Added!");
    }
    
    // Get record by Ascending order
    public static ArrayList<Bill> getAllRecordsByIncrement(String date){
        ArrayList<Bill> arrLst = new ArrayList<>();
        try{
            ResultSet r = DatabaseOperations.getData("SELECT * FROM billdetailstable WHERE date LIKE '%"+date+"%'");
            while(r.next()){
                Bill bill = new Bill();
                bill.setId(r.getInt("id"));
                bill.setName(r.getString("name"));
                bill.setMobile_number(r.getString("mobile_number"));
                bill.setEmail(r.getString("email"));
                bill.setDate(r.getString("date"));
                bill.setTotal(r.getString("total"));
                bill.setCreatedBy(r.getString("createdBy"));
                arrLst.add(bill);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrLst;
    }
    // Get record by Descending order
    public static ArrayList<Bill> getAllRecordsByDecrement(String date){
        ArrayList<Bill> arrLst = new ArrayList<>();
        try{
            ResultSet r = DatabaseOperations.getData("SELECT * FROM billdetailstable WHERE date LIKE '%"+date+"%' ORDER BY id DESC");
            while(r.next()){
                Bill bill = new Bill();
                bill.setId(r.getInt("id"));
                bill.setName(r.getString("name"));
                bill.setMobile_number(r.getString("mobile_number"));
                bill.setEmail(r.getString("email"));
                bill.setDate(r.getString("date"));
                bill.setTotal(r.getString("total"));
                bill.setCreatedBy(r.getString("createdBy"));
                arrLst.add(bill);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrLst;
    }
}
