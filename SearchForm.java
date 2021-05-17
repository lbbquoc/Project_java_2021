package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SearchForm extends JFrame{

    private JPanel MainPanel;
    private JPanel MenuPanel;
    private JPanel MidPanel;
    private JPanel EndPanel;
    private JLabel MenuPanel_UD;
    private JLabel MenuPanel_DV;
    private JLabel MenuPanel_TK;
    private JLabel MenuPanel_CC;
    private JPanel MidPanel_Image;
    private JLabel Home;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel LoginPanel;
    private JLabel Search;
    private JLabel Fix;
    private JLabel logout;
    private JLabel exit;
    private JTabbedPane tabbedPane1;
    private JPanel employeeSearch;
    private JPanel customerSearch;
    private JPanel billSearch;
    private JPanel orderSearch;
    private JPanel productSearch;
    private JComboBox productComboBox;
    private JButton button1;
    private JPanel searchPanel;
    private JTextArea welcomText;
    private JButton findButton;
    private JTable datafrProduct;
    private JTextField idnvInput;
    private JTextField namenvInput;
    private JTextField paynvInput;
    private JTable datafrEmployee;
    private JTextField textField2;
    private JButton tìmKiếmButton;
    private JTextField textField3;
    private JButton tìmKiếmButton1;
    private JTextField textField4;
    private JButton tìmKiémButton;
    public JPanel getPanel(){
        return MidPanel;
    }
    public SearchForm(String title) throws IOException {

        super(title);
        this.setContentPane(MainPanel);
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }



    public static void main(String[] args) throws IOException {
        JFrame frame = new SearchForm("My frame");
//        JFrame frame = new JFrame();
//        frame.add()
        frame.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
