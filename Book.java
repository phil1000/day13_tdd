public class Book {
	final private String author;
	final private String bookName;
	private boolean isTaken;

	public Book(String author, String bookName) {
		this.author=author;
		this.bookName=bookName;
		this.isTaken=false;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getBookName() {
		return this.bookName;
	}
	
	public void setTaken(boolean value) {
		this.isTaken=value;
	}
	
	public boolean isTaken() {
		return this.isTaken;
	}
}