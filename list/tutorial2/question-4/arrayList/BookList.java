import java.util.List;
import java.util.ArrayList;

public class BookList {
	private List<Book> bookList = new ArrayList<>();

	public boolean addBook(Book newBook) {
		return bookList.add(newBook);
	}

	public void addBookSpecific(int index,Book newBook) {
		bookList.add(index,newBook);

	}

	public boolean remove(Book whichBook) {
		return bookList.remove(whichBook);

	}
	
	public boolean search(Book findBook) {
		return bookList.contains(findBook);
	}

	public void inList() {
		for(Book b : bookList) {
			System.out.println(b);
		}
	}


	
}


