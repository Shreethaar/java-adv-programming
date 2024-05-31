import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookList books = new BookList();

		System.out.println("Book Storing System");
		System.out.println("Enter 1 to Add new Book");
		System.out.println("Enter 2 to Delete Book");
		System.out.println("Enter 3 to Search Book");
		System.out.println("Enter 4 to Quit system");

		int input=0;

		while(input!=4) {
			if(input==1) {
				System.out.println("Enter the title, author and year of publication:");
				String titleBook=sc.nextLine();
				String authorBook=sc.nextLine();
				int yearPublBook=sc.nextInt();
				Book newBook=new Book(titleBook,authorBook,yearPublBook);
				books.addBook(newBook);
				System.out.println(books);
				
			}
			if(input==2) {
				System.out.println("Enter the title, author and year of publication:");
				String titleBook=sc.nextLine();
				String authorBook=sc.nextLine();
				int yearPublBook=sc.nextInt();
				Book deleteBook = new Book(titleBook,authorBook,yearPublBook);
				books.remove(deleteBook);

			}
			if(input==3) {
				System.out.println("Enter the title,author and year of publication:");
				String titleBook=sc.nextLine();
				String authorBook=sc.nextLine();
				int yearPublBook=sc.nextInt();
				Book searchBook = new Book(titleBook,authorBook,yearPublBook);
				books.search(searchBook);
			}

		}
		System.out.println("Bruhhh...");
	}
}
	

		

