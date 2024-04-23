public class Book {
	private String bookTitle;
	private String bookAuthor;
	private int bookYrPubl;

	public Book(String bookTitle, String bookAuthor, int bookYrPubl) {
		setBookTitle(bookTitle);
		setBookAuthor(bookAuthor);
		setBookYrPubl(bookYrPubl);
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public int getBookYrPubl() {
		return bookYrPubl;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle=bookTitle;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor=bookAuthor;
	}

	public void setBookYrPubl(int bookYrPubl) {
		this.bookYrPubl=bookYrPubl;
	}

	public String toString() {
		return String.format("Book Title: %s\nBook Author: %s\nBook Year Published: %d",getBookTitle(),getBookAuthor(),getBookYrPubl());
	}
}

