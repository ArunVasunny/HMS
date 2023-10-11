import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class Add_Patient extends JFrame implements ActionListener{
    
    JLabel backgroundImageLabel, headLine, nameLabel, unameLabel, passLabel, emailLabel, fatherNameLabel, phoneLabel, maritalLabel, cityLabel, genderLabel, bloodgrpLabel, diseaseLabel, ageLabel, addressLabel, dobLabel;

    JTextField nameField, userNamField, emailField, fatherNameField, phoneField, cityField, diseaseField, ageField, addressField;

    JPasswordField passwordField;

    JButton submitButton, cancelButton;

    JRadioButton maleRadioButton , femaleRadioButton, singleRadioButton, marriedRadioButton;

    ButtonGroup buttonGroup;

    JDateChooser dobChooser;

    JComboBox<String> bloodGrpComboBox;

    public int login_id2;

    Add_Patient(int login_id){

        if(login_id == 2)
        {
            this.setTitle("Patient Sign Up");
        }
        else
        {
            this.setTitle("Patient Form");
        }
        this.setSize(900,650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        login_id2 = login_id;

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("addPat.png"));
        Image i1 = img.getImage().getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setBounds(0, 0, 900, 650);
        backgroundImageLabel.setLayout(null);
        backgroundImageLabel.setIcon(img1);

        //HEADLINE LABEL
        if(login_id == 2)
        {
            headLine = new JLabel("Patient Enrollment");
        }
        else
        {
            headLine = new JLabel("Add Patient Details");
        }
        headLine.setBounds(290,40,500,50);
        headLine.setFont(new Font("Impact", Font.BOLD, 40));
        headLine.setForeground(Color.BLACK);
        backgroundImageLabel.add(headLine);
       
        //NAME LABEL
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,150,150,30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(nameLabel);
       
        //TEXTFIELD FOR NAME
        nameField = new JTextField();
        nameField.setBounds(200,150,150,30);
        backgroundImageLabel.add(nameField);

        //USER NAME LABEL
        unameLabel = new JLabel("Username");
        unameLabel.setBounds(500,150,150,30);
        unameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        unameLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(unameLabel);
       
        //USERNAME FIELD
        userNamField = new JTextField();
        userNamField.setBounds(650,150,150,30);
        backgroundImageLabel.add(userNamField);

        //PASSWORD LABEL
        passLabel = new JLabel("Password");
        passLabel.setBounds(50, 200, 150, 30);
        passLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(passLabel);

        //PASSWORD FIELD
        passwordField = new JPasswordField();
        passwordField.setBounds(200,200,150,30);
        backgroundImageLabel.add(passwordField);

        //EMAIL LABEL
        emailLabel = new JLabel("Email ID");
        emailLabel.setBounds(500, 200, 150, 30);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
        emailLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(emailLabel);

        //EMAIL FIELD
        emailField = new JTextField();
        emailField.setBounds(650,200,150,30);
        backgroundImageLabel.add(emailField);

        //FATHER NAME LABEL
        fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setBounds(50, 250, 150, 30);
        fatherNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        fatherNameLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(fatherNameLabel);

        //FATHER NAME FIELD
        fatherNameField = new JTextField();
        fatherNameField.setBounds(200,250,150,30);    
        backgroundImageLabel.add(fatherNameField);   
        
        //PHONE LABEL
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(500, 250, 150, 30);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));
        phoneLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(phoneLabel);

        //PHONEFIELD
        phoneField = new JTextField();
        phoneField.setBounds(650,250,150,30);
        backgroundImageLabel.add(phoneField);

        //MARITAL LABEL
        maritalLabel = new JLabel("Marital Status");
        maritalLabel.setBounds(50, 300, 150, 30);
        maritalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        maritalLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(maritalLabel);

        //MARITAL FIELD
        singleRadioButton = new JRadioButton("Single");
        singleRadioButton.setBounds(200, 300, 100, 30);
        singleRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        singleRadioButton.setForeground(Color.BLACK);
        singleRadioButton.setOpaque(false);
        singleRadioButton.setFocusable(false);
        backgroundImageLabel.add(singleRadioButton);
        
        marriedRadioButton = new JRadioButton("Married");
        marriedRadioButton.setBounds(280, 300, 100, 30);
        marriedRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        marriedRadioButton.setForeground(Color.BLACK);
        marriedRadioButton.setOpaque(false);
        marriedRadioButton.setFocusable(false);
        backgroundImageLabel.add(marriedRadioButton);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(singleRadioButton);
        buttonGroup.add(marriedRadioButton);

        //CITY LABEL
        cityLabel = new JLabel("City");
        cityLabel.setBounds(500, 300, 150, 30);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cityLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(cityLabel);

        //CITY FIELD
        cityField = new JTextField();
        cityField.setBounds(650,300,150,30);      
        backgroundImageLabel.add(cityField);   

        //GENDER LABEL and RADIOBUTTONS
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 350, 150, 30);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        genderLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(genderLabel);

        //GENDER RADIOBUTTONS
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

        //BLOOD GROUP LABEL
        bloodgrpLabel = new JLabel("Blood Group");
        bloodgrpLabel.setBounds(500, 350, 150, 30);
        bloodgrpLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bloodgrpLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(bloodgrpLabel);

        //BLOOD GROUP COMBOBOX
        String[] bloodGroups = {"Select Blood Group","A+","A-","B+","B-", "AB+","AB-","O+","O-"};
        bloodGrpComboBox = new JComboBox<>(bloodGroups);
        bloodGrpComboBox.setBounds(650, 350, 150, 30);
        backgroundImageLabel.add(bloodGrpComboBox);

        //Disease LABEL
        diseaseLabel = new JLabel("Disease");
        diseaseLabel.setBounds(50, 400, 150, 30);
        diseaseLabel.setFont(new Font("Arial", Font.BOLD, 20));
        diseaseLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(diseaseLabel);

        //Disease FIELD
        diseaseField = new JTextField();
        diseaseField.setBounds(200,400,150,30);
        backgroundImageLabel.add(diseaseField);

        //AGE LABEL
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(500, 400, 150, 30);
        ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ageLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(ageLabel);

        //AGE FIELD
        ageField = new JTextField();
        ageField.setBounds(650,400,150,30);
        backgroundImageLabel.add(ageField);

        //ADDRESS LABEL
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 450, 150, 30);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addressLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(addressLabel);

        //ADDRESS FIELD
        addressField = new JTextField();
        addressField.setBounds(200,450,150,30);
        backgroundImageLabel.add(addressField);
    
        //DOB LABEL
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(500, 450, 150, 30);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dobLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(dobLabel);

        //DOB CHOOSER
        dobChooser = new JDateChooser();
        dobChooser.setBounds(650,450,150,30);
        backgroundImageLabel.add(dobChooser);

        //BUTTONS
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.setBounds(275,530,150,40);
        submitButton.addActionListener(this);
        backgroundImageLabel.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.setBounds(475,530,150,40);
        cancelButton.addActionListener(this);
        backgroundImageLabel.add(cancelButton);
        
        this.add(backgroundImageLabel);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == submitButton){

            String name = nameField.getText();
            String username = userNamField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            String father = fatherNameField.getText();
            String phone = phoneField.getText();
            String marital = "";
            if(singleRadioButton.isSelected())
            {
                marital = "Single";
            }

            else if(marriedRadioButton.isSelected())
            {
                marital = "Married";
            }

            String city = cityField.getText();
            
            String gender = "";
            //FETCHING GENDER FROM RADIOBUTTONS
            if(maleRadioButton.isSelected())
            {
                gender = "Male";
            }

            else if(femaleRadioButton.isSelected())
            {
                gender = "Female";
            }

            String blood = (String) bloodGrpComboBox.getSelectedItem();
            String disease = diseaseField.getText();
            String age = ageField.getText();
            String address = addressField.getText();
            //DOB 
            java.util.Date selectedDate = dobChooser.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(null, "Please Fill in all Fields", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without inserting data
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
            String dob = dateFormat.format(selectedDate);

            Random r = new Random();
            String pat_id = ""+Math.abs(r.nextInt() % 100000);

            if(name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty() || father.isEmpty() || phone.isEmpty() || marital.isEmpty() || city.isEmpty() || gender.isEmpty() || blood.isEmpty() || disease.isEmpty() || age.isEmpty() || address.isEmpty() || dob.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without inserting data
            }

            try 
            {
                ConnectionClass obj = new ConnectionClass();  
                String q = "INSERT INTO Patient VALUES ('" + pat_id + "', '" + name + "', '" + username + "', '" + password + "', '" + email + "', '" + father + "', '" + phone + "', '" + marital + "', '" + city + "', '" + gender + "', '" + blood + "', '" + age + "', '" + dob + "', '" + disease + "', '" + address + "')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);

                if(login_id2 == 2)
                {
                    new Index();
                }

            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        if (e.getSource() == cancelButton) {
            this.setVisible(false);

            if(login_id2 == 2)
            {
                new Index();
            }
        }
    }
}
