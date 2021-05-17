package user;
import java.sql.Date;
import java.util.ArrayList;
import employee.*;
public class user {
    private int userID;
    private String userName;
    private String userEmail;    
    private String userAddress;
    private Date userDoB;

    private ArrayList<Employee> listEmployee;

    public int getUserID() {
            return userID;
    }
    public void setUserID(int id) {
        this.userID = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name) {

        this.userName= name  ;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String email) {

        this.userEmail= email;
    }
    //////////////////////////
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String add) {

        this.userAddress = add;
    }
    
    ////////////
    public Date getUserDayOFBirth() {
        return userDoB;
    }
    public void setUserEmail(Date date) {

        this.userDoB= date;
    }
    //////////
    public ArrayList<Employee> getListEmployee()
    {
        return listEmployee;
    }

    public void setListEmployee(ArrayList<Employee> listEmployee)
    {
        this.listEmployee = listEmployee;
    }

    public void addUser() {
        
    }
    public void editUser() {

    }
    public void deleteUser() {

    }
    public void searchUser() {

    }
}
