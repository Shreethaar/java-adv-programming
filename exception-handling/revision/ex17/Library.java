import java.util.HashMap;
import java.util.Map;

public class Library {
	private Map<String,Boolean> books;

	public Library() {
		books=new HashMap<>();
	}

	public void addBook(String title) throws BookAlreadyExistsException, InvalidBookException {
		if(title==null||title.trim().isEmpty()) {
			throw new InvalidBookException("Book title cannot be null or empty");
		}
		if(books.containsKey(title)) {
			throw new BookAlreadyExistsException("Book' " + title + " ' already exists in the library");
		}
		books.put(title,true);
	}

	public void borrowBook(String title) throws BookNotAvailableException, InvalidBookException {
		if(title==null||title.trim().isEmpty()) {
			throw new InvalidBookException("Book title cannot be null or empty");
		}
		if(!books.containsKey(title) || !books.get(title)) {
			throw new BookNotAvailableException("Book '" + title + " ' is not available");
		}
		books.put(title,false);
	}
}

