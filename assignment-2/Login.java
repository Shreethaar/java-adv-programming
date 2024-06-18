import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    // Constructor to set up the GUI components
    public Login() {
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
        JTextField userText = new JTextField(20);

        // Creating and setting up the password label and password field
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(20);

        // Creating the login button
        JButton loginButton = new JButton("Login");

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
                String username = userText.getText();
                String password = new String(passText.getPassword());

                // Check if the username and password are correct
                if (username.equals("admin") && password.equals("admin")) {
                    // If correct, show main application window
                    dispose(); // Close the login window
                    showMainApplicationWindow(username); // Pass username to show welcome message and options
                } else {
                    // If incorrect, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Packing the components within the frame
        pack();

        // Setting the frame to be visible
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);
    }

    // Method to show the main application window after successful login
    private void showMainApplicationWindow(String username) {
        // Create a new JFrame for the main application
        JFrame mainFrame = new JFrame("Main Application");

        // Setting the default close operation to exit the application
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the preferred size of the JFrame
        mainFrame.setPreferredSize(new Dimension(600, 400));

        // Creating a panel to hold main content
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Creating a welcome message label
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        contentPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Creating a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Creating buttons for functionality
        JButton insertButton = new JButton("Insert");
        JButton viewButton = new JButton("View");
        JButton searchButton = new JButton("Search");
        JButton exitButton = new JButton("Exit");

        // Adding buttons to the button panel
        buttonPanel.add(insertButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(exitButton);

        // Adding button panel to content panel
        contentPanel.add(buttonPanel, BorderLayout.CENTER);

        // Adding content panel to main frame
        mainFrame.add(contentPanel);

        // Action listener for the insert button
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "Insert functionality to be implemented.");
            }
        });

        // Action listener for the view button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "View functionality to be implemented.");
            }
        });

        // Action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "Search functionality to be implemented.");
            }
        });

        // Action listener for the exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });

        // Setting the frame to be visible
        mainFrame.pack();
        mainFrame.setVisible(true);

        // Setting the frame location to the center of the screen
        mainFrame.setLocationRelativeTo(null);
    }

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

