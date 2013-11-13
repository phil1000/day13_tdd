public class Book {
	final private String author;
	final private String bookName;

	public Book(String author, String bookName) {
		this.author=author;
		this.bookName=bookName;
	}

	public String getAuthor() {
		return this.author;
	}
	
	public String getBookName() {
		return this.bookName;
	}
}