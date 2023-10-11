import java.awt.*;
import javax.swing.*;

class splash {

    static JFrame frame = new JFrame("Central City Hospital");
    static JProgressBar bar = new JProgressBar(0, 100);

    public static void main(String[] args) 
    {
        
        frame.setSize(650, 500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    
        ImageIcon appIcon = new ImageIcon("src\\icons\\hospital.png");
        frame.setIconImage(appIcon.getImage());

        JLabel l1 = new JLabel();
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("splash.jpg"));
        Image i1 = img.getImage().getScaledInstance(650, 500, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        bar.setValue(0);
        bar.setBackground(Color.WHITE);
        bar.setForeground(new Color(64, 130, 109));
        bar.setStringPainted(true);

        frame.add(bar, BorderLayout.SOUTH);
        frame.add(l1, BorderLayout.CENTER);
        frame.setVisible(true);
        fill();
    }

    public static void fill() {
        for (int i = 0; i <= 100; i+=2.5) {
            bar.setString("Loading " + i + "%");
            bar.setValue(i);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }

            if (i == 100) {
                bar.setString("WELCOME");
                new Index();
                frame.dispose();
            }
        }
    }
}
