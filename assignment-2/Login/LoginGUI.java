import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;
    private Login loginController;

    public LoginGUI(Login loginController) {
        this.loginController = loginController;

        // Setting the title of the JFrame
        setTitle("Maju Auto Sales Sdn.Bhd. PayRoll System");

        // Setting the default close operation to exit the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the preferred size of the JFrame
        setPreferredSize(new Dimension(400, 300));

        // Setting the layout to BorderLayout
        setLayout(new BorderLayout());

        // Creating a title label
        JLabel titleLabel = new JLabel("Maju Auto Sales Sdn.Bhd. PayRoll System", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Creating a panel to hold the login components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Creating and setting up the username label and text field
        JLabel userLabel = new JLabel("Username:");
        userText = new JTextField(20);

        // Creating and setting up the password label and password field
        JLabel passLabel = new JLabel("Password:");
        passText = new JPasswordField(20);

        // Creating the login button
        loginButton = new JButton("Login");

        // Adding the username label and text field to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        // Adding the password label and password field to the panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passText, gbc);

        // Adding the login button to the panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        // Adding the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginController.handleLogin(userText.getText(), new String(passText.getPassword()));
            }
        });

        // Packing the components within the frame
        pack();

        // Setting the frame to be visible
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void clearFields() {
        userText.setText("");
        passText.setText("");
    }
}
