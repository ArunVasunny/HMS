import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

public class Add_Doctor extends JFrame implements ActionListener{
    
    JLabel backgroundLabel, headLine, nameLabel, passLabel, addressLabel, emaiLabel, genderLabel, joiningdatLabel, specializationLabel, unameLabel, dobLabel, phoneLabel, cityLabel, bloodgrpLabel, ageLabel, clinicLabel;
    JTextField nameField,userNamField,addressField,phoneField,emailField,cityField,ageField,specialField,clinicField;
    JPasswordField passwordField;
    JButton submitButton, cancelButton;
    JRadioButton maleRadioButton,femaleRadioButton;
    ButtonGroup buttonGroup;
    JDateChooser dobChooser,joinChooser;
    JComboBox <String> bloodGrpComboBox;

    Add_Doctor(){
   
        this.setSize(900,650);
        this.setLayout(null);
        this.setTitle("Add Doctor");
        this.setResizable(false);

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("addDoc.png"));
        Image i1 = img.getImage().getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);

        //BACKGROUND IMAGE LABEL
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 900, 650);
        backgroundLabel.setLayout(null);
        backgroundLabel.setIcon(img1);
        
        //HEADLINE LABEL
        headLine = new JLabel("Add Doctor Details");
        headLine.setBounds(290,40,500,50);
        headLine.setFont(new Font("Impact", Font.BOLD, 40));
        headLine.setForeground(Color.BLACK);
        
        //NAME LABEL
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,150,150,30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(Color.BLACK);
        
        //TEXTFIELD FOR NAME
        nameField = new JTextField();
        nameField.setBounds(200,150,150,30);

        //USER NAME LABEL
        unameLabel = new JLabel("Username");
        unameLabel.setBounds(500,150,150,30);
        unameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        unameLabel.setForeground(Color.BLACK);
        
        //USERNAME FIELD
        userNamField = new JTextField();
        userNamField.setBounds(650,150,150,30);

        //PASSWORD LABEL
        passLabel = new JLabel("Password");
        passLabel.setBounds(50, 200, 150, 30);
        passLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passLabel.setForeground(Color.BLACK);

        //PASSWORD FIELD
        passwordField = new JPasswordField();
        passwordField.setBounds(200,200,150,30);

        //DATE OF BIRTH LABEL
        dobLabel = new JLabel("Date Of Birth");
        dobLabel.setBounds(500, 200, 150, 30);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dobLabel.setForeground(Color.BLACK);

        //DOB CHOOSER
        dobChooser = new JDateChooser();
        dobChooser.setBounds(650,200,150,30);      

        //ADDRESS LABEL
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 250, 150, 30);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addressLabel.setForeground(Color.BLACK);

        //ADDRESS FIELD
        addressField = new JTextField();
        addressField.setBounds(200,250,150,30);        

        //PHONE LABEL
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(500, 250, 150, 30);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));
        phoneLabel.setForeground(Color.BLACK);
        
        //PHONEFIELD
        phoneField = new JTextField();
        phoneField.setBounds(650,250,150,30);        

        //EMAIL LABEL
        emaiLabel = new JLabel("Email ID");
        emaiLabel.setBounds(50, 300, 150, 30);
        emaiLabel.setFont(new Font("Arial", Font.BOLD, 20));
        emaiLabel.setForeground(Color.BLACK);

        //EMAIL FIELD
        emailField = new JTextField();
        emailField.setBounds(200,300,150,30);

        //CITY LABEL
        cityLabel = new JLabel("City");
        cityLabel.setBounds(500, 300, 150, 30);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cityLabel.setForeground(Color.BLACK);

        //CITY FIELD
        cityField = new JTextField();
        cityField.setBounds(650,300,150,30);        

        //GENDER LABEL
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 350, 150, 30);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        genderLabel.setForeground(Color.BLACK);

        //GENDER RADIOBUTTON
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(200, 350, 100, 30);
        maleRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        maleRadioButton.setForeground(Color.BLACK);
        maleRadioButton.setOpaque(false);
        maleRadioButton.setFocusable(false);
        
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(280, 350, 100, 30);
        femaleRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        femaleRadioButton.setForeground(Color.BLACK);
        femaleRadioButton.setOpaque(false);
        femaleRadioButton.setFocusable(false);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(maleRadioButton);
        buttonGroup.add(femaleRadioButton);

        //BLOOD GROUP LABEL
        bloodgrpLabel = new JLabel("Blood Group");
        bloodgrpLabel.setBounds(500, 350, 150, 30);
        bloodgrpLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bloodgrpLabel.setForeground(Color.BLACK);

        //BLOOD GROUP COMBOBOX
        String[] bloodGroups = {"Select Blood Group","A+","A-","B+","B-", "AB+","AB-","O+","O-"};
        bloodGrpComboBox = new JComboBox<>(bloodGroups);
        bloodGrpComboBox.setBounds(650, 350, 150, 30);

        //JOINING DATE LABEL
        joiningdatLabel = new JLabel("Joining Date");
        joiningdatLabel.setBounds(50, 400, 150, 30);
        joiningdatLabel.setFont(new Font("Arial", Font.BOLD, 20));
        joiningdatLabel.setForeground(Color.BLACK);

        //JOIN CHOOSER
        joinChooser = new JDateChooser();
        joinChooser.setBounds(200,400,150,30);

        //AGE LABEL
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(500, 400, 150, 30);
        ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ageLabel.setForeground(Color.BLACK);

        //AGE FIELD
        ageField = new JTextField();
        ageField.setBounds(650,400,150,30);

        //SPECIALIZATION LABEL
        specializationLabel = new JLabel("Specialization");
        specializationLabel.setBounds(50, 450, 150, 30);
        specializationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        specializationLabel.setForeground(Color.BLACK);

        //SPECIALIZATION FIELD
        specialField = new JTextField();
        specialField.setBounds(200,450,150,30);
    
        //CLINIC LABEL
        clinicLabel = new JLabel("Clinic Number");
        clinicLabel.setBounds(500, 450, 150, 30);
        clinicLabel.setFont(new Font("Arial", Font.BOLD, 20));
        clinicLabel.setForeground(Color.BLACK);

        //CLINIC FIELD
        clinicField = new JTextField();
        clinicField.setBounds(650,450,150,30);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.setBounds(275,530,150,40);
        submitButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.setBounds(475,530,150,40);
        cancelButton.addActionListener(this);

        //ADDING TO BGLABEL
        backgroundLabel.add(headLine);
        
        backgroundLabel.add(nameLabel);
        backgroundLabel.add(nameField);

        backgroundLabel.add(unameLabel);
        backgroundLabel.add(userNamField);

        backgroundLabel.add(passLabel);
        backgroundLabel.add(passwordField);

        backgroundLabel.add(dobLabel);
        backgroundLabel.add(dobChooser);

        backgroundLabel.add(addressLabel);
        backgroundLabel.add(addressField);

        backgroundLabel.add(phoneLabel);
        backgroundLabel.add(phoneField);

        backgroundLabel.add(emaiLabel);
        backgroundLabel.add(emailField);

        backgroundLabel.add(cityLabel);
        backgroundLabel.add(cityField);
        
        backgroundLabel.add(genderLabel);
        backgroundLabel.add(maleRadioButton);
        backgroundLabel.add(femaleRadioButton);
        
        backgroundLabel.add(bloodgrpLabel);
        backgroundLabel.add(bloodGrpComboBox);
        
        backgroundLabel.add(joiningdatLabel);
        backgroundLabel.add(joinChooser);
        
        backgroundLabel.add(ageLabel);
        backgroundLabel.add(ageField);
        
        backgroundLabel.add(specializationLabel);
        backgroundLabel.add(specialField);
        
        backgroundLabel.add(clinicLabel);
        backgroundLabel.add(clinicField);

        backgroundLabel.add(submitButton);
        backgroundLabel.add(cancelButton);

        this.setLocationRelativeTo(null);
        this.add(backgroundLabel);
        this.setVisible(true);
    
    } // CONSTRUCTOR 


    public void actionPerformed(ActionEvent e){

        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String username = userNamField.getText();
            String password = passwordField.getText(); // Get password as a String
            //DOB 
            java.util.Date selectedDate = dobChooser.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(null, "Please Fill in all Fields", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without inserting data
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dob = dateFormat.format(selectedDate);
            
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
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
            String age = ageField.getText();
            String clinic = clinicField.getText();
            //JOIN
            java.util.Date selectedDate1 = joinChooser.getDate();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yy");
            String jod = dateFormat1.format(selectedDate1);

            String special = specialField.getText();
            String available = "Yes";

            Random r = new Random();
            String doc_id = String.valueOf(Math.abs(r.nextInt() % 100000)); // Generate a unique Doctor ID

            if (name.isEmpty() || username.isEmpty() || password.isEmpty() || dob.isEmpty() ||
            address.isEmpty() || phone.isEmpty() || email.isEmpty() || city.isEmpty() ||
            gender.isEmpty() || blood.isEmpty() || age.isEmpty() || clinic.isEmpty() ||
            jod.isEmpty() || special.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without inserting data
            }

            try {
                ConnectionClass obj = new ConnectionClass();
                // We need to create a table named 'doctor' before inserting data.
                String q = "insert into doctor values('" + doc_id + "', '" + name + "', '" + username + "', '" + password + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + city + "', '" + gender + "', '" + blood + "', '" + age + "', '" + clinic + "', '" + jod + "', '" + special + "', '" + available + "')";
                
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted", "Success" ,JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } 
            catch (Exception ex) {
                ex.printStackTrace(); // Print the exception for debugging purposes
                // JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == cancelButton) {
            this.setVisible(false);
        }

    } // ACTION 

} // CLASS

