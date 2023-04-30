/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;
import java.util.ArrayList;
import basic_models.Categories;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author abhis
 */
public class CategoriesDataAccessObject {
    public static void save(Categories category){
        String query = "insert into Category (name) values('"+category.getName()+"');";
        DatabaseOperations.setDataOrDeleteData(query, "Category Added Successfully!");
    }
    
    public static ArrayList<Categories> getAllRecords(){
        ArrayList<Categories> arrayList = new ArrayList();
        try{
            ResultSet r = DatabaseOperations.getData("Select * from category");
            while(r.next()){
                Categories category = new Categories();
                category.setId(r.getInt("id"));
                category.setName(r.getString("name"));
                arrayList.add(category);
            }               
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void delete(String id){
        String query = "delete from Category where id='"+id+"';";
        DatabaseOperations.setDataOrDeleteData(query, "Category Deleted Successfully!");
    }
            
}
