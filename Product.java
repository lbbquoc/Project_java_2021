package product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import bill.Bill;
import connectMySql.*;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

import employee.*;
import stock.*;
import product.*;
import store.Store;

public class Product {
    private int product_id;
    private String product_name;
    // private String product_type_name;
    private int product_price;
    private Date dateOFManufacture; //
    private String expiryDate; // 

    // loai san pham
    private int product_type;// 1.do an, 2.gia vi, 3 do dien tu
    private String product_type_name;

    private String product_description;
    private int soLuong;
    private int idCuaHang;

    public Product(int idSanPham, String tenSanPham, int loaiSP, String moTa, Date ngaySanXuat, String hanSuDung, int gia, int idCuaHang, int soLuong) {
        this.product_id = idSanPham;
        this.product_name = tenSanPham;
        this.product_type = loaiSP;
        this.product_description = moTa;
        this.dateOFManufacture = ngaySanXuat;
        this.expiryDate = hanSuDung;
        this.product_price = gia;
        this.idCuaHang = idCuaHang;
        this.soLuong = soLuong;
    }

    // setter:
    public void setProductPrice(int price) {
        this.product_price = price;
    }

    public Product setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        return this;
    }

    public void setdateOFManufacture(Date manu) {
        this.dateOFManufacture = manu;
    }

    public void setExpiryDate(String expiry) {
        this.expiryDate = expiry;
    }
// idSanPham, tenSanPham, loaiSP, moTa, ngaySanXuat, hanSuDung, gia

    public Product(int product_id, String product_name, int product_type, String product_description, Date dateOFManufacture, String expiryDate, int product_price,int sl) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.dateOFManufacture = dateOFManufacture;
        this.expiryDate = expiryDate;
        this.product_type = product_type;
        this.product_description = product_description;
        this.soLuong = sl;
    }

    public Product() {

    }

    public Product(String filename, Store store) {
        Statement stmt = null;
        Connection conn = null;

        try {
            System.out.println("Creating table in Store database...");
            conn = ConnectDB.connectDB();
            stmt = conn.createStatement();
            try {
                //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
                File f = new File(filename);
                FileReader fr = new FileReader(f);
                //Bước 2: Đọc dữ liệu
                BufferedReader br = new BufferedReader(fr);
                String line;
                br.readLine(); // doc file dau tien

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    System.out.println(line);

                    // handling data
                    int idP = Integer.parseInt(data[0]);
                    String nameP = data[1];
                    int price = Integer.parseInt(data[2]);
                    Date NSX = Date.valueOf(data[3]);
                    String HSD = data[4];
                    int type = Integer.parseInt(data[5]);
                    String typeName = data[6];
                    String description = data[7];
                    int soLuong = Integer.parseInt(data[8]);

//                    // query for insert data to sanpham table
//                    String sql = "INSERT INTO sanpham (idSanPham, tenSanPham, loaiSP, moTa,ngaySanXuat, hanSuDung, gia, idCuaHang, soLuong)"
//                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    String sql = "{call insertProduct(?,?,?,?,?,?,?,?,?)}";
                    // the mysql insert statement
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, idP);
                    pstmt.setString(2, nameP);
                    pstmt.setInt(3, type);
                    pstmt.setString(4, description);
                    pstmt.setDate(5, NSX);
                    pstmt.setString(6, HSD);
                    pstmt.setFloat(7, price);
                    pstmt.setInt(8, store.getStore_id());
                    pstmt.setInt(9,soLuong);

                    // EXECUTE
                    pstmt.executeUpdate();
                }
                //Bước 3: Đóng luồng
                fr.close();
                br.close();
            } catch (Exception ex) {
                System.out.println("Loi doc file: " + ex);
            }
            System.out.println("Table kho insert successfully...");

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


    // getter:
    public float getProductPrice() {
        return this.product_price;
    }

    public java.util.Date getdateOFManufacture() {
        return this.dateOFManufacture;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getproduct_type_name() {
        return product_type_name;
    }

    public void setproduct_type_name(String product_type_name) {
        this.product_type_name = product_type_name;
    }

    public int getProduct_type() {
        return product_type;
    }

    public void setProduct_type(int product_type) {
        this.product_type = product_type;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void nhapSanPham() {

    }

    public void addProduct() {

    }

    public void editProduct() {

    }

    public void deleteProduct() {

    }

    public void searchProduct() {

    }

    public int getIdCuaHang() {
        return idCuaHang;
    }
    public Object[][] getProductByOptions(String name, String type) throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        int res_type = 0;
        if(type.equals("Gia vị")) res_type = 1;
        else if(type.equals("Thực phẩm sống"))  res_type = 2;
        else res_type = 3;
        String qSelect = "select * from quanlycuahang.sanpham where tenSanPham='"+name+"' and loaiSP="+res_type;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Product product = new Product(temp_list_emp.getInt("idSanPham"),
                    temp_list_emp.getString("tenSanPham"), temp_list_emp.getInt("loaiSP"), temp_list_emp.getString("moTa"),temp_list_emp.getDate("ngaySanXuat"), temp_list_emp.getString("hanSuDung"), temp_list_emp.getInt("gia"), temp_list_emp.getInt("idCuaHang"),temp_list_emp.getInt("soLuong"));
            products.add(product);
        }
        Object[][] objArray = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            objArray[i] = new Object[]{products.get(i).getProduct_id(),products.get(i).getProduct_name(),products.get(i).getProduct_type(),products.get(i).getProduct_description(),products.get(i).getdateOFManufacture(), products.get(i).getExpiryDate(), products.get(i).getProductPrice(), products.get(i).getIdCuaHang(),products.get(i).getSoLuong()};
        }
        return objArray;
    }
    public Object[][] getList() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.sanpham";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Product product = new Product(temp_list_emp.getInt("idSanPham"),
                    temp_list_emp.getString("tenSanPham"), temp_list_emp.getInt("loaiSP"), temp_list_emp.getString("moTa"),temp_list_emp.getDate("ngaySanXuat"), temp_list_emp.getString("hanSuDung"), temp_list_emp.getInt("gia"), temp_list_emp.getInt("idCuaHang"),temp_list_emp.getInt("soLuong"));
            products.add(product);
        }
        Object[][] objArray = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            objArray[i] = new Object[]{products.get(i).getProduct_id(),products.get(i).getProduct_name(),products.get(i).getProduct_type(),products.get(i).getProduct_description(),products.get(i).getdateOFManufacture(), products.get(i).getExpiryDate(), products.get(i).getProductPrice(), products.get(i).getIdCuaHang(),products.get(i).getSoLuong()};
        }
        return objArray;
    }
    public void deleteProductByID(int id) throws SQLException {
        String query ="delete from quanlycuahang.sanpham where idSanPham = '"+id+"'";
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
        conn.close();
    }
}
