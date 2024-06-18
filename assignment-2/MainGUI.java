import javax.swing.*;

public class MainGUI {
    public static void main(String[] args) {
        // Running the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}
