public class Book {
	private String title;
	private String author;
	private int yearPubl;

	public Book(String title, String author, int yearPubl) {
		setTitle(title);
		setAuthor(author);
		setYearPubl(yearPubl);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title=title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author=author;
	}

	public int getYearPubl() {
		return yearPubl;
	}

	public void setYearPubl(int yearPubl) {
		this.yearPubl=yearPubl;
	}

	public String toString() {
		return String.format("Book title: %s\nBook Author: %s\nBook Year Published: %d\n",getTitle(),getAuthor(),getYearPubl());
	}
}

