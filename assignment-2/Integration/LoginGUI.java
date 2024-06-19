
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;
    private JLabel errorLabel;

    private LoginController controller;

    public LoginGUI(LoginController controller) {
        this.controller = controller;

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 150));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel userLabel = new JLabel("Username:");
        userText = new JTextField(20);

        JLabel passLabel = new JLabel("Password:");
        passText = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());
                controller.handleLogin(username, password);
            }
        });

        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(errorLabel, gbc);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showError(String message) {
        errorLabel.setText(message);
    }

    public void clearFields() {
        userText.setText("");
        passText.setText("");
        errorLabel.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI(new LoginController());
            }
        });
    }
}

