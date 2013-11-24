public class Library {
	private String name;
	private int maxBooksPerUser;	
	private static int MAX_NO_NODES=100;
	HashMap<String, Book> books;
	HashMap<String, LibraryUser> users;
	HashMap<String, BorrowLineItem> borrowers;
	int totalBooksBorrowed;
	
	public Library(String name) {
		this.name=name;
		this.totalBooksBorrowed=0;
		users  = new HashMap<String, LibraryUser>(MAX_NO_NODES); // the parameter sent is the max number of user for the library
		books = new HashMap<String, Book>(MAX_NO_NODES);
		borrowers = new HashMap<String, BorrowLineItem>(MAX_NO_NODES);;
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
	
	public void takeBook(String name, String author, String bookName) {
		Book myBook = books.get(author+bookName);
		if (myBook!=null) {
			if (myBook.isTaken()==false) {
				myBook.setTaken(true);
				BorrowLineItem newItem = new BorrowLineItem(name, author, bookName);
				borrowers.put(name+author+bookName, newItem);
				totalBooksBorrowed++;
			} else {
				System.out.println(bookName + ":" + author + " already taken");
			}
		} else {
			System.out.println(bookName + ":" + author + " not found in this library");
		}
	}
	
	public void returnBook(String name, String author, String bookName) {
		Book myBook = books.get(author+bookName);
		if (myBook!=null) {
			myBook.setTaken(false);
			BorrowLineItem oldItem = borrowers.get(name+author+bookName);
			if (oldItem != null) {
				borrowers.remove(name+author+bookName);
				totalBooksBorrowed--;
			} else {
				System.out.println(author + ":" + bookName + " not currently borrowed by " + name);
			}
		}
	}
	
	public Book[] getAllBooks() {
       return books.getAll(Book.class); // the getAll method creates an array of the passed class i.e. book
	}
	
	public void printAllBooks(Book[] allBooks) {
		for (int i=0; i<allBooks.length;i++) {
			System.out.println(allBooks[i].getAuthor()+","+allBooks[i].getBookName());
		}
	}
	
	public void printAllBooks() {
		Book[] allBooks = this.getAllBooks();
		printAllBooks(allBooks);
	}
	
	public LibraryUser[] getAllUsers() {
		return users.getAll(LibraryUser.class);
	}
	
	public void printAllUsers() {
		LibraryUser[] allUsers = this.getAllUsers();
		printAllUsers(allUsers);
	}
	
	public void printAllUsers(LibraryUser[] allUsers) {
		for (int i=0; i<allUsers.length;i++) {
			System.out.println(allUsers[i].getName());
		}
	}
	
	public BorrowLineItem[] getAllBorrowers() {
		return borrowers.getAll(BorrowLineItem.class);
	}
	
	public void printAllBorrowers() {
		BorrowLineItem[] allBorrowers = this.getAllBorrowers();
		printAllBorrowers(allBorrowers);
	}
	
	public void printAllBorrowers(BorrowLineItem[] allBorrowers) {
		for (int i=0; i<allBorrowers.length;i++) {
			System.out.println(allBorrowers[i].getName() + ":" + allBorrowers[i].getAuthor() + ":" + allBorrowers[i].getBookName());
		}
	}
	
	public void setMaxBooksPerUser(int maxBooks) {
		this.maxBooksPerUser=maxBooks;
	}
	
	public int getMaxBooksPerUser() {
		return this.maxBooksPerUser;
	}
	
	private class BorrowLineItem {
		String name; // the name of the library user
		String author;
		String bookName;
		
		public BorrowLineItem(String name, String author, String bookName) {
			this.name=name;
			this.author=author;
			this.bookName=bookName;
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getAuthor() {
			return this.author;
		}
		
		public String getBookName() {
			return this.bookName;
		}
	}
}