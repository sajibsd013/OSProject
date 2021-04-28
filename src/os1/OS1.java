package os1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Frame extends JFrame {
    Cursor c= new Cursor(Cursor.HAND_CURSOR);
    
    public String osname() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName;
    }

    public void runAction(String type, String code) {
        String os = osname();
        if (os.startsWith("windows")) {

            int bool = JOptionPane.showConfirmDialog(rootPane, "Do you want " + type + " ?", type, JOptionPane.YES_NO_OPTION);
            Runtime runtime = Runtime.getRuntime();
            if (bool == 0) {
                try {
                    Process p = runtime.exec("shutdown -" + code + " -t 10");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Error" + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "OS not supported!");
        }

    }

    Frame() {
        this.setBounds(500, 200, 500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        JButton btn[];

        String buttonText[] = {"Shut down", "Restart"};
        btn = new JButton[3];
        for (int i = 0; i < buttonText.length; i++) {
            btn[i] = new JButton();
            btn[i].setCursor(c);
            btn[i].setText(buttonText[i]);
            btn[i].setBackground(Color.black);
            btn[i].setForeground(Color.white);
            panel.add(btn[i]);
        }
        btn[0].setBounds(100, 150, 120, 40);
        btn[1].setBounds(260, 150, 120, 40);

        btn[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                runAction("Shut down", "s");
            }
        });
        
        btn[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                runAction("Restart", "r");
            }
        });
        this.validate();
    }
}

public class OS1 {

    public static void main(String[] args) {
        Frame f = new Frame();
    }

}
