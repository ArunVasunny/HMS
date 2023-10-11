import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_Doctor extends JFrame implements ActionListener{
    
    //COlUMN DISPLAYING THE BELOW INFO

    String x [] = {"Name","Username","DOB","Address","Phone","Email ID","City","Gender","Blood Group","Age","Clinic No","Joining Date","Specialization"};

    String y [] [] = new String [30] [14]; //ROW AND COLUMN FOR DISPLAY OF DATA

    JButton deleteButton, editButton;

    int i = 0, j = 0;
    JTable table;
    JLabel l1,l2;
    JTextField textField ;
    JPanel p1,p2,p3;
    Font f = new Font("MS UI Gothic", Font.BOLD,15);
    Font f1 = new Font("Lucida Fax",Font.BOLD,25);
    JScrollPane scrl;

    View_Doctor(int login_id){

        this.setTitle("Doctor Information");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(15,200);
        this.setSize(1500, 400);

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());
        
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM doctor";

            if (login_id != 4) {
                x = new String[]{"Name", "Phone", "Email ID", "City", "Gender", "Age", "Room No", "Specialization"};
            }
            
            ResultSet rs = obj.stm.executeQuery(q);
            
            while (rs.next()) {
                y[i][j++] = rs.getString("name");

                if (login_id  == 4) 
                {
                    y[i][j++] = rs.getString("username");
                    y[i][j++] = rs.getString("dob");
                    y[i][j++] = rs.getString("address");
                }
                
                y[i][j++] = rs.getString("phone");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("gender");

                if (login_id == 4) 
                {
                    y[i][j++] = rs.getString("blood");
                }
                
                y[i][j++] = rs.getString("age");
                y[i][j++] = rs.getString("clinic_no");

                if(login_id == 4)
                {
                    y[i][j++] = rs.getString("joining_date");
                }
                y[i][j++] = rs.getString("specialization");
                    // y[i][j++] = rs.getString("availability");
        
                i++;
                j = 0;
            }
            
            table = new JTable(y,x);
            table.setFont(f);
            table.setBackground(new Color(11,11,69));
            table.setForeground(Color.WHITE);

            // Add column headers
            JTableHeader header = table.getTableHeader();
            header.setFont(f);
            header.setBackground(Color.BLACK);
            header.setForeground(Color.WHITE);

        } //TRY END

        catch (Exception ex) {
            ex.printStackTrace();
        } // CATCH END

        scrl = new JScrollPane(table); //FOR SCROLLIKNG WHEN THE TABLE IS RESIZED
        
        if(login_id == 4)
        {
            l1 = new JLabel("Doctor Username");
            l2 = new JLabel("Delete or Edit Any Doctor ?");
            l2.setHorizontalAlignment(JLabel.CENTER);
            
            l1.setForeground(Color.WHITE);
            l1.setFont(f1);
            l2.setForeground(Color.WHITE);
            l2.setFont(f1);

            deleteButton = new JButton("Delete Doctor");
            deleteButton.setBackground(Color.BLACK);
            deleteButton.setFocusable(false);
            deleteButton.setForeground(Color.RED);

            editButton = new JButton("Edit Doctor Record");
            editButton.setBackground(Color.BLACK);
            editButton.setFocusable(false);
            editButton.setForeground(Color.WHITE);

            deleteButton.addActionListener(this);
            editButton.addActionListener(this);
        
            textField = new JTextField();
            textField.setFont(f);

            p1 = new JPanel();
            p1.setLayout(new GridLayout(1,1,10,10));
            p1.setBackground(new Color(11,11,69));
            p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1,4,10,10));
            p2.setBackground(new Color(11,11,69));
            p2.add(l1);
            p2.add(textField);
            p2.add(deleteButton);
            p2.add(editButton);

            p3 = new JPanel();
            p3.setLayout(new GridLayout(2, 1,10,10));
            p3.setBackground(new Color(11,11,69));
            p3.add(p1);
            p3.add(p2);

            this.add(p3,"South");
        }

        this.add(scrl);
        this.setVisible(true);

    } // CONSTRUCTOR END

    public void actionPerformed(ActionEvent e){
        
        String username = textField.getText();

        if(e.getSource() == deleteButton)
        {
            if(username.isEmpty())
            {   
                JOptionPane.showMessageDialog(null,"Please Fill the Doctor Username !");
            }
            else
            {
                try {
                
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 = "Select * from doctor where username='" + username + "'";
                    ResultSet rs =  obj1.stm.executeQuery(q1);

                    if(rs.next())
                    {
                        try 
                        {
                            ConnectionClass obj = new ConnectionClass();
                            String q = "DELETE from doctor where username='" + username + "'";
                            obj.stm.executeUpdate(q);
                            JOptionPane.showMessageDialog(null, "Doctor '" + username + "' has been deleted successfully!");

                            // String q2 = "update appointment set appointment_status='Cancel' where doctor_username='"+username+"' and appointment_status='Open'";
                            // obj.stm.executeUpdate(q2);
                            this.setVisible(false);    
                        } 
                        catch (Exception ex) 
                        {
                            ex.printStackTrace();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Doctor '" + username + "' not found in the database.");
                
                    }
                }

             
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } // IF - DELETE BUTTON

        if(e.getSource() == editButton)
        {
            if(username.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Fill the Doctor Username !");
            }
            else
            {
                setVisible(false);
                new Edit_Doctor(username);
            }
        } 
    } // ACTION END
} // CLASS
