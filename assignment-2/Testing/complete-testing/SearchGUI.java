import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchGUI extends JFrame {
    private JTextField nameField;
    private JTextArea outputArea;
    private SearchController searchController;

    public SearchGUI(SearchController searchController) {
        this.searchController = searchController;

        // Setting the title of the JFrame
        setTitle("Search Salesman Information");

        // Setting the default close operation to exit the application
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Setting the preferred size of the JFrame
        setPreferredSize(new Dimension(400, 300));

        // Creating a panel to hold the main content
        JPanel contentPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Creating and adding labels and text fields
        contentPanel.add(new JLabel("Salesman Name:"));
        nameField = new JTextField();
        contentPanel.add(nameField);

        // Creating and adding the output area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Creating and adding the search button
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchSalesman();
            }
        });

        // Adding components to the main panel
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.NORTH);
        add(searchButton, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Setting the frame to be visible
        pack();
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);
    }

    private void searchSalesman() {
        String name = nameField.getText();
        Salesman salesman = searchController.searchSalesRepByName(name);

        if (salesman != null) {
            outputArea.setText(salesman.toString());
        } else {
            outputArea.setText("Salesman not found.");
        }
    }
}
