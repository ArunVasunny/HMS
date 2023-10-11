import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_Patient  extends JFrame implements ActionListener{

    String x [] = {"Name","Username","Email-ID","Father's Name","Phone","Marital Status","City","Gender","Blood","Age","DOB","Disease","Address"};

    String y [] [] = new String [20][13];
    JButton deleteButton, editButton;
    int i = 0, j = 0;
    JLabel l1,l2;
    JTextField textField;
    JPanel p1,p2,p3;
    Font f = new Font("MS UI Gothic", Font.BOLD,15);
    Font f1 = new Font("Lucida Fax",Font.BOLD,25);
    JScrollPane scrl;
    JTable table;
    String q;

    View_Patient(String pat_username, int login_id){

        this.setTitle("Patient Information");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(15,200);
        this.setSize(1500, 400);

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());
        
        try {
            ConnectionClass obj = new ConnectionClass();
            if(login_id == 2)
            {
                q = "SELECT * FROM patient where username='"+ pat_username+"'";
            }
            else
            {
                q = "SELECT * FROM patient";
            }

            ResultSet rs = obj.stm.executeQuery(q);
            while(rs.next())
            {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("username");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("father_name");
                y[i][j++] = rs.getString("phone");
                y[i][j++] = rs.getString("marital_status");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("gender");
                y[i][j++] = rs.getString("blood");
                y[i][j++] = rs.getString("age");
                y[i][j++] = rs.getString("dob");
                y[i][j++] = rs.getString("disease");
                y[i][j++] = rs.getString("address");

                i++; // this is for next row
                j=0; // this one is for column Reset

            }
            
            table = new JTable(y,x);
            table.setFont(f);
            table.setBackground(new Color(11,11,69));
            table.setForeground(Color.WHITE);
            table.setFillsViewportHeight(true); // Fill the table height

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
        l1 = new JLabel("Patient Username");
        l2 = new JLabel("Delete or Edit Any Patient ?");
        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setForeground(Color.WHITE);
        l1.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setFont(f1);

        deleteButton = new JButton("Delete Patient");
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setFocusable(false);
        deleteButton.setForeground(Color.RED);

        editButton = new JButton("Edit Patient Record");
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
        this.add(scrl);
        this.setVisible(true);

    }
    
    public void actionPerformed(ActionEvent e) {

        String username = textField.getText();
        
        if(e.getSource() == deleteButton)
        {
            if(username.isEmpty())
            {   
                JOptionPane.showMessageDialog(null,"Please Fill the Patient Username !");
            }
            else
            {
                try {
                
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 = "Select * from patient where username='" + username + "'";
                    ResultSet rs =  obj1.stm.executeQuery(q1);

                    if(rs.next())
                    {
                        try 
                        {
                            ConnectionClass obj = new ConnectionClass();
                            String q = "DELETE from patient where username='" + username + "'";
                            obj.stm.executeUpdate(q);
                            JOptionPane.showMessageDialog(null, "Patient '" + username + "' has been deleted successfully!");
                            this.setVisible(false);    
                        } 
                        catch (Exception ex) 
                        {
                            ex.printStackTrace();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Patient '" + username + "' not found in the database.");
                
                    }
                }

             
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        
        if(e.getSource() == editButton)
        {
            if(username.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Fill the Patient Username !");            
            }
            else
            {
                this.setVisible(false);
                new Edit_Patient(username);
            }
        }
    }
}
