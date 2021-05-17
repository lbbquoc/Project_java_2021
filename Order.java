package order;

import connectMySql.ConnectDB;
import employee.Employee;
import product.Product;

import java.sql.*;
import java.util.ArrayList;

public class Order {
    private int idKhachHang;
    private int idOrder;
    private Product product;
    private int soluong;
    private int tongCong;
    private int id_bill;
    private Date data_order;
    private int idSP;

    public Order(int idOrder,int idSP, int soluong,Date data_order,  int id_bill, int tongCong ) {
        this.idOrder = idOrder;
        this.soluong = soluong;
        this.tongCong = tongCong;
        this.id_bill = id_bill;
        this.data_order = data_order;
        this.idSP = idSP;
    }

    public void setTongCong(int tongCong) {
        this.tongCong = tongCong;
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
    }

    public Date getData_order() {
        return data_order;
    }

    public void setData_order(Date data_order) {
        this.data_order = data_order;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    // getter
    public int getTongCong() {
        int sum = (int) (product.getProductPrice() * getSoluong());
        setTongCong(sum);
        return tongCong;
    }
    public int getTongCong2(){
        return this.tongCong;
    }
//    public int getTongCong(){
//        return this.tongCong;
//    }
    public int getSoluong() {
        return soluong;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public Product getProduct() {
        return product;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    // setter


    public Order setProduct(Product product) {
        this.product = product;
        return this;
    }



    public Order setSoluong(int soluong) {
        this.soluong = soluong;
        return this;
    }

    public Order setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
        return this;
    }
    //cóntructor
    public Order(int idKhachHang, Product sp, int soluong) {

        this.idKhachHang = idKhachHang;

        this.product = sp;
        this.soluong = soluong;
    }

    public Order() {
    }

    public Order(int idOrder) {
        this.idOrder = idOrder;
    }
    public Object[][] getList() throws SQLException {
        ArrayList<Order> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();
        String qSelect = "select * from quanlycuahang.ordertable";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Order people = new Order(temp_list_emp.getInt("idOrder"),
                    temp_list_emp.getInt("idSanPham"), temp_list_emp.getInt("soLuongSP"), temp_list_emp.getDate("dateOfOrder"),temp_list_emp.getInt("id_bill"), temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getIdOrder(),staffs.get(i).getIdSP(),staffs.get(i).getSoluong(),staffs.get(i).getData_order(),staffs.get(i).getId_bill(), staffs.get(i).getTongCong2()};
        }
        return objArray;
    }
    public Object[][] getOrderByBillID(int id) throws SQLException {
        ArrayList<Order> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.ordertable where id_bill="+id;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Order people = new Order(temp_list_emp.getInt("idOrder"),
                    temp_list_emp.getInt("idSanPham"), temp_list_emp.getInt("soLuongSP"), temp_list_emp.getDate("dateOfOrder"),temp_list_emp.getInt("id_bill"), temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getIdOrder(),staffs.get(i).getIdSP(),staffs.get(i).getSoluong(),staffs.get(i).getData_order(),staffs.get(i).getId_bill(), staffs.get(i).getTongCong2()};
        }
        return objArray;
    }
    public Object[][] getOrderByDate(String date) throws SQLException {
        ArrayList<Order> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.ordertable where dateOfOrder='"+date+"'";
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Order people = new Order(temp_list_emp.getInt("idOrder"),
                    temp_list_emp.getInt("idSanPham"), temp_list_emp.getInt("soLuongSP"), temp_list_emp.getDate("dateOfOrder"),temp_list_emp.getInt("id_bill"), temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getIdOrder(),staffs.get(i).getIdSP(),staffs.get(i).getSoluong(),staffs.get(i).getData_order(),staffs.get(i).getId_bill(), staffs.get(i).getTongCong2()};
        }
        return objArray;
    }
    public Object[][] getOrderByOrderID(int id) throws SQLException {
        ArrayList<Order> staffs = new ArrayList<>();
        Connection conn = ConnectDB.connectDB();

        String qSelect = "select * from quanlycuahang.ordertable where idOrder="+id;
        PreparedStatement preparedStmt = conn.prepareStatement(qSelect);
        ResultSet temp_list_emp = preparedStmt.executeQuery();
        while (temp_list_emp.next()) {
            Order people = new Order(temp_list_emp.getInt("idOrder"),
                    temp_list_emp.getInt("idSanPham"), temp_list_emp.getInt("soLuongSP"), temp_list_emp.getDate("dateOfOrder"),temp_list_emp.getInt("id_bill"), temp_list_emp.getInt("tongTien"));
            staffs.add(people);
        }
        Object[][] objArray = new Object[staffs.size()][];
        for (int i = 0; i < staffs.size(); i++) {
            objArray[i] = new Object[]{staffs.get(i).getIdOrder(),staffs.get(i).getIdSP(),staffs.get(i).getSoluong(),staffs.get(i).getData_order(),staffs.get(i).getId_bill(), staffs.get(i).getTongCong2()};
        }
        return objArray;
    }
    public void deleteOrderByID(int id) throws SQLException {
        String query ="delete from quanlycuahang.ordertable where idOrder = '"+id+"'";
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
        conn.close();
    }
    public void updateOrderByOptions(int idOrder, int idsp, int sl) throws SQLException {
        String query1 ="update  quanlycuahang.ordertable set idSanPham="+idsp+", soLuongSP="+sl+" where idOrder = "+idOrder;
        Connection conn = ConnectDB.connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement(query1);
        preparedStmt.execute();
        conn.close();
    }
}
