import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatientHomePage extends JFrame implements ActionListener{

    JLabel BgImgLabel;
    Font f,f1,f2;
    public String patID2;
    public int login_id2;
    public String username2;

    PatientHomePage(String patName, String patID, int login_id, String username){

        this.setTitle("Patient Home Page");
        // this.setLocation(200,140);//pc
        this.setLocation(15,40); //lap Dimension
        this.setSize(1500,730);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patID2 = patID;
        login_id2 = login_id;
        username2 = username;

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("patHome.jpg"));
        Image im = img.getImage().getScaledInstance(1500,730,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(im);
        
        BgImgLabel = new JLabel(img1);
        
        //SETTNIG UP FONT PROPERTIES
        f = new Font("Gadugi", Font.BOLD, 20);
        f1 = new Font("Lucida Fax", Font.BOLD, 35);
        f2 = new Font("MS UI Gothic",Font.BOLD,18);
        
        JMenuBar m1 = new JMenuBar();
        
        JMenu doctor = new JMenu("Doctor");
        JMenuItem viewDoc = new JMenuItem("View Doctor");

        JMenu appointment = new JMenu("Appointment");
        JMenuItem addAppoint = new JMenuItem("Add Appointment");
        JMenuItem viewAppoint = new JMenuItem("View Appointment");

        JMenu admin = new JMenu("Hi, Patient("+patName+ ")");
        JMenuItem myProfile = new JMenuItem("My Profile");
        JMenuItem changePasswd = new JMenuItem("Change Password");

        JMenu Logout = new JMenu("Logout"); 
        JMenuItem LogoutItem = new JMenuItem("Logout");

        //Adding JMENUITEMS according to their corresponding JMENU
        doctor.add(viewDoc);
        appointment.add(addAppoint);
        appointment.add(viewAppoint);
        admin.add(myProfile);
        admin.add(changePasswd);
        Logout.add(LogoutItem);

        //FONT FOR JMENU
        doctor.setFont(f);
        appointment.setFont(f);
        admin.setFont(f);
        Logout.setFont(f);

        //SETTING FONT FOR MENU ITEMS
        viewDoc.setFont(f2);
        addAppoint.setFont(f2); 
        viewAppoint.setFont(f2);
        myProfile.setFont(f2);
        changePasswd.setFont(f2);
        LogoutItem.setFont(f);

        //SETTING COLOR         
        m1.setBackground(Color.BLACK); // MENUBAR
        
        // MENU
        doctor.setForeground(Color.WHITE);
        appointment.setForeground(Color.WHITE);
        admin.setForeground(Color.WHITE);
        Logout.setForeground(Color.RED);

        //MENU ITEMS
        addAppoint.setBackground(Color.BLACK);
        myProfile.setBackground(Color.BLACK);
        LogoutItem.setBackground(Color.BLACK);

        addAppoint.setForeground(Color.YELLOW);
        myProfile.setForeground(Color.YELLOW);
        LogoutItem.setForeground(Color.RED);

        viewDoc.setBackground(Color.WHITE);
        viewAppoint.setBackground(Color.WHITE);
        changePasswd.setBackground(Color.WHITE);

        viewDoc.setForeground(Color.BLUE); 
        viewAppoint.setForeground(Color.BLUE); 
        changePasswd.setForeground(Color.BLUE);        

        m1.add(doctor);
        m1.add(appointment);
        m1.add(admin);
        m1.add(Logout);
        
        // SETTING ACTIOPN LISTENERS FOR MENU ITEMS
        viewDoc.addActionListener(this);
        addAppoint.addActionListener(this); 
        viewAppoint.addActionListener(this);
        myProfile.addActionListener(this);
        changePasswd.addActionListener(this);
        LogoutItem.addActionListener(this);

        this.setJMenuBar(m1);
        this.add(BgImgLabel); //BG image
        this.setVisible(true);
    
    } // CONSTRUCTOR 

    public void actionPerformed(ActionEvent e){
        
        String command = e.getActionCommand();
        
        if(command.equals("View Doctor")){
            new View_Doctor(login_id2);
        }

        else if(command.equals("Add Appointment")){
            new Add_Appointment(username2,login_id2);
        }
        
        else if(command.equals("View Appointment")){
            new View_Appointment(username2,login_id2);
        }

        else if(command.equals("My Profile")){
            new CheckMyProfile(patID2,login_id2);
        }

        else if(command.equals("Change Password")){
            new Change_pass(patID2,login_id2);
        }

        else if(command.equals("Logout")){
            int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout ?","Confirm Logout",JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION)
            {
                this.setVisible(false);
                new Index();    
            }
        }

    } // ACTION
    
} // CLASS