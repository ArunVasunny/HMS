import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class Edit_Doctor extends JFrame implements ActionListener{

    JLabel backgroundLabel, headLine, nameLabel, passLabel, addressLabel, emaiLabel, genderLabel, joiningdatLabel, specializationLabel, unameLabel, dobLabel, phoneLabel, cityLabel, bloodgrpLabel, ageLabel, clinicLabel;

    JTextField nameField,userNamField,dobField,addressField,phoneField,emailField,cityField,ageField,specialField,clinicField;

    JPasswordField passwordField;
    
    JButton updateButton, cancelButton;

    JRadioButton maleRadioButton,femaleRadioButton;

    ButtonGroup buttonGroup;

    JDateChooser dobChooser,joinChooser;

    JComboBox<String> bloodGrpComboBox;

    Edit_Doctor(String username)
    {
        try {

            ConnectionClass obj = new ConnectionClass();
            String q1 = "Select * from doctor where username='"+username+"'";
            ResultSet rest0 = obj.stm.executeQuery(q1);

            if(rest0.next())
            {
                this.setSize(900,650);
                this.setLayout(null);
                this.setTitle("Update Doctor");
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                headLine = new JLabel("Edit Doctor Details");
                headLine.setBounds(290,40,500,50);
                headLine.setFont(new Font("Impact", Font.BOLD, 40));
                headLine.setForeground(Color.BLACK);
        
                //NAME LABEL
                nameLabel = new JLabel("Name");
                nameLabel.setBounds(50,150,150,30);
                nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                nameLabel.setForeground(Color.BLACK);

                //USER NAME LABEL
                unameLabel = new JLabel("Username");
                unameLabel.setBounds(450,150,150,30);
                unameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                unameLabel.setForeground(Color.BLACK);

	            //PASS LABEL
                passLabel = new JLabel("Password");
                passLabel.setBounds(50, 200, 150, 30);
                passLabel.setFont(new Font("Arial", Font.BOLD, 20));
                passLabel.setForeground(Color.BLACK);

	            //DOB LABEL
                dobLabel = new JLabel("Date Of Birth");
                dobLabel.setBounds(450, 200, 150, 30);
                dobLabel.setFont(new Font("Arial", Font.BOLD, 20));
                dobLabel.setForeground(Color.BLACK);

                dobChooser = new JDateChooser();
                dobChooser.setBounds(600, 200, 150, 30);
                backgroundLabel.add(dobChooser);

                //ADDRESS LABEL
                addressLabel = new JLabel("Address");
                addressLabel.setBounds(50, 250, 150, 30);
                addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
                addressLabel.setForeground(Color.BLACK);

                //PHONE LABEL
                phoneLabel = new JLabel("Phone");
                phoneLabel.setBounds(450, 250, 150, 30);
                phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));
                phoneLabel.setForeground(Color.BLACK);

       	        //EMAIL LABEL
                emaiLabel = new JLabel("Email ID");
                emaiLabel.setBounds(50, 300, 150, 30);
                emaiLabel.setFont(new Font("Arial", Font.BOLD, 20));
                emaiLabel.setForeground(Color.BLACK);

       	        //CITY LABEL
                cityLabel = new JLabel("City");
                cityLabel.setBounds(450, 300, 150, 30);
                cityLabel.setFont(new Font("Arial", Font.BOLD, 20));
                cityLabel.setForeground(Color.BLACK);

       	        //GENDER LABEL
                genderLabel = new JLabel("Gender");
                genderLabel.setBounds(50, 350, 150, 30);
                genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
                genderLabel.setForeground(Color.BLACK);

                //BLOOD GROUP LABEL
                bloodgrpLabel = new JLabel("Blood Group");
                bloodgrpLabel.setBounds(450, 350, 150, 30);
                bloodgrpLabel.setFont(new Font("Arial", Font.BOLD, 20));
                bloodgrpLabel.setForeground(Color.BLACK);

                String[] bloodGroups = {"A+","A-","B+","B-", "AB+","AB-","O+","O-"};
                bloodGrpComboBox = new JComboBox<>(bloodGroups);
                bloodGrpComboBox.setBounds(600, 350, 150, 30);
                backgroundLabel.add(bloodGrpComboBox);

                //JOINING DATE LABEL
                joiningdatLabel = new JLabel("Joining Date");
                joiningdatLabel.setBounds(50, 400, 150, 30);
                joiningdatLabel.setFont(new Font("Arial", Font.BOLD, 20));
                joiningdatLabel.setForeground(Color.BLACK);

                joinChooser = new JDateChooser();
                joinChooser.setBounds(200,400,150,30);
                backgroundLabel.add(joinChooser);                

	            //AGE LABEL
                ageLabel = new JLabel("Age");
                ageLabel.setBounds(450, 400, 150, 30);
                ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
                ageLabel.setForeground(Color.BLACK);

                //SPECIALIZATION LABEL
                specializationLabel = new JLabel("Specialization");
                specializationLabel.setBounds(50, 450, 150, 30);
                specializationLabel.setFont(new Font("Arial", Font.BOLD, 20));
                specializationLabel.setForeground(Color.BLACK);

                //CLINIC LABEL
                clinicLabel = new JLabel("Clinic Number");
                clinicLabel.setBounds(450, 450, 150, 30);
                clinicLabel.setFont(new Font("Arial", Font.BOLD, 20));
                clinicLabel.setForeground(Color.BLACK);
                       
                backgroundLabel.add(headLine);
                backgroundLabel.add(nameLabel);
                backgroundLabel.add(unameLabel);
                backgroundLabel.add(passLabel);
                backgroundLabel.add(dobLabel);
                backgroundLabel.add(addressLabel);
                backgroundLabel.add(phoneLabel);
                backgroundLabel.add(emaiLabel);
                backgroundLabel.add(cityLabel);
                backgroundLabel.add(genderLabel);
                backgroundLabel.add(bloodgrpLabel);
                backgroundLabel.add(joiningdatLabel);
                backgroundLabel.add(ageLabel);
                backgroundLabel.add(specializationLabel);
                backgroundLabel.add(clinicLabel);

                try {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q2 = "select * from doctor where username='"+username+"'";
                    ResultSet rest = obj1.stm.executeQuery(q2);

                    while(rest.next())
                    {
                        //TEXTFIELD FOR NAME
                        nameField = new JTextField();
                        nameField.setBounds(200,150,150,30);
                        nameField.setText(rest.getString("name"));
                        backgroundLabel.add(nameField);


                        //USERNAME FIELD
                        userNamField = new JTextField();
                        userNamField.setBounds(600,150,150,30);
                        userNamField.setText(rest.getString("username"));
                        userNamField.setEditable(false);
                        backgroundLabel.add(userNamField);

                        //PASSWORD FIELD
                        passwordField = new JPasswordField();
                        passwordField.setBounds(200,200,150,30);
                        passwordField.setText(rest.getString("password"));
                        passwordField.setEditable(false);
                        backgroundLabel.add(passwordField);

                        //DOB CHOOSER
                        String dobStr = rest.getString("dob");

                        // Convert the VARCHAR DOB to a Date object using SimpleDateFormat
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date dobDate = dateFormat.parse(dobStr);
        
                        // Set the Date object in the JDateChooser
                        dobChooser.setDate(dobDate);   

                        //ADDRESS FIELD
                        addressField = new JTextField();
                        addressField.setBounds(200,250,150,30);
                        addressField.setText(rest.getString("address"));
                        backgroundLabel.add(addressField);

                        //PHONEFIELD
                        phoneField = new JTextField();
                        phoneField.setBounds(600,250,150,30);        
                        phoneField.setText(rest.getString("phone"));
                        backgroundLabel.add(phoneField);

                        //EMAIL FIELD
                        emailField = new JTextField();
                        emailField.setBounds(200,300,150,30);
                        emailField.setText(rest.getString("email"));
                        backgroundLabel.add(emailField);

                        //CITY FIELD
                        cityField = new JTextField();
                        cityField.setBounds(600,300,150,30);        
                        cityField.setText(rest.getString("city"));
                        backgroundLabel.add(cityField);
 
                        //GENDER FIELD
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

                        //RETRIEVING GENDER 
                        String gender = rest.getString("gender");
                        if ("Male".equals(gender)) 
                        {
                            maleRadioButton.setSelected(true);
                        } 
                        else if ("Female".equals(gender)) {
                            femaleRadioButton.setSelected(true);
                        }

                        //BLOOD GROUP FIELD
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
                        ageField.setBounds(600,400,150,30);
                        ageField.setText(rest.getString("age"));
                        backgroundLabel.add(ageField);

                        //SPECIALIZATION FIELD
                        specialField = new JTextField();
                        specialField.setBounds(200,450,150,30);
                        specialField.setText(rest.getString("specialization"));
                        backgroundLabel.add(specialField);    

                        //CLINIC FIELD
                        clinicField = new JTextField();
                        clinicField.setBounds(600,450,150,30);
                        clinicField.setText(rest.getString("clinic_no"));
                        backgroundLabel.add(clinicField);                    

                    }
                }
                
                catch (Exception ex2) {
                    ex2.printStackTrace();
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

                backgroundLabel.add(updateButton);
                backgroundLabel.add(cancelButton);

                this.setLocationRelativeTo(null);
                this.add(backgroundLabel);
                this.setVisible(true);
            }

            else
            {
                JOptionPane.showMessageDialog(null,"Record not found, Please enter the correct Doctor Username !");
                this.setVisible(false);
            }
        } 
        catch (Exception ex1) {
        
            ex1.printStackTrace();

        }
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource() == updateButton) {
            String name = nameField.getText();
            String username = userNamField.getText();
            //DOB
            java.util.Date selectedDate = dobChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dob = dateFormat.format(selectedDate);

            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
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
            String age = ageField.getText();
            String clinic = clinicField.getText();
            //JOIN
            java.util.Date selectedDate1 = joinChooser.getDate();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            String jod = dateFormat1.format(selectedDate1);


            String special = specialField.getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                // We need to create a table named 'doctor' before inserting data.
                String q3 = "UPDATE doctor SET name='" + name + "', dob='" + dob + "', address='" + address + "', phone='" + phone + "', email='" + email + "', city='" + city + "', gender='" + gender +"', blood='" + blood + "', age='" + age + "', clinic_no='" + clinic + "', joining_date='" + jod + "', specialization='" + special + "' where username='" + username + "'";

                obj.stm.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "Details Successfully Updated");
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