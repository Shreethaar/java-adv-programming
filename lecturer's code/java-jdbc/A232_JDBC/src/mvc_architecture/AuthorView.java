
package mvc_architecture;

import java.util.List;

public class AuthorView {
    public void printAuthorDetails(Author author) {
        if (author != null) {
            System.out.println(author);
        } else {
            System.out.println("Author is not found.");
        }
    }

    public void printAllAuthors(List<Author> authors) {
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
