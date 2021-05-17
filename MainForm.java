package gui;

import bill.Bill;
import customer.Customer;
import employee.Employee;
import order.Order;
import product.Product;
import login.login;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class MainForm extends JFrame {

    private JPanel MainPanel;
    private JPanel MenuPanel;
    private JPanel MidPanel;
    private JPanel EndPanel;
    private JLabel MenuPanel_UD;
    private JLabel Home;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel loginPanel;
    private JLabel Search;
    private JLabel Fix;
    private JLabel logout;
    private JLabel exit;

    private JPanel homePanel;
    private JPanel searchPanel;
    private JTabbedPane tabbedPane1;
    private JPanel productSearch;
    private JComboBox search_product_type;
    private JButton findButton;
    private JPanel employeeSearch;
    private JTextField idnvInput;
    private JTextField namenvInput;
    private JTextField paynvInput;
    private JButton button1;
    private JPanel customerSearch;
    private JTextField textField2;
    private JButton customer_find_Button;
    private JPanel billSearch;
    private JTextField textField3;
    private JButton search_bill_Button;
    private JPanel orderSearch;
    private JTextField textField4;
    private JButton search_order_Button;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton newOrderButton;
    private JTextField textField8;
    private JPanel getallPanel;
    private JTabbedPane tabbedPane2;
    private JTable employeeData;
    private JLabel getalllist;
    private JPanel panel1;
    private JTable productData;
    private JPanel panel2;
    private JTable customerData;
    private JPanel panel3;
    private JTable billData;
    private JButton querybillButton;
    private JTextField textField9;
    private JPanel getOrderPanel;
    private JTable orderData;
    private JButton backButton;
    private JTextField search_product_name;
    private JTable search_result;
    private JButton registerButton;
    private JPanel regis_Panel;
    private JTextField textField10;
    private JTextField textField11;
    private JButton regButton;
    private JComboBox comboBox1;
    private JPasswordField passwordField2;
    private JPanel newOrderPanel;
    private JPanel deletePanel;
    private JTabbedPane tabbedPane3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JTextField textField12;
    private JButton delete_nv_Button;
    private JTable delete_List;
    private JLabel Delete;
    private JTextField textField13;
    private JButton delete_customer_Button;
    private JTextField textField14;
    private JButton delete_product_Button;
    private JTextField textField15;
    private JButton delete_bill_Button;
    private JTextField textField16;
    private JButton delete_order_Button;
    private JPanel updatePanel;
    private JTabbedPane tabbedPane4;
    private JPanel panel8;
    private JPanel panel9;
    private JTextField textField17;
    private JButton update_nv_Button;
    private JTable update_nv_Table;
    private JScrollPane update_nv_Panel;
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JTextField textField26;
    private JTextField textField27;
    private JButton update_kh_Button;
    private JTextField textField28;
    private JTextField textField29;
    private JTextField textField30;
    private JButton update_order_Button;
    private JTextField textField31;
    private JButton create_OrderButton;
    private JTextArea textArea1;
    private JTextField textField32;
    private JTextField textField33;
    private JButton execute_Button;
    private JLabel sanphamcanorder;
    private JLabel soluongsanpham;
    private JTextField textField34;
    private JTextField textField35;
    private JButton reg_back_Button;
    private JTextArea welcomText;
    private Boolean isRegister = false;
    private CardLayout cl = (CardLayout) MidPanel.getLayout();

    public void setRegisterState(Boolean temp) {
        isRegister = temp;
    }

    private login log_overall;

    public login getLog_overall() {
        return log_overall;
    }

    public MainForm(String title) throws IOException, SQLException {

        super(title);
        this.setContentPane(MainPanel);
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        tabbedPane3.setSelectedIndex(1);
        Bill tmpx = new Bill();
        textField34.setText(String.valueOf(tmpx.tongDoanhthu(5)));
        textField35.setText(String.valueOf(tmpx.tongDoanhthungay(LocalDate.now().getDayOfMonth())));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String password = new String(passwordField1.getPassword());
                System.out.println(id);
                System.out.println(password);
                log_overall = new login();

                try {
                    System.out.println(log_overall.checkloginInfo(id, password));
                    if (log_overall.checkloginInfo(id, password)) {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                        ImageIcon icon = new ImageIcon(
                                "G:\\DO AN JAVA 15.05.2021\\src\\resources\\images\\home-on.PNG");
                        Home.setIcon(icon);
                        ImageIcon icon2 = new ImageIcon(
                                "G:\\DO AN JAVA 15.05.2021\\src\\resources\\images\\find-on.PNG");
                        Search.setIcon(icon2);
                        ImageIcon icon3 = new ImageIcon(
                                "G:\\DO AN JAVA 15.05.2021\\src\\resources\\images\\setting-on.PNG");
                        Fix.setIcon(icon3);
                        ImageIcon icon4 = new ImageIcon(
                                "G:\\DO AN JAVA 15.05.2021\\src\\resources\\images\\logout-on.PNG");
                        logout.setIcon(icon4);
                        ImageIcon icon5 = new ImageIcon(
                                "G:\\DO AN JAVA 15.05.2021\\src\\resources\\images\\exit-on.PNG");
                        exit.setIcon(icon5);
                        Employee tmp_emp = log_overall.getEmployeeInfo();
                        textField5.setText(tmp_emp.geteName());
                        textField6.setText(String.valueOf(tmp_emp.geteDayOfBirth()));
                        textField7.setText(tmp_emp.geteAddress());
                        if (log_overall.getDacquyen() == 1) {
                            textField8.setText("Nhân viên");
                        } else if (log_overall.getDacquyen() == 2) {
                            textField8.setText("Nhân viên quản lý");
                        } else {
                            textField8.setText("Admin");
                        }
                        cl.show(MidPanel, "Card2");
                        setRegisterState(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        Search.addComponentListener(new ComponentAdapter() {
        });
        Search.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isRegister == false) {
                    JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước khi thao tác");
                } else {
                    cl.show(MidPanel, "Card3");
                }
            }
        });

        Home.addComponentListener(new ComponentAdapter() {
        });
        Home.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isRegister == false) {
                    JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước khi thao tác");
                } else {
                    cl.show(MidPanel, "Card2");
                }
            }
        });
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isRegister == false) {
                    JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước khi thao tác");
                } else {
                    setRegisterState(false);
                    cl.show(MidPanel, "Card1");
                }
            }
        });
        Employee emp1 = new Employee();
        Object[][] data = emp1.getList();
        employeeData.setModel(new DefaultTableModel(data, new String[] { "ID", "Tên", "Số điện thoại", "Địa Chỉ",
                "Ngày sinh", "Giới tính", "Lương", "Loại nhân viên", "ID Cửa hàng" }));

        Product prd1 = new Product();
        Object[][] data1 = prd1.getList();
        productData.setModel(new DefaultTableModel(data1, new String[] { "ID sản phẩm", "Tên sản phẩm", "Loại sản phẩm",
                "Mô tả", "Ngày sản xuất", "Hạn sử dụng", "Giá", "Id cửa hàng", "Số lượng" }));

        Customer cus1 = new Customer();
        Object[][] data2 = cus1.getList();
        customerData.setModel(new DefaultTableModel(data2,
                new String[] { "ID khách háng", "Địa chỉ", "Số điện thoại", "Họ và tên", "Id cửa hàng" }));

        Bill bill1 = new Bill();
        Object[][] data3 = bill1.getList();
        billData.setModel(new DefaultTableModel(data3,
                new String[] { "ID Bill", "ID nhân viên", "ID khách hàng", "Ngày tạo bill", "Tổng tiền" }));
        // billData.setModel(new DefaultTableModel(data3, new String[]{"ID Bill","ID
        // NV","ID KH","DATE","sum"}));
        // JTableHeader h1 = new JTableHeader(new String[]{"ID Bill","ID NV","ID
        // KH","DATE","sum"});
        // billData.setTableHeader();
        getalllist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isRegister == false) {
                    JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước khi thao tác");
                } else {

                    cl.show(MidPanel, "Card4");
                }

            }
        });
        querybillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bill_query_id = Integer.parseInt(textField9.getText());
                Order order1 = new Order();
                try {
                    Object[][] data4 = order1.getOrderByBillID(bill_query_id);
                    orderData.setModel(new DefaultTableModel(data4, new String[] { "ID Order", "ID sản phẩm",
                            "Số lượng sản phẩm", "Ngày xuất order", "ID bill", "Tổng tiền" }));
                    cl.show(MidPanel, "Card5");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(MidPanel, "Card4");
            }
        });
        // TODO:Tìm kiếm sản phẩm theo loại sản phẩm và tên sản phẩm
        findButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String ten_sp = search_product_name.getText();
                String ten_loai_sp = search_product_type.getSelectedItem().toString();
                Product tmp_emp_2 = new Product();
                try {
                    Object[][] data_in = tmp_emp_2.getProductByOptions(ten_sp, ten_loai_sp);
                    if (data_in.length != 0)
                        search_result.setModel(new DefaultTableModel(data_in,
                                new String[] { "ID sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Mô tả", "Ngày sản xuất",
                                        "Hạn sử dụng", "Giá", "Id cửa hàng", "Số lượng" }));
                    else {
                        JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        // TODO: Tìm kiếm nhân viên theo id,tên,lương
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Employee tmp_emp_2 = new Employee();
                try {
                    Object[][] data_in = tmp_emp_2.getEmployeeByOptions(Integer.parseInt(idnvInput.getText()),
                            namenvInput.getText(), Integer.parseInt(paynvInput.getText()));
                    if (data_in.length != 0)
                        search_result.setModel(
                                new DefaultTableModel(data_in, new String[] { "ID", "Tên", "Số điện thoại", "Địa Chỉ",
                                        "Ngày sinh", "Giới tính", "Lương", "Loại nhân viên", "ID Cửa hàng" }));
                    else {
                        JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        customer_find_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Customer tmp_emp_2 = new Customer();
                try {
                    Object[][] data_in = tmp_emp_2.getCustomerByOptions(Integer.parseInt(textField2.getText()));
                    if (data_in.length != 0)
                        search_result.setModel(new DefaultTableModel(data_in, new String[] { "ID khách háng", "Địa chỉ",
                                "Số điện thoại", "Họ và tên", "Id cửa hàng" }));
                    else {
                        JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        // TODO: Tìm kiếm bill bằng mã khách hàng
        search_bill_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Bill tmp_emp_2 = new Bill();
                System.out.println(textField3.getText().equals(""));
                System.out.println(textField31.getText());
                try {
                    Object[][] data_in = new Object[0][];
                    if (!textField3.getText().equals("") && textField31.getText().equals("")) {
                        data_in = tmp_emp_2.getBillBySDT(textField3.getText());
                    } else if (!textField31.getText().equals("") && textField3.getText().equals("")) {
                        data_in = tmp_emp_2.getBillByDate(textField31.getText());
                    } else if (!textField31.getText().equals("") && !textField3.getText().equals("")) {
                        data_in = tmp_emp_2.getBillBySDTDATE(textField31.getText(), textField3.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "Không được để rỗng cả 2 ô!");
                    }

                    if (data_in.length != 0)
                        search_result.setModel(new DefaultTableModel(data_in, new String[] { "ID Bill", "ID nhân viên",
                                "ID khách hàng", "Ngày tạo bill", "Tổng tiền" }));
                    else {
                        JOptionPane.showMessageDialog(null, "Bill không tồn tại!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        // TODO: Tìm kiếm order bằng mã bill
        search_order_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Order tmp_emp_2 = new Order();
                try {
                    Object[][] data_in = tmp_emp_2.getOrderByDate(textField4.getText());
                    if (data_in.length != 0)
                        search_result.setModel(new DefaultTableModel(data_in, new String[] { "ID Order", "ID sản phẩm",
                                "Số lượng sản phẩm", "Ngày xuất order", "ID bill", "Tổng tiền" }));
                    else {
                        JOptionPane.showMessageDialog(null, "Order không tồn tại!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        // MenuPanel_UD.addMouseListener(new MouseAdapter() {
        // @Override
        // public void mouseClicked(MouseEvent e) {
        // super.mouseClicked(e);
        //
        // }
        // });
        regButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
        regButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String password = new String(passwordField2.getPassword());
                login newlog = new login();
                int type_em = 0;
                if (comboBox1.getSelectedItem().toString().equals("Nhân viên thường"))
                    type_em = 1;
                else if (comboBox1.getSelectedItem().toString().equals("Nhân viên quản lý"))
                    type_em = 2;
                else
                    type_em = 3;
                try {
                    newlog.addUser(textField10.getText(), password, type_em);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                cl.show(MidPanel, "Card1");
            }
        });
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cl.show(MidPanel, "Card6");
            }
        });

        Delete.addMouseMotionListener(new MouseMotionAdapter() {
        });
        Delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isRegister)
                    cl.show(MidPanel, "Card8");
                else {
                    JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước khi thao tác");
                }
            }
        });
        tabbedPane3.addChangeListener(new ChangeListener() {
            @Override

            public void stateChanged(ChangeEvent e) {
                login log1 = new login();
                log1 = log_overall;
                int curr_user_type = log1.getDacquyen();
                int curr_index = tabbedPane3.getSelectedIndex();
                System.out.println(curr_user_type);
                System.out.println(curr_index);

                if (curr_index == 0) {
                    if (curr_user_type == 4) {
                        Employee tmp_emp_2 = new Employee();
                        try {
                            Object[][] data_in = tmp_emp_2.getList();
                            if (data_in.length != 0)
                                delete_List.setModel(new DefaultTableModel(data_in,
                                        new String[] { "ID", "Tên", "Số điện thoại", "Địa Chỉ", "Ngày sinh",
                                                "Giới tính", "Lương", "Loại nhân viên", "ID Cửa hàng" }));
                            else {
                                JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!");
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Chỉ có admin mới được quyền truy cập mục này!");
                        tabbedPane3.setSelectedIndex(1);
                    }
                } else if (curr_index == 1) {
                    Customer cus1 = new Customer();
                    try {
                        Object[][] data_in = cus1.getList();
                        if (data_in.length != 0)
                            delete_List.setModel(new DefaultTableModel(data_in, new String[] { "ID khách háng",
                                    "Địa chỉ", "Số điện thoại", "Họ và tên", "Id cửa hàng" }));
                        else {
                            JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại!");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else if (curr_index == 2) {
                    Product cus1 = new Product();
                    try {
                        Object[][] data_in = cus1.getList();
                        if (data_in.length != 0)
                            delete_List.setModel(new DefaultTableModel(data_in,
                                    new String[] { "ID sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Mô tả",
                                            "Ngày sản xuất", "Hạn sử dụng", "Giá", "Id cửa hàng", "Số lượng" }));
                        else {
                            JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại!");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else if (curr_index == 3) {
                    Bill cus1 = new Bill();
                    try {
                        Object[][] data_in = cus1.getList();
                        if (data_in.length != 0)
                            delete_List.setModel(new DefaultTableModel(data_in, new String[] { "ID Bill",
                                    "ID nhân viên", "ID khách hàng", "Ngày tạo bill", "Tổng tiền" }));
                        else {
                            JOptionPane.showMessageDialog(null, "Bill không tồn tại!");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    Order cus1 = new Order();
                    try {
                        Object[][] data_in = cus1.getList();
                        if (data_in.length != 0)
                            delete_List.setModel(new DefaultTableModel(data_in, new String[] { "ID Order",
                                    "ID sản phẩm", "Số lượng sản phẩm", "Ngày xuất order", "ID bill", "Tổng tiền" }));
                        else {
                            JOptionPane.showMessageDialog(null, "Bill không tồn tại!");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

            }
        });
        delete_nv_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Employee emp_1 = new Employee();
                try {
                    emp_1.deleteEmployeeByID(Integer.parseInt(textField12.getText()));
                    JOptionPane.showMessageDialog(null, "Xóa thành công");

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        delete_customer_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Customer cst1 = new Customer();
                try {
                    cst1.deleteCustomerByID(Integer.parseInt(textField13.getText()));
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        delete_product_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Product prd1 = new Product();
                try {
                    prd1.deleteProductByID(Integer.parseInt(textField14.getText()));
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        delete_bill_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Bill bill1 = new Bill();
                try {
                    bill1.deleteBillByID(Integer.parseInt(textField15.getText()));
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        delete_order_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Order ord1 = new Order();
                try {
                    ord1.deleteOrderByID(Integer.parseInt(textField16.getText()));
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        Fix.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isRegister == false) {
                    JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước khi thao tác");
                } else {
                    cl.show(MidPanel, "Card9");
                }

            }
        });

        update_nv_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Employee tmp_emp_2 = new Employee();
                Date tmp = Date.valueOf(textField20.getText());
                if (textField17.getText() != null && textField18.getText() != null && textField19.getText() != null
                        && textField20.getText() != null && textField21.getText() != null
                        && textField22.getText() != null && textField23.getText() != null) {
                    try {
                        tmp_emp_2.updateEmployeeByOptions(Integer.parseInt(textField17.getText()),
                                textField18.getText(), textField19.getText(), textField23.getText(), tmp,
                                textField21.getText(), Integer.parseInt(textField22.getText()));

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    // Employee tmp_emp_2 = new Employee();
                    try {
                        Object[][] data_in = tmp_emp_2.getEmployeeById(Integer.parseInt(textField17.getText()));
                        if (data_in.length != 0)
                            update_nv_Table.setModel(new DefaultTableModel(data_in,
                                    new String[] { "ID", "Tên", "Số điện thoại", "Địa Chỉ", "Ngày sinh", "Giới tính",
                                            "Lương", "Loại nhân viên", "ID Cửa hàng" }));
                        else {
                            JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống các ô cần điền");
                }

            }
        });

        update_kh_Button.addKeyListener(new KeyAdapter() {
        });
        update_kh_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int id = Integer.parseInt(textField24.getText());
                String name = textField25.getText();
                String sdt = textField26.getText();
                String diachi = textField27.getText();
                Customer cst1 = new Customer();
                if (name != null && sdt != null && diachi != null) {
                    try {
                        cst1.updateCustommerByOptions(id, name, diachi, sdt);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        Object[][] data_in = cst1.getCustomerById(id);
                        if (data_in.length != 0)
                            update_nv_Table.setModel(new DefaultTableModel(data_in, new String[] { "ID khách hàng",
                                    "Địa chỉ", "Số điện thoại", "Họ và tên", "Id cửa hàng" }));
                        else {
                            JOptionPane.showMessageDialog(null, "khách hàng không tồn tại!");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

            }
        });

        update_order_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int id_order = Integer.parseInt(textField28.getText());
                int id_sp = Integer.parseInt(textField29.getText());
                int soluong = Integer.parseInt(textField30.getText());
                Order ord1 = new Order();
                try {
                    ord1.updateOrderByOptions(id_order, id_sp, soluong);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    Object[][] data_in = ord1.getOrderByOrderID(id_order);
                    if (data_in.length != 0)
                        update_nv_Table.setModel(new DefaultTableModel(data_in, new String[] { "ID Order",
                                "ID sản phẩm", "Số lượng sản phẩm", "Ngày xuất order", "ID bill", "Tổng tiền" }));
                    else {
                        JOptionPane.showMessageDialog(null, "Order không tồn tại!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        create_OrderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Customer ord1 = new Customer();
                if (!textField11.getText().equals("")) {
                    sanphamcanorder.setVisible(true);
                    soluongsanpham.setVisible(true);
                    execute_Button.setVisible(true);
                    textField32.setVisible(true);
                    textField33.setVisible(true);
                    try {

                        ord1.callOrder(textArea1, textField32);
                    } catch (ParseException throwables) {
                        throwables.printStackTrace();
                        System.out.println("lỗi");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không được để trống ô số điện thoại!");
                }

            }
        });
        newOrderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cl.show(MidPanel, "Card7");
            }
        });
        execute_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Customer cst2 = new Customer();

                try {
                    int idnv = log_overall.getIdlogin();
                    int id_kh = cst2.getCustomerBySDTReturnName(textField11.getText());
                    cst2.callOrder_p2(textArea1, textField32, textField33, idnv, id_kh);
                    JOptionPane.showMessageDialog(null, "Thêm order thành công!");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                System.exit(0);

            }
        });
        reg_back_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cl.show(MidPanel, "Card1");
            }
        });
    }

    public static void main(String[] args) throws IOException, SQLException {
        JFrame frame = new MainForm("My frame");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
