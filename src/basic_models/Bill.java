 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basic_models;

/**
 *
 * @author Acer
 */
public class Bill {
    private int id;
    private String name;
    private String mobile_number;
    private String email;
    private String date;
    private String total;
    private String createdBy;

    //Setters and Getters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getTotal() {
        return total;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
