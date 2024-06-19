import javax.swing.*;

public class Login {
    private LoginGUI loginGUI;

    public Login() {
        loginGUI = new LoginGUI(this);
    }

    public void handleLogin(String username, String password) {
        // Check if the username and password are correct
        if (username.equals("admin") && password.equals("admin")) {
            // If correct, show main application window
            loginGUI.dispose(); // Close the login window
            new IndexGUI(username).setVisible(true);
        } else {
            // If incorrect, show an error message
            loginGUI.showError("Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

