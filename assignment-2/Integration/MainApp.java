import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    private PayRoll payRollSys;

    public MainApp(PayRoll payRollSys) {
        this.payRollSys = payRollSys;

        // Setting the title of the JFrame
        setTitle("Maju Auto Sales Sdn.Bhd. PayRoll System");

        // Setting the default close operation to exit the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the preferred size of the JFrame
        setPreferredSize(new Dimension(400, 300));

        // Creating a panel to hold the main content
        JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        // Creating and adding buttons for different functionalities
        JButton insertButton = new JButton("Insert Salesman");
        JButton viewButton = new JButton("View Salesman");
        JButton searchButton = new JButton("Search Salesman");

        contentPanel.add(insertButton);
        contentPanel.add(viewButton);
        contentPanel.add(searchButton);

        // Adding content panel to the frame
        add(contentPanel, BorderLayout.CENTER);

        // Setting the frame to be visible
        pack();
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);

        // Action listener for the insert button
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch the Insert GUI on the EDT
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new InsertController(payRollSys);
                    }
                });
            }
        });

        // Action listener for the view button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch the View GUI on the EDT
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ViewController(payRollSys);
                    }
                });
            }
        });

        // Action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch the Search GUI on the EDT
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new SearchController(payRollSys);
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        // Initialize the PayRollSystem
        PayRoll payRollSys = new PayRoll();

        // Create and show the main application window on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainApp(payRollSys);
            }
        });
    }
}
