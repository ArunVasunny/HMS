import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
    JPanel mainPanel,panel1,panel2;
    JLabel imgLabel,textLabel,textLabel2,userLabel,passLabel;
    JTextField userName;
    JPasswordField password;
    JButton login, back ,signUp;
    public int login_id;

    LoginPage(int loginID){

        this.setSize(650, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login_id = loginID;

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        //STAKEHOLDER LOGIN DETAILS

        if(login_id == 1)
        {
            this.setTitle("Doctor Login Page");
        }
        else if(login_id == 2)
        {
            this.setTitle("Patient Login Page");
        }
        else if(login_id == 3)
        {
            this.setTitle("Receptionist Login Page");
        }
        else if(login_id == 4)
        {
            this.setTitle("Admin Login Page");
        }

        
        //This is the Image on Panel1 
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hospLogo.png"));
        Image i1 = img.getImage().getScaledInstance(128,128,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);

        //THIS IS FOR USERNAME LOGO
        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("user.png"));
        userLabel = new JLabel(img2);
        userLabel.setBounds(25,38,48,48);

        //THIS IS FOR PASSWORD LOGO
        ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("lock.png"));
        passLabel = new JLabel(img3);
        passLabel.setBounds(25,120,48,48);
   
        //MAIL PANEL IN WHICH WE WILL ADD 2 PANELS - PANEL1,PANEL2
        mainPanel = new JPanel(null);

        //LABEL FOR IMAGE
        imgLabel = new JLabel(img1);
        imgLabel.setBounds(100,60,128,128);

        //LABEL FOR TEXT
        textLabel = new JLabel("Central City");
        textLabel.setBounds(110,150,128,128);
        textLabel.setFont(new Font("Arial", Font.BOLD, 20));
        textLabel.setForeground(Color.BLACK);

        //LABEL FOR TEXT
        textLabel2 = new JLabel("Hospital");
        textLabel2.setBounds(125,180,128,128);
        textLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        textLabel2.setForeground(Color.BLACK);

        // PANEL1 DECLARATION AND OTHER PROPERTIES
        panel1 = new JPanel(null);
        panel1.setBounds(0, 0, 325, 350);
        panel1.add(imgLabel);
        panel1.add(textLabel);
        panel1.add(textLabel2);
        panel1.setBackground(new Color(65,105,225));
    
        //USERNAME FIELD IN PANEL2
        userName = new JTextField("Username");
        userName.setBounds(80,40,200,40);
        userName.setBorder(null);
        userName.setOpaque(false);
        userName.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        userName.setForeground(Color.BLACK);

        //PASSWORD FIELD IN PANEL2
        password = new JPasswordField("Password");
        password.setBounds(80,127,200,40);
        password.setBorder(null);
        password.setOpaque(false);
        password.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        password.setForeground(Color.BLACK);

        // LINE PLACED BELOW USERNAME FIELD
        JPanel linePanel = new JPanel();
        linePanel.setBounds(80, 75, 200, 2);
        linePanel.setBackground(Color.BLACK);

        //LINE PLACED BELOW PASSWORD FIELD
        JPanel linePanel2 = new JPanel();
        linePanel2.setBounds(80, 160, 200, 2);
        linePanel2.setBackground(Color.BLACK);

        //LOGIN BUTTON PLACED IN PANEL2
        login = new JButton("Login");
        login.setBounds(30,210,110,40);
        login.setFocusable(false);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        getRootPane().setDefaultButton(login);

        //BACK BUTTON and SIGN UP PLACED IN PANEL2
        if(login_id == 2)
        {
            signUp = new JButton("Sign Up");
            signUp.setBounds(170,210,110,40);
            signUp.setFocusable(false);
            signUp.setBackground(Color.BLACK);
            signUp.setForeground(Color.WHITE);
            signUp.addActionListener(this);
        }
        else
        {
            back = new JButton("Back");
            back.setBounds(170,210,110,40);
            back.setFocusable(false);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
        }

        // PANEL2 DECLARATION AND OTHER PROPERTIES
        panel2= new JPanel(null);
        panel2.setBounds(325, 0, 325, 350);
        panel2.setBackground(new Color(173,216,230));
        panel2.add(userLabel);
        panel2.add(userName);
        panel2.add(linePanel);
        panel2.add(passLabel);
        panel2.add(password);
        panel2.add(linePanel2);
        panel2.add(login);
        if(login_id == 2)
        {
            panel2.add(signUp);
        }
        else
        {
            panel2.add(back);
        }

        //THIS WILL CLEAR THE USERNAME FIELD WHEN WE CLICK ON IT
        userName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userName.setText("");
            }
        });

        //THIS WILL CLEAR THE PASSWORD FIELD WHEN WE CLICK ON IT        
        password.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                password.setText("");
            }
        });
        
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        this.add(mainPanel);  
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    
    } //Constructor

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == login){

            try {
                ConnectionClass obj = new ConnectionClass();
                String name = userName.getText();
                String pass = password.getText();
                ResultSet rs;

                if(login_id == 1)
                {
                    String q = "Select * from doctor where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    if(rs.next()){
                        
                        String docName = rs.getString("name");
                        String docID = rs.getString("doc_id");
                        String docUsername = rs.getString("username");

                        new DoctorHomePage(docName,docID,login_id,docUsername);
                        System.out.println("Login");
                        this.setVisible(false);

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !","Incorrect Credentials",JOptionPane.ERROR_MESSAGE);
                        this.setVisible(false);
                        this.setVisible(true);
                    }
                }

                else if(login_id == 2)
                {
                    String q = "Select * from patient where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    if(rs.next()){
                        
                        String patName = rs.getString("name");
                        String patID = rs.getString("pat_id");
                        String patUsername = rs.getString("username");

                        new PatientHomePage(patName,patID,login_id,patUsername);
                        System.out.println("Login");
                        this.setVisible(false);

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !","Incorrect Credentials",JOptionPane.ERROR_MESSAGE);
                        this.setVisible(false);
                        this.setVisible(true);
                    }
                }

                else if(login_id == 3)
                {
                    String q = "Select * from receptionist where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    if(rs.next()){
                        
                        String recepName = rs.getString("name");
                        String recepID = rs.getString("res_id");
                        String recepUsername = rs.getString("username");

                        new ReceptionistHomePage(recepName,recepID,login_id,recepUsername);
                        System.out.println("Login");
                        this.setVisible(false);

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !","Incorrect Credentials",JOptionPane.ERROR_MESSAGE);
                        this.setVisible(false);
                        this.setVisible(true);
                    }
                }

                else if(login_id == 4)
                {
                    String q = "Select * from admin where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    if(rs.next()){
                        
                        String adminName = rs.getString("name");
                        String adminID = rs.getString("admin_id");
                        String adminUsername = rs.getString("username");

                        new AdminNamePage(adminName,adminID,login_id,adminUsername);
                        this.setVisible(false);

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !","Incorrect Credentials",JOptionPane.ERROR_MESSAGE);
                        this.setVisible(false);
                        this.setVisible(true);
                    }
                }
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource() == signUp && login_id ==2)
        {
            this.setVisible(false);
            new Add_Patient(login_id);
        }

        if(e.getSource() == back)
        {
            this.setVisible(false);
            new Index();
        }
    }// Action
}//class

