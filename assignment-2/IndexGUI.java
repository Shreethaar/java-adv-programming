import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexGUI extends JFrame {
    private PayRoll payRollSys;

    public IndexGUI(String username) {
        // Setting the title of the JFrame
        setTitle("Main Application");

        // Setting the default close operation to exit the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the preferred size of the JFrame
        setPreferredSize(new Dimension(600, 400));

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
        add(contentPanel);

        // Action listener for the insert button
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertGUI(payRollSys);
            }
        });

        // Action listener for the view button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewGUI();
            }
        });

        // Action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertGUI(payRollSys);
            }
        });

        // Action listener for the exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the app
                System.exit(0);
            }
        });

        // Setting the frame to be visible
        pack();
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);
    }
}
