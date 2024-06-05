public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            System.out.println("Adding book: 'Java Programming'");
            library.addBook("Java Programming");
            System.out.println("Book 'Java Programming' added successfully.");

            System.out.println("Attempting to borrow book: 'Java Programming'");
            library.borrowBook("Java Programming");
            System.out.println("Book 'Java Programming' borrowed successfully.");

            try {
                System.out.println("Attempting to borrow book: 'Java Programming'");
                library.borrowBook("Java Programming");
            } catch (BookNotAvailableException e) {
                System.out.println("BookNotAvailableException: " + e.getMessage());
            }

            try {
                System.out.println("Attempting to add book: 'Java Programming' again.");
                library.addBook("Java Programming");
            } catch (BookAlreadyExistsException e) {
                System.out.println("BookAlreadyExistsException: " + e.getMessage());
            }
        } catch (InvalidBookException | BookAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                System.out.println("Returning book: 'Java Programming'");
                library.returnBook("Java Programming");
                System.out.println("Book 'Java Programming' returned successfully.");
            } catch (InvalidBookException e) {
                System.out.println("InvalidBookException: " + e.getMessage());
            }

            System.out.println("Final library state: Book 'Java Programming' is " +
                    (library.isBookAvailable("Java Programming") ? "available" : "not available") + ".");
        }
    }
}
