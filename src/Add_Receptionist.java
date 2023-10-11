import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Add_Receptionist extends JFrame implements ActionListener{
    
    JLabel backgroundLabel, headLine, nameLabel, passLabel, addressLabel, emaiLabel, fatherLabel, genderLabel, joiningdatLabel, qualificationLabel, unameLabel, dobLabel, phoneLabel, cityLabel, bloodgrpLabel, ageLabel;

    JTextField nameField,userNamField,addressField,phoneField,emailField,cityField,ageField,qualificationField,fatherField;

    JPasswordField passwordField;
    
    JButton submitButton, cancelButton;

    JRadioButton maleRadioButton , femaleRadioButton;

    ButtonGroup buttonGroup;

    JDateChooser dobChooser, joinChooser;

    JComboBox<String> bloodGrpComboBox;
    

    Add_Receptionist()
    {
        this.setSize(900,650);
        this.setLayout(null);
        this.setTitle("Add Receptionist");
        this.setResizable(false);

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("addRec.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);

        //BACKGROUND IMAGE LABEL
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 900, 650);
        backgroundLabel.setLayout(null);
        backgroundLabel.setIcon(img1);
        
        //HEADLINE LABEL
        headLine = new JLabel("Add Receptionist Details");
        headLine.setBounds(240,40,500,50);
        headLine.setFont(new Font("Impact", Font.BOLD, 40));
        headLine.setForeground(Color.BLACK);
        backgroundLabel.add(headLine);
        
        //NAME LABEL
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,150,150,30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(Color.BLACK);
        backgroundLabel.add(nameLabel);
        
        //TEXTFIELD FOR NAME
        nameField = new JTextField();
        nameField.setBounds(200,150,150,30);
        backgroundLabel.add(nameField);

        //USER NAME LABEL
        unameLabel = new JLabel("Username");
        unameLabel.setBounds(500,150,150,30);
        unameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        unameLabel.setForeground(Color.BLACK);
        backgroundLabel.add(unameLabel);
        
        //USERNAME FIELD
        userNamField = new JTextField();
        userNamField.setBounds(650,150,150,30);
        backgroundLabel.add(userNamField);

        //PASSWORD LABEL
        passLabel = new JLabel("Password");
        passLabel.setBounds(50, 200, 150, 30);
        passLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passLabel.setForeground(Color.BLACK);
        backgroundLabel.add(passLabel);

        //PASSWORD FIELD
        passwordField = new JPasswordField();
        passwordField.setBounds(200,200,150,30);
        backgroundLabel.add(passwordField);

        //EMAIL - ID LABEL
        emaiLabel = new JLabel("Email ID");
        emaiLabel.setBounds(500, 200, 150, 30);
        emaiLabel.setFont(new Font("Arial", Font.BOLD, 20));
        emaiLabel.setForeground(Color.BLACK);
        backgroundLabel.add(emaiLabel);

        //EMAIL - ID FIELD
        emailField = new JTextField();
        emailField.setBounds(650,200,150,30);   
        backgroundLabel.add(emailField);     

        //FATHER NAME LABEL
        fatherLabel = new JLabel("Father Name");
        fatherLabel.setBounds(50, 250, 150, 30);
        fatherLabel.setFont(new Font("Arial", Font.BOLD, 20));
        fatherLabel.setForeground(Color.BLACK);
        backgroundLabel.add(fatherLabel);

        //FATHER NAME FIELD
        fatherField = new JTextField();
        fatherField.setBounds(200,250,150,30); 
        backgroundLabel.add(fatherField);      

        //PHONE LABEL
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(500, 250, 150, 30);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));
        phoneLabel.setForeground(Color.BLACK);
        backgroundLabel.add(phoneLabel);
        
        //PHONEFIELD
        phoneField = new JTextField();
        phoneField.setBounds(650,250,150,30);   
        backgroundLabel.add(phoneField);     

        //QUALIFICATIONS LABEL
        qualificationLabel = new JLabel("Qualification");
        qualificationLabel.setBounds(50, 300, 150, 30);
        qualificationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        qualificationLabel.setForeground(Color.BLACK);
        backgroundLabel.add(qualificationLabel);

        //QUALIFICATIONS FIELD
        qualificationField = new JTextField();
        qualificationField.setBounds(200,300,150,30);
        backgroundLabel.add(qualificationField);

        //CITY LABEL
        cityLabel = new JLabel("City");
        cityLabel.setBounds(500, 300, 150, 30);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cityLabel.setForeground(Color.BLACK);
        backgroundLabel.add(cityLabel);

        //CITY FIELD
        cityField = new JTextField();
        cityField.setBounds(650,300,150,30); 
        backgroundLabel.add(cityField);       

        //GENDER LABEL
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 350, 150, 30);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        genderLabel.setForeground(Color.BLACK);
        backgroundLabel.add(genderLabel);

        //GENDER RADIOBUTTONS
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(200, 350, 100, 30);
        maleRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        maleRadioButton.setForeground(Color.BLACK);
        maleRadioButton.setOpaque(false);
        maleRadioButton.setFocusable(false);
        backgroundLabel.add(maleRadioButton);
        
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(280, 350, 100, 30);
        femaleRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        femaleRadioButton.setForeground(Color.BLACK);
        femaleRadioButton.setOpaque(false);
        femaleRadioButton.setFocusable(false);
        backgroundLabel.add(femaleRadioButton);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(maleRadioButton);
        buttonGroup.add(femaleRadioButton);  

        //BLOOD GROUP LABEL
        bloodgrpLabel = new JLabel("Blood Group");
        bloodgrpLabel.setBounds(500, 350, 150, 30);
        bloodgrpLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bloodgrpLabel.setForeground(Color.BLACK);
        backgroundLabel.add(bloodgrpLabel);

        //BLOOD GROUP COMBOBOX
        String[] bloodGroups = {"Select Blood Group","A+","A-","B+","B-", "AB+","AB-","O+","O-"};
        bloodGrpComboBox = new JComboBox<>(bloodGroups);
        bloodGrpComboBox.setBounds(650, 350, 150, 30);
        backgroundLabel.add(bloodGrpComboBox);

        //JOINING DATE LABEL
        joiningdatLabel = new JLabel("Joining Date");
        joiningdatLabel.setBounds(50, 400, 150, 30);
        joiningdatLabel.setFont(new Font("Arial", Font.BOLD, 20));
        joiningdatLabel.setForeground(Color.BLACK);
        backgroundLabel.add(joiningdatLabel);

        //JOIN CHOOSER
        joinChooser = new JDateChooser();
        joinChooser.setBounds(200,400,150,30);
        backgroundLabel.add(joinChooser);

        //AGE LABEL
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(500, 400, 150, 30);
        ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ageLabel.setForeground(Color.BLACK);
        backgroundLabel.add(ageLabel);

        //AGE FIELD
        ageField = new JTextField();
        ageField.setBounds(650,400,150,30);
        backgroundLabel.add(ageField);

        //ADDRESS LABEL
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 450, 150, 30);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addressLabel.setForeground(Color.BLACK);
        backgroundLabel.add(addressLabel);

        //ADDRESS FIELD
        addressField = new JTextField();
        addressField.setBounds(200,450,150,30);
        backgroundLabel.add(addressField);
    
        //DOB LABEL
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(500, 450, 150, 30);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dobLabel.setForeground(Color.BLACK);
        backgroundLabel.add(dobLabel);

        //DOB CHOOSER
        dobChooser = new JDateChooser();
        dobChooser.setBounds(650,450,150,30);
        backgroundLabel.add(dobChooser);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.setBounds(275,530,150,40);
        submitButton.addActionListener(this);
        backgroundLabel.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.setBounds(475,530,150,40);
        cancelButton.addActionListener(this);
        backgroundLabel.add(cancelButton);

        this.setLocationRelativeTo(null);
        this.add(backgroundLabel);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){

        if (e.getSource() == submitButton) 
        {   
            String name = nameField.getText();
            String username = userNamField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            String fname = fatherField.getText();
            String phone = phoneField.getText();
            String qualification = qualificationField.getText();
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
            String address = addressField.getText();
            //DOB 
            java.util.Date selectedDate = dobChooser.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(null, "Please Fill in all Fields", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without inserting data
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
            String dob = dateFormat.format(selectedDate);

            //JOIN
            java.util.Date selectedDate1 = joinChooser.getDate();
            if (selectedDate1 == null) {
                JOptionPane.showMessageDialog(null, "Please Fill in all Fields", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without inserting data
            }
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            String joining = dateFormat1.format(selectedDate1);

            Random r = new Random();
            String rec_id = String.valueOf(Math.abs(r.nextInt() % 100000)); // Generate a unique Doctor ID

            if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty() ||
            fname.isEmpty() || phone.isEmpty() || qualification.isEmpty() || city.isEmpty() ||
            gender.isEmpty() || blood.isEmpty() || joining.isEmpty() || age.isEmpty() ||
            address.isEmpty() || dob.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method without inserting data
            }

            try {
                ConnectionClass obj = new ConnectionClass();
                // We need to create a table named 'doctor' before inserting data.
                String q = "insert into receptionist values('" + rec_id + "', '" + name + "', '" + username + "', '" + password + "', '" + email + "', '" + fname + "', '" + phone + "', '" + qualification + "', '" + city + "', '" + gender + "', '" + blood + "', '" + joining + "', '" + age + "', '" + address + "', '" + dob + "')";
                
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
}
