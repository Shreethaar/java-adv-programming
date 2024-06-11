
package mvc_architecture;

public class Main {
    public static void main(String[] args) {
        AuthorDAO model = new AuthorDAO();
        AuthorView view = new AuthorView();
        AuthorController controller = new AuthorController(model, view);

        // Example usage
        Author author, updatedAuthor;
        author = new Author(444, "Julia", "Kasim");
        //controller.addAuthor(author);
        System.out.println("");
        controller.getAllAuthors();
        System.out.println("");
        controller.getAuthorById(111);
        
        System.out.println("");
        updatedAuthor = new Author(333, "Gopala", "Krishnan");
        controller.updateAuthor(updatedAuthor);
        System.out.println("");
        controller.getAuthorById(444);
        System.out.println("");
        controller.deleteAuthor(555);
        System.out.println("");
        controller.getAllAuthors();
    }
}

