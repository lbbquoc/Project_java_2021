package employee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import connectMySql.ConnectDB;
import customer.Customer;
import employee.Employee;
import employee.storeStaff;
import order.Order;
import product.Product;
import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;

import java.util.Scanner;

public class Employee {
    private int eID;
    private String eName;
    private String eSex;
    private int eSalary;
    private int eType; // 1. quan ly 2. nhan vien thuong 
    private String eAddress;
    private String ePhone;
    private Date eDayOfBirth;
    
    private int idCuaHang;
    private String positionInCompany;

    public Employee() {
    }

    Employee(int id, String name, int loaiNV, int idCuaHang)
    {
        this.eID  =id;
        this.eName = name;
        this.eType = loaiNV;
        this.idCuaHang = idCuaHang;
    }
    public Employee(int id, String name, String sdt, String diaChi, Date ngaysinh, String gtinh, int luong, int loainv, int idch)
    {
        this.eID  =id;
        this.eName = name;
        this.ePhone = sdt;
        this.eAddress = diaChi;
        this.eDayOfBirth = ngaysinh;
        this.eSex = gtinh;
        this.eSalary = luong;
        this.eType = loainv;
        this.idCuaHang = idch;
    }
    public int getIdCuaHang() {
        return idCuaHang;
    }

    public Employee setIdCuaHang(int idCuaHang) {
        this.idCuaHang = idCuaHang;
        return this;
    }

    public void setPosInComPany(String a) {
        this.positionInCompany = a;
    }

    public String getPosInCompany() {
        return this.positionInCompany;
    }

    public void setIDCompany(int id )
    {
        this.idCuaHang = id;
    }

    public int getIDCompany()
    {
        return this.idCuaHang;
    }
    public void setDateOFBirth(Date dob) {
        this.eDayOfBirth = dob;
    }

    public Date getDateOFBirth()
    {   
       return this.eDayOfBirth;
    }

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public int geteSalary() {
        return eSalary;
    }

    public void seteSalary(int eSalary) {
        this.eSalary = eSalary;
    }

    public int geteType() {
        return eType;
    }

    public void seteType(int eType) {
        this.eType = eType;
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public void addEmployee() {

    }

    public void editEmployee() {

    }

    public void deleteEmployee() {

    }

    public void searchEmployee() {

    }

    int calSalary(){
        return 0;
    }

    public void registryMembership()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten KH: ");
        String nameKH = sc.nextLine();

        System.out.println("Nhap so dien thoai KH: ");
        String phone = sc.nextLine();

        System.out.println("Nhap dia chi KH: ");
        String diaChi = sc.nextLine();

        Statement stmt = null;
        Connection conn = null;
        try {
            System.out.println("REGISTRY MEMBERSHIP database...");
            conn = ConnectDB.connectDB();
            stmt = conn.createStatement();

            // --------------- LẤY ID CUỐI TRONG BẢNG orderTable ------------- //
            String qSelect = "select * from khachhang ORDER BY idKhachHang DESC LIMIT 1";
            PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
            ResultSet rs_LastestID_KhachHang = preparedStmt.executeQuery();
            int idKH = 0;
            while (rs_LastestID_KhachHang.next()) {
                idKH = rs_LastestID_KhachHang.getInt("idKhachHang");
            }
            idKH += 1;

            Customer customer = new Customer(idKH,nameKH,phone,diaChi);
            //----------------------------------------- //

            String query = "{call insertKH (?,?,?,?,?)}";

            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, customer.getCustomer_id());
            preparedStmt.setString(2,customer.getCustomer_address());
            preparedStmt.setString(3,customer.getCustomer_phone());
            preparedStmt.setString(4,customer.getCustomer_name());
            preparedStmt.setInt(5, this.idCuaHang);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            System.out.println("REGISTRY successfully...");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "Employee{" +
                "eID=" + eID +
                ", eName='" + eName + '\'' +
                ", eSex='" + eSex + '\'' +
                ", eSalary=" + eSalary +
                ", eType=" + eType +
                ", eAddress='" + eAddress + '\'' +
                ", ePhone='" + ePhone + '\'' +
                ", eDayOfBirth=" + eDayOfBirth +
                ", idCuaHang=" + idCuaHang +
                '}';
    }

    public Date geteDayOfBirth() {
        return eDayOfBirth;
    }

    public  Object[][]  getList() throws SQLException {
        ArrayList<Employee> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.nhanvien";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Employee people = new Employee(temp_list_emp.getInt("idNhanVien"),
                    temp_list_emp.getString("hoTen"), temp_list_emp.getString("SDT"), temp_list_emp.getString("diaChi"),temp_list_emp.getDate("ngaySinh"), temp_list_emp.getString("gioiTinh"), temp_list_emp.getInt("luong"), temp_list_emp.getInt("loaiNhanVien"),temp_list_emp.getInt("idCuaHang"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).geteID(),staffs.get(i).geteName(),staffs.get(i).getePhone(),staffs.get(i).geteAddress(),staffs.get(i).geteDayOfBirth(), staffs.get(i).geteSex(), staffs.get(i).geteSalary(), staffs.get(i).geteType(),staffs.get(i).getIdCuaHang()};
        }
        return objArray;
    }
    public  Object[][]  getEmployeeByOptions(int id, String name, int luong) throws SQLException {
        ArrayList<Employee> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.nhanvien where idNhanVien="+id+" and hoTen='"+name+"'and luong="+luong;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Employee people = new Employee(temp_list_emp.getInt("idNhanVien"),
                    temp_list_emp.getString("hoTen"), temp_list_emp.getString("SDT"), temp_list_emp.getString("diaChi"),temp_list_emp.getDate("ngaySinh"), temp_list_emp.getString("gioiTinh"), temp_list_emp.getInt("luong"), temp_list_emp.getInt("loaiNhanVien"),temp_list_emp.getInt("idCuaHang"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).geteID(),staffs.get(i).geteName(),staffs.get(i).getePhone(),staffs.get(i).geteAddress(),staffs.get(i).geteDayOfBirth(), staffs.get(i).geteSex(), staffs.get(i).geteSalary(), staffs.get(i).geteType(),staffs.get(i).getIdCuaHang()};
        }
        return objArray;
    }
    public  Object[][]  getEmployeeById(int id) throws SQLException {
        ArrayList<Employee> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.nhanvien where idNhanVien="+id;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Employee people = new Employee(temp_list_emp.getInt("idNhanVien"),
                    temp_list_emp.getString("hoTen"), temp_list_emp.getString("SDT"), temp_list_emp.getString("diaChi"),temp_list_emp.getDate("ngaySinh"), temp_list_emp.getString("gioiTinh"), temp_list_emp.getInt("luong"), temp_list_emp.getInt("loaiNhanVien"),temp_list_emp.getInt("idCuaHang"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).geteID(),staffs.get(i).geteName(),staffs.get(i).getePhone(),staffs.get(i).geteAddress(),staffs.get(i).geteDayOfBirth(), staffs.get(i).geteSex(), staffs.get(i).geteSalary(), staffs.get(i).geteType(),staffs.get(i).getIdCuaHang()};
        }
        return objArray;
    }
    public void deleteEmployeeByID(int id) throws SQLException {
        String query ="delete from quanlycuahang.nhanvien where idNhanVien = '"+id+"'";
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
        conn.close();
    }
    public void updateEmployeeByOptions(int id, String name, String sdt , String diachi,Date ngaysinh, String gioitinh, int luong) throws SQLException {
        Connection conn = ConnectDB.connectDB();


            String query1 ="update  quanlycuahang.nhanvien set hoTen='"+name+"', SDT='"+sdt+", ngaySinh='"+ngaysinh+",gioiTinh='"+gioitinh+",luong='"+luong+"' where idNhanVien = "+id;
            PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
            preparedStmt1.execute();


        conn.close();
    }
}
