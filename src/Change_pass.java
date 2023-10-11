import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Change_pass extends JFrame implements ActionListener{


    JLabel backgroundLabel,headlineLabel, currentLabel, newLabel;
    JPasswordField currentField, newField;
    JButton change, close;
    Font f = new Font("Arial",Font.BOLD,20);
    public String adminID2;
    public int login_id2;
    String q1;

    Change_pass(String adminID,int login_id){

        this.setTitle("Change Password");
        this.setSize(650, 350);

        adminID2 = adminID;
        login_id2 = login_id;

        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        this.setIconImage(appIcon.getImage());

        //IMAGE LABEL
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("password.jpg"));
        Image i1 = img.getImage().getScaledInstance(650, 350, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);

        //BACKGROUND IMAGE LABEL
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 650, 350);
        backgroundLabel.setLayout(null);
        backgroundLabel.setIcon(img1);

        //HEADLINE LABEL
        headlineLabel = new JLabel("Change Password");
        headlineLabel.setBounds(180, 10,500,50);
        headlineLabel.setFont(new Font("Impact", Font.BOLD, 36));
        headlineLabel.setForeground(Color.WHITE);
        backgroundLabel.add(headlineLabel);

        //CURRENT PASSWORD
        currentLabel = new JLabel("Current Password");
        currentLabel.setBounds(130,100,250,30);
        currentLabel.setFont(f);
        currentLabel.setForeground(Color.WHITE);
        backgroundLabel.add(currentLabel);

        currentField = new JPasswordField();
        currentField.setBounds(350,100,150,30);
        currentField.setFont(f);
        backgroundLabel.add(currentField);

        //NEW PASSWORD
        newLabel = new JLabel("New Password");
        newLabel.setBounds(130,150,150,30);
        newLabel.setFont(f);
        newLabel.setForeground(Color.WHITE);
        backgroundLabel.add(newLabel);

        newField = new JPasswordField();
        newField.setBounds(350,150,150,30);
        newField.setFont(f);
        backgroundLabel.add(newField);
        
        //BUTTONS
        change = new JButton("Change");
        change.setBounds(150,230,150,40);
        change.setFocusable(false);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        backgroundLabel.add(change);

        close = new JButton("Close");
        close.setBounds(335,230,150,40);
        close.setFocusable(false);
        close.setBackground(Color.RED);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        backgroundLabel.add(close);

        this.add(backgroundLabel);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void showConfirmationDialog(){

        String old_pass = currentField.getText();
        String new_pass = newField.getText();

            // Check if any of the fields are empty
        if (old_pass.isEmpty() || new_pass.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please fill in   all fields.", "Field Error", JOptionPane.ERROR_MESSAGE);
            return; // Don't proceed with password change
        }

        if (old_pass.equals(new_pass)) 
        {
            JOptionPane.showMessageDialog(this, "New password is the same as the old password.", "Password Error", JOptionPane.ERROR_MESSAGE);
            return; // Don't proceed with password change
        }

        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to change your password?","Confirm Password Change",JOptionPane.YES_NO_OPTION);

        if(result == JOptionPane.YES_OPTION)
        {
            try 
            {
                ConnectionClass obj1 = new ConnectionClass();
                
                if(login_id2 == 1)
                {
                    q1 = "update doctor set password='" + new_pass + "' where doc_id='" +adminID2+ "' and password='" +old_pass+"'";
                    obj1.stm.executeUpdate(q1);
                }

                else if(login_id2 == 2)
                {
                    q1 = "update patient set password='" + new_pass + "' where pat_id='" +adminID2+ "' and password='" +old_pass+"'";
                    obj1.stm.executeUpdate(q1);
                }

                else if(login_id2 == 3)
                {
                    q1 = "update receptionist set password='" + new_pass + "' where res_id='" +adminID2+ "' and password='" +old_pass+"'";
                    obj1.stm.executeUpdate(q1);
                }
                
                else if(login_id2 == 4)
                {
                    q1 = "update admin set password='" + new_pass + "' where admin_id='" +adminID2+ "' and password='" +old_pass+"'";
                    obj1.stm.executeUpdate(q1);
                }

                JOptionPane.showMessageDialog(this, "Password changed successfully.");
                this.setVisible(false);
    
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == change)
        {   

            showConfirmationDialog();

        }

        if(e.getSource() == close)
        {
            this.setVisible(false);
        }
    }
}

