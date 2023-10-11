import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Index extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JButton docButton,patientButton,recepButton,adminButton;
    public int loginID; 

    Index(){

        this.setTitle("Index Page"); 
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setSize(800, 570);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel();
        l1.setBounds(0, 0, 800, 570);
        l1.setLayout(null);

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("index.jpg")); // Null point exception got fuixed after not mentioning src before icons
        Image i1 = img.getImage().getScaledInstance(800, 570, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        
        //TITLE
        l2 = new JLabel("Central City Hospital");
        l2.setBounds(220, 140, 500, 40);
        l2.setFont(new Font("Impact", Font.BOLD, 35));
        l2.setForeground(new Color(0,0,139));
        l1.add(l2);
        
        //Headline
        l3 = new JLabel("Provide best quality healthcare for you");
        l3.setBounds(220, 180, 500, 20);
        l3.setFont(new Font("Arial", Font.ITALIC, 16));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        //DOCTOR BUTTON
        docButton = new JButton("Doctor");
        docButton.setBounds(220 ,290 , 150, 40);
        docButton.addActionListener(this);
        docButton.setFocusable(false);
        docButton.setBackground(Color.BLACK);
        docButton.setForeground(Color.WHITE);

        //PATIENT BUTTON
        patientButton = new JButton("Patient");
        patientButton.setBounds(390 ,290 , 150, 40);
        patientButton.addActionListener(this);
        patientButton.setFocusable(false);
        patientButton.setBackground(Color.BLACK);
        patientButton.setForeground(Color.WHITE);
        
        //RECEPTIONIST BUTTON
        recepButton = new JButton("Receptionist");
        recepButton.setBounds(220 ,350 , 150, 40);
        recepButton.addActionListener(this);
        recepButton.setFocusable(false);
        recepButton.setBackground(Color.BLACK);
        recepButton.setForeground(Color.WHITE);

        //ADMIN BUTTON
        adminButton = new JButton("Admin");
        adminButton.setBounds(390 ,350 , 150, 40);
        adminButton.addActionListener(this);
        adminButton.setFocusable(false);
        adminButton.setBackground(Color.BLACK);
        adminButton.setForeground(Color.WHITE);
    
        l1.add(docButton);
        l1.add(patientButton);
        l1.add(recepButton);
        l1.add(adminButton);

        this.add(l1);
        this.setVisible(true);

    } //Index Constructor

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == docButton){
            loginID = 1;
            this.setVisible(false);
            new LoginPage(loginID);
        }
        else if(e.getSource() == patientButton){
            loginID = 2;
            this.setVisible(false);
            new LoginPage(loginID);
        }
        else if(e.getSource() == recepButton){
            loginID = 3;
            this.setVisible(false);
            new LoginPage(loginID);

        }
        else if(e.getSource() == adminButton){
            loginID = 4;
            this.setVisible(false);
            new LoginPage(loginID);
        }
    } // action method

    public static void main(String[] args) {

        new Index();

    } // main 

}// class
