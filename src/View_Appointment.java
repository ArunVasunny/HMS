import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_Appointment extends JFrame implements ActionListener{
    
    String x [] = {"App. Id","Username","Name","Email-ID","Father's Name","Phone","Marital Status","City","Gender","Blood Group","Age","DOB","Disease","Doctor","App. Date", "App. Time","App.Status"};

    String y [] [] = new String [50][17];
    JButton cancelButton, completeButton;
    int i = 0, j = 0;
    JLabel l1,l2;
    JTextField textField;
    JPanel p1,p2,p3;
    Font f = new Font("MS UI Gothic", Font.BOLD,15);
    Font f1 = new Font("Lucida Fax",Font.BOLD,25);
    JScrollPane scrl;
    JTable table;
    String q1;    

    View_Appointment(String username, int login_id)
    {
        this.setTitle("Appointment Information");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(15,200);
        this.setSize(1500, 400);

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        try {
            ConnectionClass obj1 = new ConnectionClass();

            if(login_id == 1)
            {
                q1 = "SELECT * FROM Appointment where doc_username='"+username+"'";
            }

            else if(login_id == 2)
            {
                q1 = "SELECT * FROM Appointment where pat_username='"+username+"'";                
            }

            else
            {
                q1 = "SELECT * FROM Appointment";
            }
            ResultSet rs = obj1.stm.executeQuery(q1);
            while(rs.next())
            {

                y[i][j++] = rs.getString("app_id");
                y[i][j++] = rs.getString("pat_username");
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("fname");
                y[i][j++] = rs.getString("phone");
                y[i][j++] = rs.getString("marital");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("gender");
                y[i][j++] = rs.getString("blood");
                y[i][j++] = rs.getString("age");
                y[i][j++] = rs.getString("dob");
                y[i][j++] = rs.getString("disease");
                y[i][j++] = rs.getString("doc_username");
                y[i][j++] = rs.getString("app_date");
                y[i][j++] = rs.getString("app_time");
                y[i][j++] = rs.getString("app_status");

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

        catch (Exception ex1) {
            ex1.printStackTrace();
        } // CATCH END

        scrl = new JScrollPane(table); //FOR SCROLLIKNG WHEN THE TABLE IS RESIZED
        l1 = new JLabel("Appointment ID");
        if(login_id == 2)
        {
            l2 = new JLabel("Cancel any Appointment ?");
        }
        else
        {
            l2 = new JLabel("Complete or Cancel any Appointment ?");
        }
        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setForeground(Color.WHITE);
        l1.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setFont(f1);

        cancelButton = new JButton("Cancel Appointment");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setFocusable(false);
        cancelButton.setForeground(Color.RED);

        if(login_id == 1 || login_id == 3 || login_id == 4)
        {
            completeButton = new JButton("Complete Appointment");
            completeButton.setBackground(Color.BLACK);
            completeButton.setFocusable(false);
            completeButton.setForeground(Color.WHITE);
        }
        else {
            completeButton = new JButton("Complete Appointment");
            completeButton.setBackground(Color.BLACK);
            completeButton.setFocusable(false);
            completeButton.setForeground(Color.WHITE);
            completeButton.setVisible(false); // Disable the button for other login_ids
        }
        
        cancelButton.addActionListener(this);
        completeButton.addActionListener(this);
       
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
        p2.add(cancelButton);
        p2.add(completeButton);

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

        String appID = textField.getText();

        if(e.getSource() == cancelButton)
        {
            if(appID.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Fill the Appointment ID !");
            }
            else
            {
                try {
                
                    ConnectionClass obj2 = new ConnectionClass();
                    String q2 = "Select * from Appointment where app_id='" + appID + "'";
                    ResultSet rs =  obj2.stm.executeQuery(q2);

                    if(rs.next())
                    {
                        try 
                        {
                            ConnectionClass obj3 = new ConnectionClass();
                            String q3 = "Update Appointment set app_status='Cancelled' where app_id='" +appID+ "'";
                            obj3.stm.executeUpdate(q3);
                            JOptionPane.showMessageDialog(null,"Appointment cancelled successfully!","Cancellation Confirmation",JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible(false);    
                        } 
                        catch (Exception ex3) 
                        {
                            ex3.printStackTrace();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Appointment ID -  '" + appID + "' not found in the database.");
                
                    }
                }
                catch(Exception ex2)
                {
                    ex2.printStackTrace();
                }
            }
        }


        if(e.getSource() == completeButton)
        {

            if(appID.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Fill the Appointment ID !");
            }
            else
            {
                try {
                
                    ConnectionClass obj4 = new ConnectionClass();
                    String q4 = "Select * from Appointment where app_id='" + appID + "'";
                    ResultSet rs =  obj4.stm.executeQuery(q4);

                    if(rs.next())
                    {
                        try 
                        {
                            ConnectionClass obj5 = new ConnectionClass();
                            String q5 = "Update Appointment set app_status='Complete' where app_id='" +appID+ "'";
                            obj5.stm.executeUpdate(q5);
                            this.setVisible(false);    
                        } 
                        catch (Exception ex5) 
                        {
                            ex5.printStackTrace();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Appointment ID - '" + appID + "' not found in the database.");
                
                    }
                }
                catch(Exception ex4)
                {
                    ex4.printStackTrace();
                }
            }
        }
    }
}
