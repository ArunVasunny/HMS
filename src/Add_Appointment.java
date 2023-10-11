import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.text.SimpleDateFormat;

public class Add_Appointment extends JFrame implements ActionListener{

    JLabel backgroundImageLabel, headlineLabel, userNameLabel, nameLabel, emailLabel, fnameLabel, phoneLabel, maritalLabel, cityLabel, genderLabel, bloodLabel, ageLabel, dobLabel, diseaseLabel, checkDocAvailLabel, selectDocLabel, appointDateLabel, appointTimeLabel;

    JButton checkDocButton, bookAppointButton, backButton;

    JTextField nameField ,emailField, fnameField, phoneField, maritalField, cityField, genderField, bloodField, ageField, dobField, diseaseField, appointDateField;

    Font f1;

    JDateChooser appChooser;

    public String username1;

    public int login_id;

    Choice ch1User,ch2Doc,ch3Time;

    Add_Appointment(String username2,int login_id2)

    {
        this.setTitle("Appointment Form");
        this.setSize(880,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        username1 = username2;
        login_id = login_id2;

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        // f1 = new Font("Impact",Font.BOLD,25);
        f1 = new Font("Arial",Font.BOLD,16);

        ch1User = new Choice();
        ch1User.add("Select");

        ch2Doc = new Choice();
        ch3Time = new Choice();
    
        ch3Time.add("10AM");
        ch3Time.add("11AM");
        ch3Time.add("12PM");
        ch3Time.add("1PM");
        ch3Time.add("2PM");
        ch3Time.add("3PM");
        ch3Time.add("4PM");
        ch3Time.add("5PM");
        ch3Time.add("6PM");

        try 
        {
            String q1;
            ConnectionClass obj1 = new ConnectionClass();
            if(login_id == 2)
            {
                q1 = "select username from patient WHERE username='" + username1+ "'";
                ResultSet rest1 = obj1.stm.executeQuery(q1);
                while(rest1.next())
                {
                    ch1User.add(rest1.getString("username"));
                }   
            }

            else
            {
                q1 = "select username from patient ";
                ResultSet rest1 = obj1.stm.executeQuery(q1);
                while(rest1.next())
                {
                    ch1User.add(rest1.getString("username"));
                }
            }

        } 
        catch (Exception ex1) 
        {
            ex1.printStackTrace();
        }
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("addApp.jpg"));
        Image i1 = img.getImage().getScaledInstance(880, 800, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setBounds(0, 0, 880, 800);
        backgroundImageLabel.setLayout(null);
        backgroundImageLabel.setIcon(img1);

        headlineLabel = new JLabel("Add Appointment");
        headlineLabel.setBounds(300, 15, 500, 50);
        headlineLabel.setFont(new Font("Impact", Font.BOLD, 40));
        headlineLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(headlineLabel);

        //USERNAME LABEL 
        userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(50, 100, 150, 30);
        userNameLabel.setFont(f1);
        userNameLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(userNameLabel);

        ch1User.setBounds(200,100,150,30);
        ch1User.setFont(f1);
        backgroundImageLabel.add(ch1User);

        //NAME LABEL and FIELD
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(500, 100, 150, 30);
        nameLabel.setFont(f1);
        nameLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(650, 100, 150, 30);
        nameField.setFont(f1);
        nameField.setForeground(Color.BLACK);
        nameField.setEditable(false);
        backgroundImageLabel.add(nameField);

        //EMAIL LABEL and FIELD
        emailLabel = new JLabel("Email ID");
        emailLabel.setBounds(50,150,150,30);
        emailLabel.setFont(f1);
        emailLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200,150,150,30);
        emailField.setFont(f1);
        emailField.setEditable(false);
        backgroundImageLabel.add(emailField);

        //FATHER NAME LABEL and FIELD
        fnameLabel = new JLabel("Father Name");
        fnameLabel.setBounds(500,150,150,30);
        fnameLabel.setFont(f1);
        fnameLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(fnameLabel);

        fnameField = new JTextField();
        fnameField.setBounds(650,150,150,30);
        fnameField.setFont(f1);
        fnameField.setEditable(false);
        backgroundImageLabel.add(fnameField);

        //PHONE LABEL and FIELD
        phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(50,200,150,30);
        phoneLabel.setFont(f1);
        phoneLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200,200,150,30);
        phoneField.setFont(f1);
        phoneField.setEditable(false);
        backgroundImageLabel.add(phoneField);

        //MARITAL LABEL AND FIELD
        maritalLabel = new JLabel("Marital Status");
        maritalLabel.setBounds(500,200,150,30);
        maritalLabel.setFont(f1);
        maritalLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(maritalLabel);

        maritalField = new JTextField();
        maritalField.setBounds(650,200,150,30);
        maritalField.setFont(f1);
        maritalField.setEditable(false);
        backgroundImageLabel.add(maritalField);

        //CITY LABEL AND FIELD
        cityLabel = new JLabel("City");
        cityLabel.setBounds(50,250,150,30);
        cityLabel.setFont(f1);
        cityLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(200,250,150,30);
        cityField.setFont(f1);
        cityField.setEditable(false);
        backgroundImageLabel.add(cityField);

        //GENDER LABEL AND FIELD
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(500,250,150,30);
        genderLabel.setFont(f1);
        genderLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(650,250,150,30);
        genderField.setFont(f1);
        genderField.setEditable(false);
        backgroundImageLabel.add(genderField);

        //BLOOD LABEL AND FIELD
        bloodLabel = new JLabel("Blood Group");
        bloodLabel.setBounds(50,300,150,30);
        bloodLabel.setFont(f1);
        bloodLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(bloodLabel);

        bloodField = new JTextField();
        bloodField.setBounds(200,300,150,30);
        bloodField.setFont(f1);
        bloodField.setEditable(false);
        backgroundImageLabel.add(bloodField);

        //AGE LABEL AND FIELD
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(500,300,150,30);
        ageLabel.setFont(f1);
        ageLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(650,300,150,30);
        ageField.setFont(f1);
        ageField.setEditable(false);
        backgroundImageLabel.add(ageField);

        //DOB LABEL AND FIELD
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(50,350,150,30);
        dobLabel.setFont(f1);
        dobLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(200,350,150,30);
        dobField.setFont(f1);
        dobField.setEditable(false);
        backgroundImageLabel.add(dobField);

        //DISEASE LABEL AND FIELD
        diseaseLabel = new JLabel("Disease");
        diseaseLabel.setBounds(500,350,150,30);
        diseaseLabel.setFont(f1);
        diseaseLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(diseaseLabel);

        diseaseField = new JTextField();
        diseaseField.setBounds(650,350,150,30);
        diseaseField.setFont(f1);
        backgroundImageLabel.add(diseaseField);

        //CHECK DOCTOR AVAILABILITY LABEL
        checkDocAvailLabel = new JLabel("Check Doctor Availability");
        checkDocAvailLabel.setBounds(50,405,250,30);
        checkDocAvailLabel.setFont(f1);
        checkDocAvailLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(checkDocAvailLabel);

        //SELECT DOCTOR LABEL
        selectDocLabel = new JLabel("Select Doctor");
        selectDocLabel.setBounds(50,455,150,30);
        selectDocLabel.setFont(f1);
        selectDocLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(selectDocLabel);

        ch2Doc.setBounds(360,460,150,30);
        ch2Doc.setFont(f1);
        backgroundImageLabel.add(ch2Doc);

        //APPOINTMENT DATE LABEL AND FIELD
        appointDateLabel = new JLabel("Appointment Date");
        appointDateLabel.setBounds(50,505,200,30);
        appointDateLabel.setFont(f1);
        appointDateLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(appointDateLabel);

        //DOB CHOOSER
        appChooser = new JDateChooser();
        appChooser.setBounds(360,505,150,30);
        appChooser.setFont(f1);
        backgroundImageLabel.add(appChooser);
        
        //APPOINTMENT TIME LABEL AND FIELD
        appointTimeLabel = new JLabel("Appointment Time");
        appointTimeLabel.setBounds(50,555,200,30);
        appointTimeLabel.setFont(f1);
        appointTimeLabel.setForeground(Color.BLACK);
        backgroundImageLabel.add(appointTimeLabel);

        ch3Time.setBounds(360,560,150,30);
        ch3Time.setFont(f1);
        backgroundImageLabel.add(ch3Time);

        checkDocButton = new JButton("Check");
        checkDocButton.setBounds(360,405,150,35);
        checkDocButton.setForeground(Color.white);
        checkDocButton.setBackground(Color.BLACK);
        checkDocButton.setBorder(BorderFactory.createEtchedBorder());
        checkDocButton.setFocusable(false);
        checkDocButton.addActionListener(this);
        backgroundImageLabel.add(checkDocButton);

        bookAppointButton = new JButton("Book Appoinment");
        bookAppointButton.setBounds(250,655,150,40);
        bookAppointButton.setForeground(Color.WHITE);
        bookAppointButton.setBackground(Color.BLUE);
        bookAppointButton.setBorder(BorderFactory.createEtchedBorder());
        bookAppointButton.setFocusable(false);
        bookAppointButton.addActionListener(this);
        backgroundImageLabel.add(bookAppointButton);

        backButton = new JButton("Back");
        backButton.setBounds(475,655,150,40);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.RED);
        backButton.setBorder(BorderFactory.createEtchedBorder());
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backgroundImageLabel.add(backButton);

        ch1User.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Your code for updating details
                    try {
                        ConnectionClass obj2 = new ConnectionClass();
                        String username = ch1User.getSelectedItem();
                        String q2 = "select * from patient where username='" + username + "'";
                        ResultSet rest2 = obj2.stm.executeQuery(q2);
                        while (rest2.next()) {
                            nameField.setText(rest2.getString("name"));
                            emailField.setText(rest2.getString("email"));
                            fnameField.setText(rest2.getString("father_name"));
                            phoneField.setText(rest2.getString("phone"));
                            maritalField.setText(rest2.getString("marital_status"));
                            cityField.setText(rest2.getString("city"));
                            genderField.setText(rest2.getString("gender"));
                            bloodField.setText(rest2.getString("blood"));
                            ageField.setText(rest2.getString("age"));
                            dobField.setText(rest2.getString("dob"));
                            diseaseField.setText(rest2.getString("disease"));
                        }
                    } catch (Exception ex2) {
                        ex2.printStackTrace();
                    }
                }
            }
        });

        this.add(backgroundImageLabel);
        this.setVisible(true);

    } // Constructor
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == checkDocButton)
        {
            
            ch2Doc.removeAll();
            try 
            {
                ConnectionClass obj3 = new ConnectionClass();
                String q3 = "Select * from doctor where specialization='" + diseaseField.getText()+ "' and availability='Yes'";
                ResultSet rest3 = obj3.stm.executeQuery(q3);
                while(rest3.next())
                {
                    ch2Doc.add(rest3.getString("username"));
                }
            }   
            catch (Exception ex3) {
                ex3.printStackTrace();
            }

        }

        if(e.getSource() == bookAppointButton)
        {
            String username = ch1User.getSelectedItem();
            String name = nameField.getText();
            String email = emailField.getText();
            String fname = fnameField.getText();
            String phone = phoneField.getText();
            String marital = maritalField.getText();
            String city = cityField.getText();
            String gender = genderField.getText();
            String blood = bloodField.getText();
            String age = ageField.getText();
            String dob = dobField.getText();
            String disease = diseaseField.getText();
            String doc = ch2Doc.getSelectedItem();
            java.util.Date selectedDate = appChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
            String appDate = dateFormat.format(selectedDate);


            String appTime = ch3Time.getSelectedItem();
            String appStatus = "Open";
            Random r = new Random();
            String app_id = ""+ Math.abs(r.nextInt() % 100000);

            if (username.isEmpty() || name.isEmpty() || email.isEmpty() || fname.isEmpty() || phone.isEmpty() ||
            marital.isEmpty() || city.isEmpty() || gender.isEmpty() || blood.isEmpty() || age.isEmpty() ||
            dob.isEmpty() || disease.isEmpty() || doc == null || appDate.isEmpty() || appTime.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please fill in all details.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else
            {
                try 
                {
                    ConnectionClass obj4 = new ConnectionClass();
                    String q4 = "insert into appointment(app_id ,pat_username, name, email,fname,phone,marital,city,gender,blood,age,dob,disease,doc_username,app_date,app_time,app_status) values('" +app_id+"','" +username+"', '" + name + "','" + email + "', '" + fname + "', '" + phone +"', '"+ marital +"', '" + city + "','" +gender + "', '" + blood + "', '" + age + "', '" + dob +"', '" + disease + "', '" + doc +"', '" + appDate + "','" + appTime + "','" + appStatus + "')";

                    obj4.stm.executeUpdate(q4);

                        JOptionPane.showMessageDialog(null,"Your Appointment has been Successfully Booked");
                        this.setVisible(false);

                } 
                catch (Exception ex4) 
                {
                    ex4.printStackTrace();
                }
            }   
        }

        if(e.getSource() == backButton){
            this.setVisible(false);
        }
    }
}
