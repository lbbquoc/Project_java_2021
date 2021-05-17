//package company;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.util.ArrayList;
//
//import bill.Bill;
//import connectMySql.*;
//import java.sql.*;
//import java.util.Random;
//import java.util.Scanner;
//
//import employee.*;
//import stock.*;
//import product.*;
//import store.Store;
//
//
//public class company {
//    private int cID;
//    private String cName;
//    private String cAddress;
//    private String cPhone;
//    private Date cDayOfFounding;
//    private ArrayList<Employee> listEmployee = new ArrayList<Employee>();
//    private Store storeOfCompany = new Store();
//   // private ArrayList<store> listStore = new ArrayList<store>();
//    private ArrayList<stock> listStock = new ArrayList<stock>();
//
//    private ArrayList<Product> listProduct = new ArrayList<Product>();
//    // setter :
//    public void setListEmployee(ArrayList<Employee> listEmployee) {
//        this.listEmployee = listEmployee;
//    }
//    public void setListProduct(ArrayList<Product> listProduct) {
//        this.listProduct = listProduct;
//    }
//    public ArrayList<Product> getLisProduct() {
//        return this.listProduct;
//    }
//
//    public company setStoreOfCompany(Store storeOfCompany) {
//        this.storeOfCompany = storeOfCompany;
//        return this;
//    }
//
//    public void setListStock(ArrayList<stock> listStock) {
//        this.listStock = listStock;
//    }
//
//    // getter :
//
//
//    public Store getStoreOfCompany() {
//        return storeOfCompany;
//    }
//
//    public ArrayList<Employee> getLisEmployees() {
//        return this.listEmployee;
//    }
//
//
//    public ArrayList<stock> getListStock() {
//        return this.listStock;
//    }
//    public void setDateOFBirth(Date dob) {
//        this.cDayOfFounding = dob;
//    }
//
//    public Date getDateOFBirth() {
//        return this.cDayOfFounding;
//    }
//
//    public int geteID() {
//        return cID;
//    }
//
//    public void seteID(int eID) {
//        this.cID = eID;
//    }
//
//    public String geteName() {
//        return cName;
//    }
//
//    public void seteName(String eName) {
//        this.cName = eName;
//    }
//
//    public String geteAddress() {
//        return cAddress;
//    }
//
//    public void seteAddress(String eAddress) {
//        this.cAddress = eAddress;
//    }
//
//    public String getePhone() {
//        return cPhone;
//    }
//
//    public void setePhone(String ePhone) {
//        this.cPhone = ePhone;
//    }
//
//    // ----------------------------- ngay 2/5 --------------------
////    public void callOrder()
////    {
////
////        Scanner sc = new Scanner(System.in);
////
////        System.out.println("Nhap id khach hang: ");
////        int id_cus = sc.nextInt();
////
////        ArrayList<Integer> listIdSanPham = new ArrayList<Integer>();
////        while (true)
////        {
////            System.out.println("nhap vao mat hang can mua ( id:  ) ");
////            int n = sc.nextInt();
////            if (n == 0 )
////            {
////                break;
////            }
////            listIdSanPham.add(n);
////        }
////
////        // random id cua bill
////        Random generator = new Random();
////        int value = generator.nextInt(20) + 1;
////
////        // tao ngay lap bill
////        java.util.Date date = new java.util.Date();
////
//////        Bill billForCus = new Bill(value, this.getCustomer_id(), );
////        ArrayList<Product> listProduct = this.storeOfCompany.getListProduct();
////
////        ArrayList<Product> listProductForBill = new ArrayList<Product>();
////        for ( int x : listIdSanPham) {
////            for (int i = 0; i < listProduct.size(); i++) {
////                if (x == listProduct.get(i).getProduct_id())
////                {
////                    listProductForBill.add(listProduct.get(i));
////                }
////            }
////        }
////
////        Bill billForCus = new Bill(value,id_cus,listProductForBill,date);
////
////        System.out.println("Bill cua ban la: ");
////        System.out.println(billForCus.toString());
////    }
//
//
//
//
//
//    // **********************************STOCK******************************
//    public void insertStockToDB() {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("Creating table in Store database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            for (int i = 0; i < listStock.size(); i++) {
//                stock stoc =listStock.get(i);
//                String sql = "INSERT INTO kho (idKho, diaChiKho, sucChua,tinhTrangKHo,SDT)"
//                        + " VALUES (?, ?, ?, ?, ?)";
//                // the mysql insert statement
//                PreparedStatement pstmt = conn.prepareStatement(sql);
//
//                pstmt.setInt(1, stoc.getStock_id());
//                pstmt.setString(2, stoc.getStock_address());
//                pstmt.setInt(3, stoc.getStockLimit());
//                pstmt.setBoolean(4, stoc.getStockStatus());
//                pstmt.setString(5, stoc.getStock_phone());
//                pstmt.executeUpdate();
//            }
//
//            System.out.println("Table kho insert successfully...");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//    //Xóa:
//    public void deleteStockByID(int id) {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("DELETE kho table database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            String query = "delete from kho where idKho = ?";
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setInt(1, id);
//            // execute the java preparedstatement
//            preparedStmt.executeUpdate();
//
//            System.out.println("kho in Table kho delete successfully...");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//    //Sửa:
//    public void updateStockByID(int id, String diaChi) {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("UPDATE kho table database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            String query = "UPDATE kho set diaChiKho = ? where idKho = ?";
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setString(1, diaChi);
//            preparedStmt.setInt(2, id);
//
//            // execute the java preparedstatement
//            preparedStmt.executeUpdate();
//
//            System.out.println("Table kho update successfully...");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//
//    }
//    // ***************************************************************************************
//        // **********************************Product******************************
//        public void insertProductToDB() {
//            Statement stmt = null;
//            Connection conn = null;
//            try {
//                System.out.println("Creating table in Product database...");
//                conn = ConnectDB.connectDB();
//                stmt = conn.createStatement();
//
//                for (int i = 0; i < listProduct.size(); i++) {
//                    Product prod =listProduct.get(i);
//                    String sql = "INSERT INTO sanpham (idSanPham, tenSanPham, loaiSP, moTa, ngaySanXuat, hanSuDung, gia)"
//                            + " VALUES (?, ?, ?, ?, ?,?,?)";
//                    // the mysql insert statement
//                    PreparedStatement pstmt = conn.prepareStatement(sql);
//
//                    pstmt.setInt(1, prod.getProduct_id());
//                    pstmt.setString(2, prod.getProduct_name());
//                    pstmt.setInt(3, prod.getProduct_type());
//                    pstmt.setString(4, prod.getProduct_description());
//                    pstmt.setDate(5, prod.getdateOFManufacture());
//                    pstmt.setDate(6, prod.getExpiryDate());
//                    pstmt.setFloat(7, prod.getProductPrice());
//                    pstmt.executeUpdate();
//                }
//
//                System.out.println("Table Product insert successfully...");
//
//            } catch (Exception e) {
//                // TODO: handle exception
//                e.printStackTrace();
//            } finally {
//                // finally block used to close resources
//                try {
//                    if (stmt != null)
//                        stmt.close();
//                } catch (SQLException se2) {
//                }
//                try {
//                    if (conn != null)
//                        conn.close();
//                } catch (SQLException se) {
//                    se.printStackTrace();
//                }
//            }
//        }
//        //Xóa:
//        public void deleteProductByID(int id) {
//            Statement stmt = null;
//            Connection conn = null;
//            try {
//                System.out.println("DELETE Product table database...");
//                conn = ConnectDB.connectDB();
//                stmt = conn.createStatement();
//
//                String query = "delete from sanpham where idSanPham = ?";
//                PreparedStatement preparedStmt = conn.prepareStatement(query);
//                preparedStmt.setInt(1, id);
//                // execute the java preparedstatement
//                preparedStmt.executeUpdate();
//
//                System.out.println("sanpham in Table sanpham delete successfully...");
//
//            } catch (Exception e) {
//                // TODO: handle exception
//                e.printStackTrace();
//            } finally {
//                // finally block used to close resources
//                try {
//                    if (stmt != null)
//                        stmt.close();
//                } catch (SQLException se2) {
//                }
//                try {
//                    if (conn != null)
//                        conn.close();
//                } catch (SQLException se) {
//                    se.printStackTrace();
//                }
//            }
//        }
//        //Sửa:
//        public void updateProductByID(int id, float gia) {
//            Statement stmt = null;
//            Connection conn = null;
//            try {
//                System.out.println("UPDATE sanpham table database...");
//                conn = ConnectDB.connectDB();
//                stmt = conn.createStatement();
//
//                String query = "UPDATE sanpham set gia = ? where idSanPham = ?";
//                PreparedStatement preparedStmt = conn.prepareStatement(query);
//                preparedStmt.setFloat(1, gia);
//                preparedStmt.setInt(2, id);
//
//                // execute the java preparedstatement
//                preparedStmt.executeUpdate();
//
//                System.out.println("Table sanpham update price successfully...");
//
//            } catch (Exception e) {
//                // TODO: handle exception
//                e.printStackTrace();
//            } finally {
//                // finally block used to close resources
//                try {
//                    if (stmt != null)
//                        stmt.close();
//                } catch (SQLException se2) {
//                }
//                try {
//                    if (conn != null)
//                        conn.close();
//                } catch (SQLException se) {
//                    se.printStackTrace();
//                }
//            }
//
//        }
//        // ***************************************************************************************
//    public void insertEmployeeToDB() {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("Creating table in STUDENTS database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            for (int i = 0; i < listEmployee.size(); i++) {
//                Employee em = listEmployee.get(i);
//                String sql = "INSERT INTO nhanvien (idNhanVien, hoTenNhanVien, SDT, diaChi, ngaySinh, gioiTinh, luong, ngayVaoCongTy, maCongTy, loaiNhanVien)"
//                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
//                // the mysql insert statement
//                PreparedStatement pstmt = conn.prepareStatement(sql);
//
//                pstmt.setInt(1, em.geteID());
//                pstmt.setString(2, em.geteName());
//                pstmt.setString(3, em.getePhone());
//                pstmt.setString(4, em.geteAddress());
//                pstmt.setDate(5, em.getDateOFBirth());
//                pstmt.setString(6, em.geteSex());
//                pstmt.setInt(7, em.geteSalary());
//                pstmt.setDate(8, em.getDayJoinCompany());
//                pstmt.setInt(9, em.getIDCompany());
//                pstmt.setInt(10, em.geteType());
//
//                pstmt.executeUpdate();
//            }
//
//            System.out.println("Table nhanVien insert successfully...");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//
//    public void deleteEmployeeByID(int id) {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("DELETE nhanvien table database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            String query = "delete from nhanvien where idNhanVien = ?";
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setInt(1, id);
//            // execute the java preparedstatement
//            preparedStmt.executeUpdate();
//
//            System.out.println("student in Table nhanvien delete successfully...");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//
//    public void findStudentByID(int id_) {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("find data in table database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            String query = "SELECT * FROM nhanvien WHERE idNhanVien = ?";
//
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setInt(1, id_);
//
//            // execute the query, and get a java resultset
//            ResultSet rs = preparedStmt.executeQuery();
//
//            // iterate through the java resultset
//            while (rs.next()) {
//                int id = rs.getInt("idNhanVien");
//                String firstName = rs.getString("hoTenNhanVien");
//                String phone = rs.getString("SDT");
//                Date dateCreated = rs.getDate("ngaySinh");
//                String diaChi = rs.getString("diaChi");
//                String sex = rs.getString("gioiTinh");
//                int luong = rs.getInt("luong");
//                Date dateJoinCompa = rs.getDate("ngayVaoCongTy");
//                int idCompa = rs.getInt("maCongTy");
//                int typeE = rs.getInt("loaiNhanVien");
//
//                // print the results
//                System.out.format("%s, %s, %s, %s, %s\n", id, firstName, phone, dateCreated, diaChi);
//                System.out.format("%s,%s,%s,%s,%s\n", sex, luong, dateJoinCompa, idCompa, typeE);
//
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//
//    public void updateStudentByID(int id, String diaChi) {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("UPDATE nhanvien table database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            String query = "UPDATE nhanvien set diaChi = ? where idNhanVien = ?";
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setString(1, diaChi);
//            preparedStmt.setInt(2, id);
//
//            // execute the java preparedstatement
//            preparedStmt.executeUpdate();
//
//            System.out.println("Table nhanvien update successfully...");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//
//    }
//
//    public void findAll_Student() {
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            System.out.println("find data in table database...");
//            conn = ConnectDB.connectDB();
//            stmt = conn.createStatement();
//
//            String query = "SELECT * FROM nhanvien";
//
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//
//            // execute the query, and get a java resultset
//            ResultSet rs = preparedStmt.executeQuery();
//
//            // iterate through the java resultset
//            while (rs.next()) {
//                int id = rs.getInt("idNhanVien");
//                String firstName = rs.getString("hoTenNhanVien");
//                String phone = rs.getString("SDT");
//                Date dateCreated = rs.getDate("ngaySinh");
//                String diaChi = rs.getString("diaChi");
//                String sex = rs.getString("gioiTinh");
//                int luong = rs.getInt("luong");
//                Date dateJoinCompa = rs.getDate("ngayVaoCongTy");
//                int idCompa = rs.getInt("maCongTy");
//                int typeE = rs.getInt("loaiNhanVien");
//
//                // print the results
//                System.out.format("%s, %s, %s, %s, %s\n", id, firstName, phone, dateCreated, diaChi);
//                System.out.format("%s,%s,%s,%s,%s\n", sex, luong, dateJoinCompa, idCompa, typeE);
//
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//
//
//
//}
