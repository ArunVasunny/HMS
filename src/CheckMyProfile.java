import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CheckMyProfile extends JFrame implements ActionListener{

    JLabel backgroundLabel, headLine, myIdLabel, unameLabel, nameLabel, ageLabel, phoneLabel, cityLabel, emailLabel, genderLabel;

    JTextField myIdField, unameField, nameField, ageField, phoneField, cityField, emailField, genderField;

    JButton updateButton, cancelButton;

    Font f = new Font("Arial",Font.BOLD,20);
    Font f1 = new Font("Arial",Font.BOLD,16);

    public String adminID2;
    public int login_id2;
    String q1;
    ResultSet rest1;

    CheckMyProfile(String adminID, int login_id)
    {
        this.setSize(900,550);
        this.setLayout(null);
        this.setTitle("My Profile");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        adminID2 = adminID;
        login_id2 = login_id;

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("myProfile.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 550, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        
        //BACKGROUND IMAGE LABEL
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0,900,550);
        backgroundLabel.setLayout(null);
        backgroundLabel.setIcon(img1);

        //HEADLINE LABEL
        headLine = new JLabel("Edit My Details");
        headLine.setBounds(320,20,500,50);
        headLine.setFont(new Font("Impact", Font.BOLD, 40));
        headLine.setForeground(Color.WHITE);
        backgroundLabel.add(headLine);

        //MY ID LABEL AND FIELD
        myIdLabel = new JLabel("My ID");
        myIdLabel.setBounds(60,150,150,40);
        myIdLabel.setFont(f);
        myIdLabel.setForeground(Color.WHITE);
        backgroundLabel.add(myIdLabel);

        myIdField = new JTextField();
        myIdField.setBounds(200,150,150,30);
        myIdField.setFont(f1);
        myIdField.setEditable(false);
        backgroundLabel.add(myIdField);

        //USERNAME LABEL AND FIELD
        unameLabel = new JLabel("Username");
        unameLabel.setBounds(500,150,150,40);
        unameLabel.setFont(f);
        unameLabel.setForeground(Color.WHITE);
        backgroundLabel.add(unameLabel);

        unameField = new JTextField();
        unameField.setBounds(650,150,150,30);
        unameField.setFont(f1);
        unameField.setEditable(false);
        backgroundLabel.add(unameField);

        //NAME LABEL AND FIELD
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(60,215,150,40);
        nameLabel.setFont(f);
        nameLabel.setForeground(Color.WHITE);
        backgroundLabel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200,215,150,30);
        nameField.setFont(f1);
        nameField.setEditable(false);
        backgroundLabel.add(nameField);

        //AGE LABEL AND FIELD
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(500,215,150,40);
        ageLabel.setFont(f);
        ageLabel.setForeground(Color.WHITE);
        backgroundLabel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(650,215,150,30);
        ageField.setFont(f1);
        backgroundLabel.add(ageField);

        //PHONE LABEL AND FIELD
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(60,275,150,40);
        phoneLabel.setFont(f);
        phoneLabel.setForeground(Color.WHITE);
        backgroundLabel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200,275,150,30);
        phoneField.setFont(f1);
        backgroundLabel.add(phoneField);

        //CITY LABEL AND FIELD
        cityLabel = new JLabel("City");
        cityLabel.setBounds(500,275,150,40);
        cityLabel.setFont(f);
        cityLabel.setForeground(Color.WHITE);
        backgroundLabel.add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(650,275,150,30);
        cityField.setFont(f1);
        backgroundLabel.add(cityField);

        //EMAIL LABEL AND FIELD
        emailLabel = new JLabel("Email ID");
        emailLabel.setBounds(60,340,150,40);
        emailLabel.setFont(f);
        emailLabel.setForeground(Color.WHITE);
        backgroundLabel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200,340,150,30);
        emailField.setFont(f1);
        backgroundLabel.add(emailField);

        //GENDER LABEL AND FIELD
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(500,340,150,40);
        genderLabel.setFont(f);
        genderLabel.setForeground(Color.WHITE);
        backgroundLabel.add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(650,340,150,30);
        genderField.setFont(f1);
        genderField.setEditable(false);
        backgroundLabel.add(genderField);

        //Automatically retrieves data in their particular fields
        try 
        {
            ConnectionClass obj1 = new ConnectionClass();

            if(login_id2 == 1)
            {
                q1 = "Select * from doctor where doc_id='" +adminID2+ "'";
                rest1 = obj1.stm.executeQuery(q1);
            }

            else if(login_id2 == 2)
            {
                q1 = "Select * from patient where pat_id='" +adminID2+ "'";
                rest1 = obj1.stm.executeQuery(q1);
            }
            
            else if(login_id2 == 3)
            {
                q1 = "Select * from receptionist where res_id='" +adminID2+ "'";
                rest1 = obj1.stm.executeQuery(q1);
            }

            else if(login_id2 == 4)
            {
                q1 = "Select * from admin where admin_id='" +adminID2+ "'";
                rest1 = obj1.stm.executeQuery(q1);
            }

            while(rest1.next())
            {
                if(login_id2 == 1)
                {
                    myIdField.setText(rest1.getString("doc_id"));
                }

                else if(login_id2 == 2)
                {
                    myIdField.setText(rest1.getString("pat_id"));
                }
                
                else if(login_id2 == 3)
                {
                    myIdField.setText(rest1.getString("res_id"));
                }

                else if(login_id2 == 4)
                {
                    myIdField.setText(rest1.getString("admin_id"));
                }

                unameField.setText(rest1.getString("username"));
                nameField.setText(rest1.getString("name"));
                ageField.setText(rest1.getString("age"));
                phoneField.setText(rest1.getString("phone"));
                cityField.setText(rest1.getString("city"));
                emailField.setText(rest1.getString("email"));
                genderField.setText(rest1.getString("gender"));
            }
        }
        catch (Exception ex1) {
            ex1.printStackTrace();
        }

        updateButton = new JButton("Update");
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusable(false);
        updateButton.setBounds(265,425,150,40);
        updateButton.addActionListener(this);
        backgroundLabel.add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.setBounds(485,425,150,40);
        cancelButton.addActionListener(this);
        backgroundLabel.add(cancelButton);

        this.add(backgroundLabel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == updateButton)
        { 
            String Id = myIdField.getText();
            String username = unameField.getText(); 
            String age = ageField.getText();
            String phone = phoneField.getText();
            String city = cityField.getText();
            String email = emailField.getText();
            String q2; 

            try 
            {
                ConnectionClass obj2 = new ConnectionClass();
                
                if(login_id2 == 1)
                {
                    q2 = "UPDATE doctor SET age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' WHERE doc_id='" + Id + "' and username='"+username+"'";
                    obj2.stm.executeUpdate(q2);
                }

                else if(login_id2 == 2)
                {
                    q2 = "UPDATE patient SET age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' WHERE pat_id='" + Id + "' and username='"+username+"'";
                    obj2.stm.executeUpdate(q2);
                }

                else if(login_id2 == 3)
                {
                    q2 = "UPDATE receptionist SET age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' WHERE res_id='" + Id + "' and username='"+username+"'";
                    obj2.stm.executeUpdate(q2);
                }

                else if(login_id2 == 4)
                {
                    q2 = "UPDATE admin SET age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' WHERE admin_id='" + Id + "' and username='"+username+"'";
                    obj2.stm.executeUpdate(q2);
                }

                JOptionPane.showMessageDialog(null, "Details Successfully Updated", "Success" ,JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } 
            catch (Exception ex2) 
            {
                ex2.printStackTrace();
            }
        }

        if(e.getSource() == cancelButton)
        {
            this.setVisible(false);
        }
    }
}

