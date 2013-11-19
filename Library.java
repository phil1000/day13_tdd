public class Library {
	private String name;
	private int maxBooksPerUser;
	LibraryUserMap users;
	BookMap books;
	int totalBooksBorrowed;
	
	public Library(String name) {
		this.name=name;
		this.totalBooksBorrowed=0;
		users = new LibraryUserMap(100); // the parameter sent is the max number of user for the library
		books = new BookMap(100);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID(LibraryUser user) {
		int userID = users.shortHash(user.getName()); // it's a static method so assoc. with class
		users.put(userID, user);
		return userID;
	}
	
	public void addBooks(Book newBook) {
		int bookID = books.shortHash(newBook.getAuthor()+newBook.getBookName());
		books.put(bookID, newBook);
	}
	
	public int getReaderCount() {
		return users.getSize();
	}
	
	public int getBookCount() {
		return books.getSize();
	}
	
	public int getBookBorrowedCount() {
		return totalBooksBorrowed;
	}
	
	public Book takeBook(String author, String bookName) {
		int bookID = books.shortHash(author+bookName);
		Book myBook = books.get(bookID);
		if (myBook!=null) {
			if (myBook.isTaken()) {
				return null;
			} else {
				myBook.setTaken(true);
				totalBooksBorrowed++;
				return myBook;
			}
		} else {
			return null;
		}
	}
	
	public void returnBook(String author, String bookName) {
		int bookID = books.shortHash(author+bookName);
		Book myBook = books.get(bookID);
		if (myBook!=null) {
			myBook.setTaken(false);
			totalBooksBorrowed--;
		}
	}
	
	public Book[] returnAllBooks() {
		return books.getAll();
	}
	
	public LibraryUser[] returnAllUsers() {
		return users.getAll();
	}
	
	public void setMaxBooksPerUser(int maxBooks) {
		this.maxBooksPerUser=maxBooks;
	}
	
	public int getMaxBooksPerUser() {
		return this.maxBooksPerUser;
	}
}