import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ViewGUI extends JFrame {
    private JTextArea outputArea;
    private ViewController viewController;

    public ViewGUI(ViewController viewController) {
        this.viewController = viewController;

        // Setting the title of the JFrame
        setTitle("View Salesman Information");

        // Setting the default close operation to exit the application
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Setting the preferred size of the JFrame
        setPreferredSize(new Dimension(400, 600));

        // Creating a panel to hold the main content
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Creating and adding the output area
        outputArea = new JTextArea(20, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Adding components to the main panel
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Adding the content panel to the frame
        add(contentPanel);

        // Setting the frame to be visible
        pack();
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);

        // Fetch and display the salesmen data
        displaySalesmen();
    }

    public void displaySalesmen() {
        Map<String, Salesman> salesmen = viewController.getAllSalesmen();
        outputArea.setText(""); // Clear existing content
        salesmen.forEach((id, salesman) -> outputArea.append(salesman + "\n"));
    }
}
