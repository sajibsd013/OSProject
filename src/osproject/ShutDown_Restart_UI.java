package osproject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ShutDown_Restart_UI extends JFrame {

    Cursor c = new Cursor(Cursor.HAND_CURSOR);
    ShutDown_Restart sr = new ShutDown_Restart();
    public JButton btn[];

    ShutDown_Restart_UI() {

        // Shut Down & Restart UI 
        String buttonText[] = {"Shut down", "Restart"};
        btn = new JButton[3];
        for (int i = 0; i < buttonText.length; i++) {
            btn[i] = new JButton();
            btn[i].setCursor(c);
            btn[i].setText(buttonText[i]);
            btn[i].setBackground(Color.gray);
            btn[i].setForeground(Color.white);
        }
        btn[0].setBounds(200, 400, 120, 40);
        btn[1].setBounds(360, 400, 120, 40);

        btn[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // Call Shut down functin
                sr.runAction("Shut down", "s");
            }
        });

        btn[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // Call Restart functin
                sr.runAction("Restart", "r");
            }
        });
    }
}
