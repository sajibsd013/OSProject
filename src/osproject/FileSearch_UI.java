package osproject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class FileSearch_UI extends JFrame {

    Cursor c = new Cursor(Cursor.HAND_CURSOR);
    Font font = new Font("Times New Roman", Font.BOLD, 16);
    public JTextPane searchfieldtext = new JTextPane();
    public JTextPane drivelocationtext = new JTextPane();
    public JButton btn[];
    String drive[] = {"D", "E", "F"};
    public JComboBox select = new JComboBox(drive);
    public JLabel searchResult = new JLabel("Search result will be in here...");
    public JLabel drivelocationlabel = new JLabel("Select Drive path or Enter Drive path");
    public JLabel searchfieldlabel = new JLabel("Enter the File Name ");

    FileSearch_UI() {

        searchResult.setBounds(100, 100, 500, 150);
        searchResult.setFont(font);

        searchfieldtext.setBounds(350, 70, 200, 30);
        searchfieldlabel.setBounds(400, 40, 300, 30);

        drivelocationtext.setBounds(175, 70, 100, 30);
        drivelocationlabel.setBounds(80, 40, 300, 30);

        select.setBounds(100, 70, 70, 30);
        select.setFont(font);

        String buttonText[] = {"Search with Extension", "Search without Extension"};
        btn = new JButton[3];
        for (int i = 0; i < buttonText.length; i++) {
            btn[i] = new JButton();
            btn[i].setCursor(c);
            btn[i].setText(buttonText[i]);
            btn[i].setBackground(Color.gray);
            btn[i].setForeground(Color.white);
        }
        btn[0].setBounds(150, 120, 180, 30);
        btn[1].setBounds(350, 120, 180, 30);

        btn[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                FileSearch.area.setText("");

                try {
                    String drivePath;
                    if (drivelocationtext.getText().isEmpty()) {
                        drivePath = select.getSelectedItem().toString();
                    } else {
                        drivePath = drivelocationtext.getText();
                    }
                    FileSearch fs = new FileSearch(searchfieldtext.getText(), "with_Extension", drivePath);

                } catch (IOException ex) {
                    Logger.getLogger(FileSearch_UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btn[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                FileSearch.area.setText("");
                try {
                    String drivePath;
                    if (drivelocationtext.getText().isEmpty()) {
                        drivePath = select.getSelectedItem().toString();
                    } else {
                        drivePath = drivelocationtext.getText();
                    }
                    FileSearch fs = new FileSearch(searchfieldtext.getText(), "without_Extension", drivePath);

                } catch (IOException ex) {
                    Logger.getLogger(FileSearch_UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
