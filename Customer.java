package customer;


import bill.Bill;
import connectMySql.ConnectDB;
import employee.Employee;
import employee.storeStaff;
import order.Order;
import product.Product;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    private int customer_id;
    private String customer_name;
    private String customer_phone;
    private String customer_email;
    private String customer_username;
    private String customer_address;
    private String customer_password;
    private int idCuaHang;

    // constructor


    public Customer(int customer_id, String customer_name, String customer_phone) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
    }

    public Customer(int customer_id, String customer_name, String customer_phone, String customer_address) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_address = customer_address;
    }

    public Customer(int idKhachHang, String diaChi, String sdt, String hoTen, int idCuaHang) {
        this.customer_id = idKhachHang;
        this.customer_address = diaChi;
        this.customer_phone = sdt;
        this.customer_name = hoTen;
        this.idCuaHang = idCuaHang;
    }

    public Customer() {

    }

    // getter and setter
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public void addCustomer() {

    }

    public void editCustomer() {

    }


    public void searchCustomer() {

    }

    public void callOrder_p2(JTextArea textArea, JTextField textField32, JTextField textField33 ,int idnv,int id_kh) throws SQLException {

        Bill billForOrder = new Bill();
        Connection conn = ConnectDB.connectDB();
        // --------------- LẤY ID CUỐI TRONG BẢNG orderTable ------------- //
        String qSelect = "select * from bill ORDER BY idBill DESC LIMIT 1";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet rs_LastestID_Bill = preparedStmt.executeQuery();
        int idBill = 0;
        while (rs_LastestID_Bill.next()) {
            idBill = rs_LastestID_Bill.getInt("idBill");
        }
        billForOrder.setBill_ID(idBill + 1);
        textArea.append("Id cua Bill :" + billForOrder.getBill_ID()+"\n");


        textArea.append("------------------ORDER NOW ----------------"+"\n");
            int idCodeSP = Integer.parseInt(textField32.getText());;
            int slMua = Integer.parseInt(textField33.getText());
           qSelect = "SELECT * FROM sanpham WHERE idSanPham = ?";
            preparedStmt = conn.prepareCall(qSelect);
            preparedStmt.setInt(1, idCodeSP);
            ResultSet rs = preparedStmt.executeQuery();
            rs = preparedStmt.executeQuery(); // dòng 159 ( tạo 1 lần dùng mãi )

            // --------------- LẤY ID CUỐI TRONG BẢNG orderTable ------------- //
            qSelect = "select * from orderTable ORDER BY idOrder DESC LIMIT 1";
            preparedStmt = conn.prepareStatement(qSelect);
            ResultSet rs_LastestID_OrderTable = preparedStmt.executeQuery();
            int idOrder = 0;
            while (rs_LastestID_OrderTable.next()) {
                idOrder = rs_LastestID_OrderTable.getInt("idOrder");
            }
            idOrder += 1;
            Order od = new Order(idOrder);
        textArea.append("ma order: " + od.getIdOrder()+"\n");
            //System.out.println("ma order: " + od.getIdOrder());
            //----------------------------------------- //


            String qInsert = "";
            while (rs.next()) {
                textArea.append("--------San pham dang chon -----------\n");
               // System.out.println("--------San pham dang chon -----------");
                int idP = rs.getInt("idSanPham");
                String nameP = rs.getString("tenSanPham");
                int typeP = rs.getInt("loaiSP");
                String description = rs.getString("moTa");
                Date NSX = rs.getDate("ngaySanXuat");
                String HSD = rs.getString("hanSuDung");
                int gia = rs.getInt("gia");

                int soLuong = rs.getInt("soLuong");



                textArea.append("id San Pham: " + idP+"\n");
                textArea.append("ten san pham: " + nameP+"\n");
                textArea.append("GIA : " + gia+"\n");
                textArea.append("So luong : " + soLuong+"\n");
                textArea.append("-------------San pham dang chon ------------------\n");
                Product sp = new Product(idP, nameP, typeP, description, NSX, HSD, gia, soLuong);


                // đặt lại order
                od.setIdKhachHang(customer_id);
                od.setProduct(sp);
                od.setSoluong(slMua);
                Date dateOrder = new Date(System.currentTimeMillis());

                // THÊM ORDER VÀO BILL
                billForOrder.addOrder(od);

                // xem du liệu trong order:

//                    System.out.println("id order: " + od.getIdOrder());
//                    System.out.println("product id: " + od.getProduct().getProduct_id());
//                    System.out.println("date of order : " + dateOrder);
//                    System.out.println("bill id: " + billForOrder.getBill_ID());
//                    System.out.println("tong tien 1 order: " + od.getTongCong());

                // insert order
                qInsert = "{call insertOrder(?,?,?,?,?,?)}";

                PreparedStatement pstmt = conn.prepareStatement(qInsert);

                pstmt.setInt(1, od.getIdOrder());
                pstmt.setInt(2, sp.getProduct_id());
                pstmt.setInt(3, od.getSoluong());
                pstmt.setDate(4, dateOrder);
                pstmt.setInt(5, billForOrder.getBill_ID());
                pstmt.setInt(6, od.getTongCong());

                //EXECUTE ( không lấy kqua thì dùng executeUpdate() )
                pstmt.executeUpdate();

                String qUpdateSoLuongSP = "{call updateSoLuongSP(?,?)}";
                pstmt = conn.prepareStatement(qUpdateSoLuongSP);
                pstmt.setInt(1,od.getProduct().getProduct_id());
                pstmt.setInt(2, od.getSoluong());

                //EXECUTE ( không lấy kqua thì dùng executeUpdate() )
                pstmt.executeUpdate();

            }




        // PHẦN THÊM BILL VÀO DB

        //System.out.println("Nhap ID nhan vien : ");
        int idNV = idnv;
        //System.out.println("Nhap Ten nhan vien : ");
        String nameNV = "Quốc";


        Employee employee = new storeStaff(idNV, nameNV, 3, 1);
        billForOrder.setBill_customer_id(customer_id);
        billForOrder.setBill_employee_id(employee.geteID());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        billForOrder.setBill_date(date);

        String qInsert_Bill = "{call insertBill(?,?,?,?,?)}";
        PreparedStatement pstmt_bill = conn.prepareStatement(qInsert_Bill);
        pstmt_bill = conn.prepareCall(qInsert_Bill);
        pstmt_bill.setInt(1, billForOrder.getBill_ID());
        pstmt_bill.setInt(2, employee.geteID());
        pstmt_bill.setInt(3, id_kh);
        pstmt_bill.setDate(4, billForOrder.getBill_date());
        pstmt_bill.setInt(5, (int) billForOrder.getTotalBill());

        // EXECUTE
        pstmt_bill.executeUpdate();

        //System.out.println("Table kho insert successfully...");
        textArea.append("Table kho insert successfully..."+"\n");
    }
    public void callOrder(JTextArea textArea, JTextField textField32) throws ParseException {
        Statement stmt = null;
        Connection conn = null;


        try {
            //System.out.println("Creating table in Store database...");
            conn = ConnectDB.connectDB();
            stmt = conn.createStatement();

            // xem danh sach san pham
            //--------------------------------------
            String qSelect = "{ call selectSanPham() }";
            PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
            // execute the query, and get a java resultset ( LAY KET QUA)
            ResultSet rs = preparedStmt.executeQuery();
            //            // iterate through the java resultset
            while (rs.next()) {
                System.out.println("-------------------------------");
                int id = rs.getInt("idSanPham");
                String nameP = rs.getString("tenSanPham");
                String typeP = rs.getString("loaiSP");
                String description = rs.getString("moTa");
                Date NSX = rs.getDate("ngaySanXuat");
                String HSD = rs.getString("hanSuDung");
                int gia = rs.getInt("gia");
                int soLuong = rs.getInt("soLuong");



                textArea.append("id San Pham: " + id+"\n");
                textArea.append("ten san pham: "+nameP+"\n");
                textArea.append("loai san pham: "+typeP+"\n");
                textArea.append("mo ta : " + description+"\n");
                textArea.append("Ngay san Xuat: " + NSX+"\n");
                textArea.append("han su dung : " + HSD+"\n");
               textArea.append("GIA : " + gia+"\n");
               textArea.append("So luong : " + soLuong+"\n");





                textArea.append("--------------- ALL PRODUCT ----------------\n");
            }


          //   tao bill moi




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

    public int getIdCuaHang() {
        return idCuaHang;
    }
        public  Object[][] getCustomerByOptions(int sdt) throws SQLException {
        ArrayList<Customer> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.khachhang where SDT="+sdt;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Customer people = new Customer(temp_list_emp.getInt("idKhachHang"),
                    temp_list_emp.getString("diaChi"), temp_list_emp.getString("SDT"), temp_list_emp.getString("hoTen"),temp_list_emp.getInt("idCuaHang"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getCustomer_id(),staffs.get(i).getCustomer_address(),staffs.get(i).getCustomer_phone(),staffs.get(i).getCustomer_name(),staffs.get(i).getIdCuaHang()};
        }
        return objArray;

    }
    public  Object[][] getList() throws SQLException {
        ArrayList<Customer> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.khachhang";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Customer people = new Customer(temp_list_emp.getInt("idKhachHang"),
                    temp_list_emp.getString("diaChi"), temp_list_emp.getString("SDT"), temp_list_emp.getString("hoTen"),temp_list_emp.getInt("idCuaHang"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getCustomer_id(),staffs.get(i).getCustomer_address(),staffs.get(i).getCustomer_phone(),staffs.get(i).getCustomer_name(),staffs.get(i).getIdCuaHang()};
        }
        return objArray;
    }
    public  Object[][] getCustomerById(int id) throws SQLException {
        ArrayList<Customer> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.khachhang where idKhachHang = "+id;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Customer people = new Customer(temp_list_emp.getInt("idKhachHang"),
                    temp_list_emp.getString("diaChi"), temp_list_emp.getString("SDT"), temp_list_emp.getString("hoTen"),temp_list_emp.getInt("idCuaHang"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getCustomer_id(),staffs.get(i).getCustomer_address(),staffs.get(i).getCustomer_phone(),staffs.get(i).getCustomer_name(),staffs.get(i).getIdCuaHang()};
        }
        return objArray;
    }
    public  Object[][] getCustomerBySDT(String sdt) throws SQLException {
        ArrayList<Customer> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.khachhang where SDT = '"+sdt+"'";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Customer people = new Customer(temp_list_emp.getInt("idKhachHang"),
                    temp_list_emp.getString("diaChi"), temp_list_emp.getString("SDT"), temp_list_emp.getString("hoTen"),temp_list_emp.getInt("idCuaHang"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getCustomer_id(),staffs.get(i).getCustomer_address(),staffs.get(i).getCustomer_phone(),staffs.get(i).getCustomer_name(),staffs.get(i).getIdCuaHang()};
        }
        return objArray;
    }
    public int getCustomerBySDTReturnName(String sdt) throws SQLException {
        ArrayList<Customer> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select idKhachHang from quanlycuahang.khachhang where SDT = '"+sdt+"'";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        int tmp =0;
        while (temp_list_emp.next()) {
            tmp=temp_list_emp.getInt("idKhachHang");
        }
        return tmp;
    }
    public void deleteCustomerByID(int id) throws SQLException {
        String query ="delete from quanlycuahang.khachhang where idKhachHang = '"+id+"'";
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
        conn.close();
    }
    public void updateCustommerByOptions(int id, String name, String diachi, String sdt) throws SQLException {
        String query1 ="update  quanlycuahang.khachhang set hoTen='"+name+"', SDT='"+sdt+"', diaChi='"+diachi+"' where idKhachHang = "+id;
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query1);
        preparedStmt.execute();
        conn.close();
    }
}
