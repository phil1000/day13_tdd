public class Library {
	private String name;
	private int maxBooksPerUser;	
	private static int MAX_NO_NODES=100;
	HashMap<String, Book> books;
	HashMap<String, LibraryUser> users;
	int totalBooksBorrowed;
	
	public Library(String name) {
		this.name=name;
		this.totalBooksBorrowed=0;
		users  = new HashMap<String, LibraryUser>(MAX_NO_NODES); // the parameter sent is the max number of user for the library
		books = new HashMap<String, Book>(MAX_NO_NODES);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID(LibraryUser user) {
		users.put(user.getName(), user);
		return users.getIndex(user.getName());
	}
	
	public void addBooks(Book newBook) {
		books.put(newBook.getAuthor()+newBook.getBookName(), newBook);
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
		Book myBook = books.get(author+bookName);
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
		Book myBook = books.get(author+bookName);
		if (myBook!=null) {
			myBook.setTaken(false);
			totalBooksBorrowed--;
		}
	}
	
	public Book[] getAllBooks() {
       return books.getAll(Book.class); // the getAll method creates an array of the passed class i.e. book
	}
	
	public LibraryUser[] getAllUsers() {
		return users.getAll(LibraryUser.class);
	}
	
	public void printAllUsers() {
		LibraryUser[] allUsers = this.getAllUsers();
		for (int i=0; i<allUsers.length;i++) {
			System.out.println(allUsers[i].getName());
		}
	}
	
	public void printAllBooks() {
		Book[] allBooks = this.getAllBooks();
		for (int i=0; i<allBooks.length;i++) {
			System.out.println(allBooks[i].getAuthor()+","+allBooks[i].getBookName());
		}
	}
	
	public void setMaxBooksPerUser(int maxBooks) {
		this.maxBooksPerUser=maxBooks;
	}
	
	public int getMaxBooksPerUser() {
		return this.maxBooksPerUser;
	}
}