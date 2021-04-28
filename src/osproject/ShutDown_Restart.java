package osproject;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShutDown_Restart extends JFrame {

    public String osname() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName;
    }
    // Shut Down & Restart Functon 
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
}
