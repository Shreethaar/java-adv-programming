import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewGUI extends JFrame {

    public ViewGUI() {
        // Setting the title of the JFrame
        setTitle("Salesmen Information");

        // Setting the default close operation to exit the application
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Setting the preferred size of the JFrame
        setPreferredSize(new Dimension(600, 400));

        // Creating a panel to hold main content
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Creating a table to display salesmen's information
        String[] columnNames = {"ID", "Name", "Contact"};
        Object[][] data = {
            {"1", "John Doe", "123-456-7890"},
            {"2", "Jane Smith", "987-654-3210"},
            {"3", "Michael Johnson", "456-789-1234"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Adding the scroll pane containing the table to the content panel
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Adding content panel to main frame
        add(contentPanel);

        // Setting the frame to be visible
        pack();
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);
    }
}

