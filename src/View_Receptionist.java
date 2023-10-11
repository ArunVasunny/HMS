import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_Receptionist extends JFrame implements ActionListener{
    
    String x [] = {"Name","Username","Email-ID","Father's Name","Phone","Qualification","City","Gender","Blood","Joining Date","Age","Address","DOB"};

    String y [] [] = new String [30][13];
    JButton deleteButton, editButton;
    int i = 0, j = 0;
    JLabel l1,l2;
    JTextField textField;
    JPanel p1,p2,p3;
    Font f = new Font("MS UI Gothic", Font.BOLD,15);
    Font f1 = new Font("Lucida Fax",Font.BOLD,25);
    JScrollPane scrl;
    JTable table;

    View_Receptionist(int login_id)
    {
        
        this.setTitle("Receptionist Information");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(15,200);
        this.setSize(1500, 400);

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM receptionist";

            if(login_id != 4){
                x = new String[]{"Name","Email-ID","Phone","City","Gender","Age"};
            }

            ResultSet rs = obj.stm.executeQuery(q);
            
            while(rs.next())
            {
                y[i][j++] = rs.getString("name");
                
                if(login_id == 4){
                    y[i][j++] = rs.getString("username");
                }
                
                y[i][j++] = rs.getString("email");
                if(login_id == 4){

                    y[i][j++] = rs.getString("father_name");
                }
                y[i][j++] = rs.getString("phone");

                if(login_id == 4){

                    y[i][j++] = rs.getString("qualification");
                }
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("gender");
                if(login_id == 4){

                    y[i][j++] = rs.getString("blood");
                    y[i][j++] = rs.getString("joining_date");
                }
                y[i][j++] = rs.getString("age");

                if(login_id == 4){

                    y[i][j++] = rs.getString("address");
                    y[i][j++] = rs.getString("dob");
                }

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

        if(login_id == 4)
        {
            l1 = new JLabel("Receptionist Username");
            l2 = new JLabel("Delete or Edit Any Receptionist ?");
            l2.setHorizontalAlignment(JLabel.CENTER);
            
            l1.setForeground(Color.WHITE);
            l1.setFont(f1);
            l2.setForeground(Color.WHITE);
            l2.setFont(f1);

            deleteButton = new JButton("Delete Receptionist");
            deleteButton.setBackground(Color.BLACK);
            deleteButton.setFocusable(false);
            deleteButton.setForeground(Color.RED);

            editButton = new JButton("Edit Receptionist Record");
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
    }

    public void actionPerformed(ActionEvent e){

        String username = textField.getText();
        
        if(e.getSource() == deleteButton)
        {
            if(username.isEmpty())
            {   
                JOptionPane.showMessageDialog(null,"Please Fill the Receptionist Username !");
            }
            else
            {
                try {
                
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 = "Select * from receptionist where username='" + username + "'";
                    ResultSet rs =  obj1.stm.executeQuery(q1);

                    if(rs.next())
                    {
                        try 
                        {
                            ConnectionClass obj = new ConnectionClass();
                            String q = "DELETE from receptionist where username='" + username + "'";
                            obj.stm.executeUpdate(q);
                            JOptionPane.showMessageDialog(null, "Receptionist '" + username + "' has been deleted successfully!");
                            this.setVisible(false);    
                        } 
                        catch (Exception ex) 
                        {
                            ex.printStackTrace();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Receptionist '" + username + "' not found in the database.");
                
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
                JOptionPane.showMessageDialog(null,"Please Fill the Receptionist Username !");            
            }
            else
            {
                this.setVisible(false);
                new Edit_Receptionist(username);
            }
        }        
    }
}
