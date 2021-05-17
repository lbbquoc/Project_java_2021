package bill;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connectMySql.ConnectDB;
import employee.Employee;
import order.Order;
import product.*;


public class Bill {

    private int bill_ID;
    private String bill_type;
    private String bill_number;
    private int bill_customer_id;
    private int bill_employee_id;

    private String bill_description;
    private Date bill_date;

    private ArrayList<Order> listOrder = new ArrayList<Order>();
    private int totalBill;


    public Bill()
    {

    }

    public Bill(int idBill, int idNhanVien, int idKhachHang, Date dateOfBill, int tongTien) {
        this.bill_ID = idBill;
        this.bill_employee_id = idNhanVien;
        this.bill_customer_id = idKhachHang;
        this.bill_date = dateOfBill;
        this.totalBill = tongTien;
    }


    // getter
    public int getBill_ID() {
        return bill_ID;
    }

    public float getTotalBill() {
        for (int i = 0; i < listOrder.size(); i++) {
            this.totalBill+= listOrder.get(i).getTongCong();
        }
        return totalBill;
    }

    public ArrayList<Order> getListProduct() {
        return listOrder;
    }

    public Date getBill_date() {
        return bill_date;
    }

    public String getBill_description() {
        return bill_description;
    }

    public int getBill_customer_id() {
        return bill_customer_id;
    }

    public String getBill_number() {
        return bill_number;
    }

    public String getBill_type() {
        return bill_type;
    }

    public int getBill_employee_id() {
        return bill_employee_id;
    }

    // setter


    public Bill setBill_employee_id(int bill_employee_id) {
        this.bill_employee_id = bill_employee_id;
        return this;
    }

    public Bill setTotalBill(int totalBill) {
        this.totalBill = totalBill;
        return this;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public Bill setBill_date(Date bill_date) {
        this.bill_date = bill_date;
        return this;
    }

    public Bill setBill_description(String bill_description) {
        this.bill_description = bill_description;
        return this;
    }

    public Bill setBill_customer_id(int bill_customer_id) {
        this.bill_customer_id = bill_customer_id;
        return this;
    }

    public Bill setBill_number(String bill_number) {
        this.bill_number = bill_number;
        return this;
    }

    public Bill setBill_type(String bill_type) {
        this.bill_type = bill_type;
        return this;
    }

    public Bill setBill_ID(int bill_ID) {
        this.bill_ID = bill_ID;
        return this;
    }

    // function :
    public Object[][] getBillBySDT(String sdt) throws SQLException {
        ArrayList<Bill> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect1 = "select idKhachHang from quanlycuahang.khachhang where SDT='"+sdt+"'";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect1);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        int maKH = 0;
        while (temp_list_emp.next()) {
            maKH= temp_list_emp.getInt("idKhachHang");
        }
        System.out.println(maKH);

        String qSelect = "select * from quanlycuahang.bill where idKhachHang="+maKH;
        PreparedStatement preparedStmt1 = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp1 = preparedStmt1.executeQuery();
        while (temp_list_emp1.next()) {
            Bill people = new Bill(temp_list_emp1.getInt("idBill"),
                    temp_list_emp1.getInt("idNhanVien"), temp_list_emp1.getInt("idKhachHang"), temp_list_emp1.getDate("dateOfBill"),temp_list_emp1.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getBill_ID(),staffs.get(i).getBill_employee_id(),staffs.get(i).getBill_customer_id(),staffs.get(i).getBill_date(),staffs.get(i).getTotalBill()};
        }
        return objArray;
    }
    public Object[][] getBillByOptions(int maKH) throws SQLException {
        ArrayList<Bill> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.bill where idKhachHang="+maKH;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Bill people = new Bill(temp_list_emp.getInt("idBill"),
                    temp_list_emp.getInt("idNhanVien"), temp_list_emp.getInt("idKhachHang"), temp_list_emp.getDate("dateOfBill"),temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getBill_ID(),staffs.get(i).getBill_employee_id(),staffs.get(i).getBill_customer_id(),staffs.get(i).getBill_date(),staffs.get(i).getTotalBill()};
        }
        return objArray;
    }
    public Object[][] getBillByDate(String date) throws SQLException {
        ArrayList<Bill> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        Date tmp = Date.valueOf(date);
        String qSelect = "select * from quanlycuahang.bill where dateOfBill="+tmp;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Bill people = new Bill(temp_list_emp.getInt("idBill"),
                    temp_list_emp.getInt("idNhanVien"), temp_list_emp.getInt("idKhachHang"), temp_list_emp.getDate("dateOfBill"),temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getBill_ID(),staffs.get(i).getBill_employee_id(),staffs.get(i).getBill_customer_id(),staffs.get(i).getBill_date(),staffs.get(i).getTotalBill()};
        }
        return objArray;
    }
    public Object[][] getBillBySDTDATE(String date,String sdt) throws SQLException {
        ArrayList<Bill> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        //Date tmp = Date.valueOf(date);

        String qSelect1 = "select idKhachHang from quanlycuahang.khachhang where SDT='"+sdt+"'";
        PreparedStatement preparedStmt1 = conn.prepareStatement(qSelect1);
        ResultSet temp_list_emp1 = preparedStmt1.executeQuery();
        int maKH = 0;
        while (temp_list_emp1.next()) {
            maKH= temp_list_emp1.getInt("idKhachHang");
        }






        String qSelect = "select * from quanlycuahang.bill where dateOfBill='"+date+"' and idKhachHang="+maKH;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Bill people = new Bill(temp_list_emp.getInt("idBill"),
                    temp_list_emp.getInt("idNhanVien"), temp_list_emp.getInt("idKhachHang"), temp_list_emp.getDate("dateOfBill"),temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getBill_ID(),staffs.get(i).getBill_employee_id(),staffs.get(i).getBill_customer_id(),staffs.get(i).getBill_date(),staffs.get(i).getTotalBill()};
        }
        return objArray;
    }
    public Object[][] getList() throws SQLException {
        ArrayList<Bill> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.bill";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Bill people = new Bill(temp_list_emp.getInt("idBill"),
                    temp_list_emp.getInt("idNhanVien"), temp_list_emp.getInt("idKhachHang"), temp_list_emp.getDate("dateOfBill"),temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getBill_ID(),staffs.get(i).getBill_employee_id(),staffs.get(i).getBill_customer_id(),staffs.get(i).getBill_date(),staffs.get(i).getTotalBill()};
        }
        return objArray;
    }
    public void deleteBillByID(int id) throws SQLException {
        String query ="delete from quanlycuahang.bill where idBill = '"+id+"'";
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
        conn.close();
    }
    public  void addOrder(Order od)
    {
        listOrder.add(od);
    }
    @Override
    public String toString() {
        return "Bill{" +
                "bill_ID=" + bill_ID +
                ", bill_type='" + bill_type + '\'' +
                ", bill_number='" + bill_number + '\'' +
                ", bill_customer_id=" + bill_customer_id +
                ", bill_description='" + bill_description + '\'' +
                ", bill_date=" + bill_date +
                ", listOrder=" + listOrder +
                ", totalBill=" + getTotalBill() +
                '}';
    }
    public void inCTBill(int id_ex) throws SQLException {
        Connection conn = ConnectDB.connectDB();
        String qSelect = "{ call xemChiTietBill(?) }";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        preparedStmt.setInt(1,id_ex);
        // execute the query, and get a java resultset ( LAY KET QUA)
        ResultSet rs = preparedStmt.executeQuery();
        //            // iterate through the java resultset
        while (rs.next()) {
            System.out.println("-------------------------------");
            int id = rs.getInt("idBill");
            int id_nv = rs.getInt("idNhanVien");
            int id_kh = rs.getInt("idKhachHang");
            Date date = rs.getDate("dateOfBill");
            int tongtien = rs.getInt("tongTien");



            // print the results
            System.out.println("Id bill: " + id);
            System.out.println("Id nhan vien : " + id_nv);
            System.out.println("Id khach hang : " + id_kh);
            System.out.println("Ngay tao bill : " + date);
            System.out.println("Tong tien: " + tongtien);
        }
    }
    public int tongDoanhthu(int month) throws SQLException {
        String query="SELECT SUM(tongTien) FROM quanlycuahang.bill where month(dateOfBill)="+month;
        Connection conn = ConnectDB.connectDB();
       // String qSelect1 = "select idKhachHang from quanlycuahang.khachhang where SDT='"+sdt+"'";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        int doanhthu = 0;
        while (temp_list_emp.next()) {
            doanhthu= temp_list_emp.getInt("SUM(tongTien)");
        }
        return doanhthu;
    }
    public int tongDoanhthungay(int ngay) throws SQLException {
        String query="SELECT SUM(tongTien) FROM quanlycuahang.bill where day(dateOfBill)="+ngay;
        Connection conn = ConnectDB.connectDB();
        // String qSelect1 = "select idKhachHang from quanlycuahang.khachhang where SDT='"+sdt+"'";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        int doanhthu = 0;
        while (temp_list_emp.next()) {
            doanhthu= temp_list_emp.getInt("SUM(tongTien)");
        }
        return doanhthu;
    }
}
