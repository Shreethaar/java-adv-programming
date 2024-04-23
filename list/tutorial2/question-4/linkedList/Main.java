import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookLinkedList books = new BookLinkedList();

		System.out.println("Book Storing System.");
		System.out.println("Enter 1 to Add new book");
		System.out.println("Enter 2 to Delete Book");
		System.out.println("Enter 3 to Search Book");
		System.out.println("Enter 4 to Quit System");

		int input=0;

		while(input!=4) {
			if(input==1) {
				System.out.println("Enter the title, author and year of publication:");
				String titleBook=sc.nextLine();
				String authorBook=sc.nextLine();
				int yearPublBook=sc.nextInt();
				Book newBook = new Book(bookTitle,bookAuthor,bookYrPubl);
				books.addBook(newBook);
				System.out.println(books);
			}
		}
	}
}



