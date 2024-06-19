import javax.swing.*;

public class LoginController {
    private LoginGUI loginGUI;

    public LoginController() {
        loginGUI = new LoginGUI(this);
    }

    public void handleLogin(String username, String password) {
        // Check if the username and password are correct
        if (username.equals("admin") && password.equals("admin")) {
            loginGUI.dispose();
            SalesPersonDB salesPersonDB = new SalesPersonDB();
            PayRollCalculator1 payRollCalculator = new PayRollCalculator1();
            // Initialize the PayRoll system
            PayRoll payRollSys = new PayRoll(salesPersonDB, payRollCalculator);

            // Launch MainApp with the PayRoll system
            SwingUtilities.invokeLater(() -> {
                new MainApp(payRollSys).setVisible(true);
            });
        } else {
            // If incorrect, show error message and clear password field
            loginGUI.showError("Invalid username or password.");
            loginGUI.clearPasswordField();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginController());
    }
}

