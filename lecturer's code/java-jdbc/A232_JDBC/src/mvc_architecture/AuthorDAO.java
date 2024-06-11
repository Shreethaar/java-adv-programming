
package mvc_architecture;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private static final String URL = "jdbc:mysql://localhost:3307/bookdb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public Author getAuthorById(int authorId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Author author = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM author WHERE authorid = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, authorId);
            resultSet = statement.executeQuery();
            
            int id=0;
            String fname = null, lname=null;
                        
            if (resultSet.next()) {
                System.out.println("Author is found");
                id = resultSet.getInt("authorid");
                fname=resultSet.getString("firstname");
                lname=resultSet.getString("lastname");
                
                author = new Author(id, fname, lname);
            }
            else
                System.out.println("The result is not found");
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return author;
    }

    public List<Author> getAllAuthors() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Author> authors = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM author";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            int id=0;
            String fname = null, lname=null;
            Author author=null;
            
            while (resultSet.next()) {
                id = resultSet.getInt("authorid");
                fname=resultSet.getString("firstname");
                lname=resultSet.getString("lastname");
                author= new Author(id, fname, lname);
                authors.add(author); //insert the current row/ record into ArrayList authors
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return authors; // return the ArrayList authors
    }

    public void addAuthor(Author author) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "INSERT INTO author (authorid, firstname, lastname) VALUES (?,?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, author.getAuthorId());
            statement.setString(2, author.getFirstName());
            statement.setString(3, author.getLastName());
            statement.executeUpdate();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    public void updateAuthor(Author author) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "UPDATE author SET firstname = ?, lastname = ? WHERE authorid = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.setInt(3, author.getAuthorId());
            statement.executeUpdate();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    public void deleteAuthor(int authorId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "DELETE FROM author WHERE authorid = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, authorId);
            statement.executeUpdate();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}

