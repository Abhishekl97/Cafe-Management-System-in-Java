/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;
import basic_models.SubCategories;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class SubCategoriesDataAccessObject {
    public static void saveValue(SubCategories subcategory){
        String query = "INSERT INTO subcategory(name, category, price) VALUES('"+subcategory.getName()+"','"+subcategory.getCategory()+"','"+subcategory.getPrice()+"')";
        DatabaseOperations.setDataOrDeleteData(query,"Sub-Category Added!");
    }
    
        public static ArrayList<SubCategories> getAllRecords(){
        ArrayList<SubCategories> arrLst = new ArrayList<>();
        try{
            ResultSet r = DatabaseOperations.getData("SELECT * FROM subcategory");
            while(r.next()){
                SubCategories subcategories = new SubCategories();
                subcategories.setId(r.getInt("id"));
                subcategories.setName(r.getString("name"));
                subcategories.setCategory((r.getString("category")));
                subcategories.setPrice(r.getString("price"));
                arrLst.add(subcategories);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrLst;
    }
        
    public static void update(SubCategories subCategories) {
        String query = "update subcategory set name = '"+subCategories.getName()+"', category ='"+subCategories.getCategory()+"', price = '"+subCategories.getPrice()+"' WHERE id='"+subCategories.getId()+"'";
        DatabaseOperations.setDataOrDeleteData(query,"Sub-Category Updated");
    }
    
    public static void delete(String id){
        String query = "DELETE FROM subcategory WHERE id = '"+id+"'";
        DatabaseOperations.setDataOrDeleteData(query,"Sub-Category Deleted!");
    }
}
