
package mvc_architecture;

import java.sql.SQLException;
import java.util.List;

public class AuthorController {
    private AuthorDAO model;
    private AuthorView view;

    public AuthorController(AuthorDAO model, AuthorView view) {
        this.model = model;
        this.view = view;
    }

    public void getAuthorById(int authorId) {
        try {
            Author author = model.getAuthorById(authorId);
            view.printAuthorDetails(author);
        } catch (SQLException e) {
            view.printMessage("Error fetching author: " + e.getMessage());
        }
    }

    public void getAllAuthors() {
        try {
            List<Author> authors = model.getAllAuthors();
            view.printAllAuthors(authors);
        } catch (SQLException e) {
            view.printMessage("Error fetching authors: " + e.getMessage());
        }
    }

    public void addAuthor(Author author) {
        try {
            
            model.addAuthor(author);
            view.printMessage("Author added successfully.");
        } catch (SQLException e) {
            view.printMessage("Error adding author: " + e.getMessage());
        }
    }

    public void updateAuthor(Author author) {
        try {
            
            model.updateAuthor(author);
            view.printMessage("Author updated successfully.");
        } catch (SQLException e) {
            view.printMessage("Error updating author: " + e.getMessage());
        }
    }

    public void deleteAuthor(int authorId) {
        try {
            model.deleteAuthor(authorId);
            view.printMessage("Author deleted successfully.");
        } catch (SQLException e) {
            view.printMessage("Error deleting author: " + e.getMessage());
        }
    }
}

