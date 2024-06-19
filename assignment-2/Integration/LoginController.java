
import javax.swing.*;

public class LoginController {
    private LoginGUI loginGUI;

    public LoginController() {
        loginGUI = new LoginGUI(this);
    }

    public void handleLogin(String username, String password) {
        // Check if the username and password are correct
        if (username.equals("admin") && password.equals("admin")) {
            // If correct, show main application window
            loginGUI.dispose(); // Close the login window
            
            // Initialize PayRoll system
            PayRoll payRollSys = new PayRoll();
            
            // Launch main application window (MainApp)
            SwingUtilities.invokeLater(() -> {
                MainApp mainApp = new MainApp(payRollSys);
                mainApp.setVisible(true);
            });
        } else {
            // If incorrect, show an error message
            loginGUI.showError("Invalid username or password.");
        }
    }
}
