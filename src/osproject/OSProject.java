package osproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OSProject extends JFrame {

    OSProject() {
        components();
    }

    public void components() {
        this.setBounds(400, 200, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My System");
        this.setResizable(false);

        // Main Panel 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        // File Serach UI (Panel)
        FileSearch_UI fsUI = new FileSearch_UI();
        panel.add(fsUI.select);
        panel.add(fsUI.searchfieldtext);
        panel.add(fsUI.drivelocationlabel);
        panel.add(fsUI.drivelocationtext);
        panel.add(fsUI.searchResult);
        panel.add(fsUI.searchfieldlabel);
        
        // Scroll
        JScrollPane scroll = new JScrollPane(FileSearch.area);
        scroll.setBounds(100, 190, 500, 190);
        panel.add(scroll);
        
        //Text area 
        FileSearch.FS();
        
        // Shut Down & Restart UI (Panel)
        ShutDown_Restart_UI srUI = new ShutDown_Restart_UI();
        for (int i = 0; i < 2; i++) {
            panel.add(srUI.btn[i]);
            panel.add(fsUI.btn[i]);
        }

        this.setVisible(true);
        this.validate();
    }

    public static void main(String[] args) {
        OSProject f = new OSProject();
    }
}
