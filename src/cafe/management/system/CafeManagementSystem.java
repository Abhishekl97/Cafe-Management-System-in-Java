/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafe.management.system;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
/**
 *
 * @author Acer
 */
interface Publisher{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifySignup(Observer o,String name) throws IOException;
    public void notifyLogin(Observer o,String email, int i) throws IOException;
    public void notifySignout(Observer o,String email, int i) throws IOException;
    public void notifyPasswordReset(Observer o,String email, int i) throws IOException;
    public void notifyPasswordChange(Observer o,String email, int i) throws IOException;
    public void notifyOrderPlaced(Observer o,String email) throws IOException;
}
interface Observer{
    public void updateSignup(Observer o,String name) throws IOException;
    public void updateLogin(Observer o, String email, int i) throws IOException;
    public void updateSignout(Observer o, String email, int i) throws IOException;
    public void updatePasswordReset(Observer o,String email, int i) throws IOException;
    public void updatePasswordChange(Observer o,String email, int i) throws IOException;
    public void updateOrderPlaced(Observer o,String email) throws IOException;
}
class Subject implements Publisher{
    static Observer o;
    static ArrayList<Observer> observers;
    public Subject(){
        observers = new ArrayList<Observer>();
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    public void signupOutcome(String name) throws IOException {
        o= observers.get(0);
        notifySignup(o,name);         
    }
    public void notifySignup(Observer o, String name) throws IOException {
        o.updateSignup(o,name);         
    }
    public void loginOutcome(String email, int i) throws IOException {
        o = observers.get(0);
        notifyLogin(o,email,i);         
    }
    public void notifyLogin(Observer o, String email, int i) throws IOException {
        o.updateLogin(o,email,i);         
    }
    public void signoutOutcome(String email, int i) throws IOException {
        o = observers.get(0);
        notifySignout(o,email,i);         
    }
    public void notifySignout(Observer o, String email, int i) throws IOException {
        o.updateSignout(o,email,i);         
    }
    public void forgotPasswordOutcome(String email, int i) throws IOException {
        o = observers.get(0);
        notifyPasswordReset(o,email,i);         
    }
    public void notifyPasswordReset(Observer o, String email, int i) throws IOException {
        o.updatePasswordReset(o,email,i);         
    }
    public void changePasswordOutcome(String email, int i) throws IOException {
        o = observers.get(0);
        notifyPasswordChange(o,email,i);         
    }
    public void notifyPasswordChange(Observer o, String email, int i) throws IOException {
        o.updatePasswordChange(o,email,i);         
    }
    public void orderPlacedOutcome(String email) throws IOException {
        o = observers.get(0);
        notifyOrderPlaced(o,email);         
    }
    public void notifyOrderPlaced(Observer o, String email) throws IOException {
        o.updateOrderPlaced(o,email);         
    }
}

class Tracker implements Observer{
    Publisher subject;
    public Tracker(Publisher subject) throws IOException{
        this.subject = subject;
        subject.registerObserver(this);
    }
    public void updateSignup(Observer o,String name) throws IOException{
        System.out.println("New account created for "+name+".");
        CafeManagementSystem.writer1.write("New account created for "+name+".\n");
    }
    public void updateLogin(Observer o,String email,int i) throws IOException{
        if(i==0){
            System.out.println("Manager logged in.");
            CafeManagementSystem.writer1.write("Manager logged in.\n");
            subject.removeObserver(o);
        }
        else if (i==1){
            System.out.println("User "+email+" logged in.");
            CafeManagementSystem.writer1.write("User "+email+" logged in.\n");
            subject.removeObserver(o);
        }
    }
    public void updateSignout(Observer o,String email,int i) throws IOException{
        if(i==0){
            System.out.println("Manager logged out.");
            CafeManagementSystem.writer1.write("Manager logged out.\n");
            subject.removeObserver(o);
        }
        else if (i==1){
            System.out.println("User "+email+" logged out.");
            CafeManagementSystem.writer1.write("User "+email+" logged out.\n");
            subject.removeObserver(o);
        }
    }
    public void updatePasswordReset(Observer o,String email,int i) throws IOException{
        if(i==0){
            System.out.println("Password reset for Manager.");
            CafeManagementSystem.writer1.write("Password reset for Manager.\n");
            subject.removeObserver(o);
        }
        else if (i==1){
            System.out.println("Password reset for User "+email+".");
            CafeManagementSystem.writer1.write("Password reset for User "+email+".\n");
            subject.removeObserver(o);
        }
    }
    public void updatePasswordChange(Observer o,String email,int i) throws IOException{
        if(i==0){
            System.out.println("Password changed for Manager.");
            CafeManagementSystem.writer1.write("Password changed for Manager.\n");
            subject.removeObserver(o);
        }
        else if (i==1){
            System.out.println("Password changed for User "+email+".");
            CafeManagementSystem.writer1.write("Password changed for User "+email+".\n");
            subject.removeObserver(o);
        }
    }
    public void updateOrderPlaced(Observer o,String email) throws IOException{
        System.out.println("User "+email+" placed order.");
        CafeManagementSystem.writer1.write("User "+email+" placed order.\n");
        subject.removeObserver(o);
    }
}
public class CafeManagementSystem {
    static FileWriter writer1;
    /**
     * @param args the command line arguments
     */
    public static void trackerOutput() throws IOException {
    File file = new File("Trackers.txt");
    FileWriter writer = new FileWriter(file);
    writer1 = writer;
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        trackerOutput();
        System.out.println(CafeManagementSystem.writer1);
    }
    
}
