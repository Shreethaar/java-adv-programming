import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorCRUD {

    private static final String URL = "jdbc:mysql://localhost:3307/bookdb"; // replace with your hostname and port if different
    private static final String USER = "root"; // replace with your MySQL username
    private static final String PASSWORD = "1234"; // replace with your MySQL password

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");
                            
            // Create an author
            Author author = new Author(888, "Shree", "Ram");
            //createAuthor(connection, author);
            
            

            // Read authors
            readAuthors(connection);
            
            searchAuthorbyID(connection, 222);

            // Update an author
            author = new Author(222, "Bryan", "Sally");
            updateAuthor(connection, author);

            // Delete an author
            deleteAuthor(connection, 444);
 
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create
    public static void createAuthor(Connection connection, Author author) throws SQLException {
        
        System.out.println("Insert Section");
        // author -> table name
        // (authorid, firstname, lastname) - column names in the author table
        String query = "INSERT INTO author (authorid, firstname, lastname) VALUES (?, ?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        // setInt->id is in int
        statement.setInt(1, author.getId()); // 1-> refer to the first question mark
        
        //setString-> firstname and lastname in String
        statement.setString(2, author.getFname()); // 2-> refer to the second question mark
        statement.setString(3, author.getLname()); // 3-> refer to the third question mark
        int rowsInserted = statement.executeUpdate();
        System.out.println("No of rows inserted into DB = "+rowsInserted);
        if (rowsInserted > 0) {
            System.out.println("A new author was inserted successfully!");
        }
        statement.close();
    }

    // Read
    public static void readAuthors(Connection connection) throws SQLException {
        
        System.out.println("\nDisplay all record section");
        String query = "SELECT * FROM author";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int i=0;
        while (resultSet.next()) {
            
            int id = resultSet.getInt("authorid"); //getInt -> id in int
            String firstName = resultSet.getString("firstname"); //getString->firstname in String
            String lastName = resultSet.getString("lastname");
            
            i++;
            System.out.println("Record = "+i);
            System.out.println(id+"\t"+firstName+"\t"+lastName);
        }
        resultSet.close();
        statement.close();
    }
    public static void searchAuthorbyID(Connection connection, int authorId) throws SQLException {
        System.out.println("\nSearching section");
        String query = "SELECT * FROM author WHERE authorid = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, authorId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("It is found");
            String fname = resultSet.getString("firstname");
            String lname = resultSet.getString("lastname");
            System.out.println(authorId+"\t"+fname+"\t"+lname);
        }
        else
            System.out.println("The record is not found");
        statement.close();
    }

    // Update
    public static void updateAuthor(Connection connection, Author author) throws SQLException {
        System.out.println("\nUpdate Section");
        String query = "UPDATE author SET firstname = ?, lastname = ? WHERE authorid = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, author.getFname());
        statement.setString(2, author.getLname());
        statement.setInt(3, author.getId());
               
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing author was updated successfully!");
        }
        statement.close();
    }

    // Delete
    public static void deleteAuthor(Connection connection, int authorId) throws SQLException {
        
        System.out.println("\nDelete section");
        String query = "DELETE FROM author WHERE authorid = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, authorId);
        int rowsDeleted = statement.executeUpdate();
        System.out.println("Total of deleted record = "+rowsDeleted);
        if (rowsDeleted > 0) {
            System.out.println("An author was deleted successfully!");
        }
        statement.close();
    }

}
