import java.util.List;
import java.util.LinkedList;

public class BookLinkedList {
	private List<Book> bookList = new LinkedList<>();
	
	public boolean addBook(Book newBook) {
	       return bookList.add(newBook);
	}

	public boolean removeBook(Book deleteBook) {
		return bookList.remove(deleteBook);

	}

	public boolean contains(Book searchBook) {
		return bookList.contains(searchBook);
	}

}

