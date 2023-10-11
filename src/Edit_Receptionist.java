import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Edit_Receptionist extends JFrame implements ActionListener{

    JLabel backgroundImageLabel, headLine, nameLabel, passLabel, addressLabel, emailLabel, fatherNameLabel, genderLabel, joiningdatLabel, qualificationLabel, unameLabel, dobLabel, phoneLabel, cityLabel, bloodgrpLabel, ageLabel;

    JTextField nameField,userNamField,addressField,phoneField,emailField,cityField,ageField,qualificationField,fatherField;

    JPasswordField passwordField;

    JButton updateButton, cancelButton;

    JRadioButton maleRadioButton,femaleRadioButton;

    ButtonGroup buttonGroup;

    JDateChooser dobChooser,joinChooser;

    JComboBox<String> bloodGrpComboBox;

    Edit_Receptionist(String username)
    {

        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q1 = "Select * from receptionist where username='" + username + "'";
            ResultSet rest0 = obj.stm.executeQuery(q1);

            if(rest0.next())
            {
                this.setSize(900,650);
                this.setLayout(null);
                this.setTitle("Update receptionist");
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setResizable(false);

                ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
                this.setIconImage(appIcon.getImage());

                ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("addRec.jpg"));
                Image i1 = img.getImage().getScaledInstance(900, 650, Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i1);

                //BACKGROUND IMAGE LABEL
                backgroundImageLabel = new JLabel();
                backgroundImageLabel.setBounds(0, 0, 900, 650);
                backgroundImageLabel.setLayout(null);
                backgroundImageLabel.setIcon(img1);

                //HEADLINE LABEL
                headLine = new JLabel("Add Receptionist Details");
                headLine.setBounds(240,40,500,50);
                headLine.setFont(new Font("Impact", Font.BOLD, 40));
                headLine.setForeground(Color.BLACK);
                backgroundImageLabel.add(headLine);   
                
                //NAME LABEL
                nameLabel = new JLabel("Name");
                nameLabel.setBounds(50,150,150,30);
                nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                nameLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(nameLabel);    
                
                //USER NAME LABEL
                unameLabel = new JLabel("Username");
                unameLabel.setBounds(500,150,150,30);
                unameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                unameLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(unameLabel);

                //PASSWORD LABEL
                passLabel = new JLabel("Password");
                passLabel.setBounds(50, 200, 150, 30);
                passLabel.setFont(new Font("Arial", Font.BOLD, 20));
                passLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(passLabel);

                //EMAIL LABEL
                emailLabel = new JLabel("Email ID");
                emailLabel.setBounds(500, 200, 150, 30);
                emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
                emailLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(emailLabel);

                //FATHER NAME LABEL
                fatherNameLabel = new JLabel("Father's Name");
                fatherNameLabel.setBounds(50, 250, 150, 30);
                fatherNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                fatherNameLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(fatherNameLabel);

                //PHONE LABEL
                phoneLabel = new JLabel("Phone");
                phoneLabel.setBounds(500, 250, 150, 30);
                phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));
                phoneLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(phoneLabel);

                //QUALIFICATION LABEL
                qualificationLabel = new JLabel("Qaulification");
                qualificationLabel.setBounds(50, 300, 150, 30);
                qualificationLabel.setFont(new Font("Arial", Font.BOLD, 20));
                qualificationLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(qualificationLabel);

                //CITY LABEL
                cityLabel = new JLabel("City");
                cityLabel.setBounds(500, 300, 150, 30);
                cityLabel.setFont(new Font("Arial", Font.BOLD, 20));
                cityLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(cityLabel);

                //GENDER lABEL
                genderLabel = new JLabel("Gender");
                genderLabel.setBounds(50, 350, 150, 30);
                genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
                genderLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(genderLabel);

                //BLOOD GRP LABEL
                bloodgrpLabel = new JLabel("Blood Group");
                bloodgrpLabel.setBounds(500, 350, 150, 30);
                bloodgrpLabel.setFont(new Font("Arial", Font.BOLD, 20));
                bloodgrpLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(bloodgrpLabel);

                String[] bloodGroups = {"A+","A-","B+","B-", "AB+","AB-","O+","O-"};
                bloodGrpComboBox = new JComboBox<>(bloodGroups);
                bloodGrpComboBox.setBounds(650, 350, 150, 30);
                backgroundImageLabel.add(bloodGrpComboBox);

                //JOINING DATE LABEL
                joiningdatLabel = new JLabel("Joining Date");
                joiningdatLabel.setBounds(50, 400, 150, 30);
                joiningdatLabel.setFont(new Font("Arial", Font.BOLD, 20));
                joiningdatLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(joiningdatLabel);

                joinChooser = new JDateChooser();
                joinChooser.setBounds(200,400,150,30);
                backgroundImageLabel.add(joinChooser); 

                //AGE LABEL
                ageLabel = new JLabel("Age");
                ageLabel.setBounds(500, 400, 150, 30);
                ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
                ageLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(ageLabel);

                //ADDRESS LABEL
                addressLabel = new JLabel("Address");
                addressLabel.setBounds(50, 450, 150, 30);
                addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
                addressLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(addressLabel);

                //DOB LABEL
                dobLabel = new JLabel("Date of Birth");
                dobLabel.setBounds(500, 450, 150, 30);
                dobLabel.setFont(new Font("Arial", Font.BOLD, 20));
                dobLabel.setForeground(Color.BLACK);
                backgroundImageLabel.add(dobLabel);

                dobChooser = new JDateChooser();
                dobChooser.setBounds(650, 450, 150, 30);
                backgroundImageLabel.add(dobChooser);

                try 
                {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q2 = "select * from receptionist where username='"+username+"'";
                    ResultSet rest = obj1.stm.executeQuery(q2);

                    while(rest.next())
                    {
                        //TEXTFIELD FOR NAME
                        nameField = new JTextField();
                        nameField.setBounds(200,150,150,30);
                        nameField.setText(rest.getString("name"));
                        backgroundImageLabel.add(nameField);

                        //TEXTFIELD FOR USERNAME
                        userNamField = new JTextField();
                        userNamField.setBounds(650,150,150,30);
                        userNamField.setText(rest.getString("username"));
                        userNamField.setEditable(false);
                        backgroundImageLabel.add(userNamField);

                        //PASSWORD FIELD
                        passwordField = new JPasswordField();
                        passwordField.setBounds(200,200,150,30);
                        passwordField.setText(rest.getString("password"));
                        passwordField.setEditable(false);
                        backgroundImageLabel.add(passwordField);

                        //EMAIL FIELD
                        emailField = new JTextField();
                        emailField.setBounds(650,200,150,30);
                        emailField.setText(rest.getString("email"));
                        backgroundImageLabel.add(emailField);

                        //FATHER NAME FIELD
                        fatherField = new JTextField();
                        fatherField.setBounds(200,250,150,30);
                        fatherField.setText(rest.getString("father_name"));    
                        backgroundImageLabel.add(fatherField);

                        //PHONEFIELD
                        phoneField = new JTextField();
                        phoneField.setBounds(650,250,150,30);
                        phoneField.setText(rest.getString("phone"));
                        backgroundImageLabel.add(phoneField);

                        //QUALIFICATION FIELD
                        qualificationField = new JTextField();
                        qualificationField.setBounds(200,300,150,30);
                        qualificationField.setText(rest.getString("qualification"));
                        backgroundImageLabel.add(qualificationField);

                        //CITY FIELD
                        cityField = new JTextField();
                        cityField.setBounds(650,300,150,30);  
                        cityField.setText(rest.getString("city"));    
                        backgroundImageLabel.add(cityField);  

                        //GENDER FIELD
                        maleRadioButton = new JRadioButton("Male");
                        maleRadioButton.setBounds(200, 350, 100, 30);
                        maleRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
                        maleRadioButton.setForeground(Color.BLACK);
                        maleRadioButton.setOpaque(false);
                        maleRadioButton.setFocusable(false);
                        backgroundImageLabel.add(maleRadioButton);
                        
                        femaleRadioButton = new JRadioButton("Female");
                        femaleRadioButton.setBounds(280, 350, 100, 30);
                        femaleRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
                        femaleRadioButton.setForeground(Color.BLACK);
                        femaleRadioButton.setOpaque(false);
                        femaleRadioButton.setFocusable(false);
                        backgroundImageLabel.add(femaleRadioButton);
                
                        buttonGroup = new ButtonGroup();
                        buttonGroup.add(maleRadioButton);
                        buttonGroup.add(femaleRadioButton);

                        //RETRIEVING GENDER 
                        String gender = rest.getString("gender");
                        if ("Male".equals(gender)) 
                        {
                            maleRadioButton.setSelected(true);
                        } 
                        else if ("Female".equals(gender)) {
                            femaleRadioButton.setSelected(true);
                        }

                        //BLOOD GROUP COMBO
                        bloodGrpComboBox.setSelectedItem(rest.getString("blood"));

                        //JOINING DATE FIELD
                        String joinStr = rest.getString("joining_date");

                        // Convert the VARCHAR DOB to a Date object using SimpleDateFormat
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yy");
                        Date joinDate = dateFormat1.parse(joinStr);
        
                        // Set the Date object in the JDateChooser
                        joinChooser.setDate(joinDate);

                        //AGE FIELD
                        ageField = new JTextField();
                        ageField.setBounds(650,400,150,30);
                        ageField.setText(rest.getString("age"));
                        backgroundImageLabel.add(ageField);

                        //ADDRESS FIELD
                        addressField = new JTextField();
                        addressField.setBounds(200,450,150,30);
                        addressField.setText(rest.getString("address"));
                        backgroundImageLabel.add(addressField);

                        //DOB FIELD
                        String dobStr = rest.getString("dob");
                        // Convert the VARCHAR DOB to a Date object using SimpleDateFormat
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date dobDate = dateFormat.parse(dobStr);
        
                        // Set the Date object in the JDateChooser
                        dobChooser.setDate(dobDate);            
                    }        
                }
        
                catch(Exception ex1)
                {
                    ex1.printStackTrace();
                }
                updateButton = new JButton("Update");
                updateButton.setBackground(Color.BLACK);
                updateButton.setForeground(Color.WHITE);
                updateButton.setFocusable(false);
                updateButton.setBounds(250,530,150,40);
                updateButton.addActionListener(this);

                cancelButton = new JButton("Cancel");
                cancelButton.setBackground(Color.RED);
                cancelButton.setForeground(Color.WHITE);
                cancelButton.setFocusable(false);
                cancelButton.setBounds(450,530,150,40);
                cancelButton.addActionListener(this);

                backgroundImageLabel.add(updateButton);
                backgroundImageLabel.add(cancelButton);

                this.setLocationRelativeTo(null);
                this.add(backgroundImageLabel);
                this.setVisible(true);                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Record not found, Please enter the correct Patient Username !");
                this.setVisible(false);    
            }
        }
        catch(Exception ex2)
        {
            ex2.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == updateButton){
            
            String name = nameField.getText();
            String username = userNamField.getText();
            String email = emailField.getText();
            String father = fatherField.getText();
            String phone = phoneField.getText();
            String qualification = qualificationField.getText();
            String city = cityField.getText();
            String gender = "";

            if(maleRadioButton.isSelected())
            {
                gender = "Male";
            }

            else if(femaleRadioButton.isSelected())
            {
                gender = "Female";
            }

            String blood = (String) bloodGrpComboBox.getSelectedItem();
            //JOIN
            java.util.Date selectedDate1 = joinChooser.getDate();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            String join = dateFormat1.format(selectedDate1);
        
            String age = ageField.getText();
            String address = addressField.getText();
            //DOB
            java.util.Date selectedDate = dobChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dob = dateFormat.format(selectedDate);

            try
            {
                ConnectionClass obj = new ConnectionClass();
                
                String q3 = "UPDATE receptionist SET name='" +name+ "', email='" + email + "', father_name= '" +father+ "', phone='" +phone+ "', qualification='" + qualification + "', city='" + city+ "',gender='" + gender + "',blood='" + blood + "',joining_date='" + join + "',age='" + age +"',address='" + address + "',dob='" + dob +"' where username='" + username + "'";

                obj.stm.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "Details Successfully Updated");
                this.setVisible(false);

            }
            catch(Exception ex3)
            {
                ex3.printStackTrace();
            }
        }

        if(e.getSource() == cancelButton){

            this.setVisible(false);
        }
    }
}
