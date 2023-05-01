/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_objects;
import basic_models.SubCategory;
/**
 *
 * @author Acer
 */
public class SubCategoriesDataAccessObject {
    public static void saveValue(SubCategory subcategory){
        String query = "INSERT INTO subcategory(name, category, price) VALUES('"+subcategory.getName()+"','"+subcategory.getCategory()+"','"+subcategory.getPrice()+"')";
        DatabaseOperations.setDataOrDeleteData(query,"Sub-Category Added!");
    }
}
