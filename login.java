package login;
import connectMySql.ConnectDB;
import employee.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
    private int idlogin;
    private int dacquyen;
    private String login_name;
    private String password;

    public login(int idlogin, int dacquyen, String login_name, String password) {
        this.idlogin = idlogin;
        this.dacquyen = dacquyen;
        this.login_name = login_name;
        this.password = password;
    }

    public login() {
    }

    public int getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(int idlogin) {
        this.idlogin = idlogin;
    }

    public int getDacquyen() {
        return dacquyen;
    }

    public void setDacquyen(int dacquyen) {
        this.dacquyen = dacquyen;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean checkloginInfo(String user_name, String loginPassword) throws SQLException {
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.login where loginName='"+user_name+"'";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            this.idlogin = temp_list_emp.getInt("idlogin");
            this.dacquyen = temp_list_emp.getInt("dacQuyen");
            this.login_name = temp_list_emp.getString("loginName");
            this.password= temp_list_emp.getString("loginPassword");
        }
        if(this.login_name.equals(user_name)&&this.password.equals(loginPassword)){
            return true;
        }
        else{
            return false;
        }
    }
    public void addUser(String name, String pass, int type) throws SQLException {
        String query ="INSERT INTO quanlycuahang.login ( dacQuyen, loginName, loginPassword) VALUES ('"+type+"', '"+name+"', '"+pass+"')";
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
        conn.close();
    }
    public Employee getEmployeeInfo() throws SQLException {
        Employee emp1 = new Employee();//= new Employee();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.nhanvien where idNhanVien="+this.idlogin;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while(temp_list_emp.next()){
            emp1 = new Employee(temp_list_emp.getInt("idNhanVien"), temp_list_emp.getString("hoTen"), temp_list_emp.getString("SDT"), temp_list_emp.getString("diaChi"),temp_list_emp.getDate("ngaySinh"), temp_list_emp.getString("gioiTinh"), temp_list_emp.getInt("luong"), temp_list_emp.getInt("loaiNhanVien"),temp_list_emp.getInt("idCuaHang"));
        }
        return emp1;

    }
}
