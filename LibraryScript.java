public class LibraryScript {
	private Library myLibrary;
	
	public void launch() {
		// build a new library
		myLibrary = new Library("Harpenden");
		System.out.println(myLibrary.getName() + " now open");
		
		this.addBooks();
		this.addUsers();
		
		Book[] books = myLibrary.getAllBooks();
		myLibrary.printAllBooks(books);
		LibraryUser[] users = myLibrary.getAllUsers();
		myLibrary.printAllUsers(users);
		
		// start borrowing books
		
		users[0].borrow(books[0].getAuthor(), books[0].getBookName());
		users[0].borrow(books[1].getAuthor(), books[1].getBookName());
		users[0].borrow(books[2].getAuthor(), books[2].getBookName());
		// following should get rejected as book already borrowed
		users[1].borrow(books[0].getAuthor(), books[0].getBookName()); 
		// following should be fine
		users[1].borrow(books[3].getAuthor(), books[3].getBookName());
		
		myLibrary.printAllBorrowers();
		
		System.out.println("\n\n");
		System.out.println("Books about to be returned");
		
		users[0].returnBook(books[0].getAuthor(), books[0].getBookName());
		users[0].returnBook(books[1].getAuthor(), books[1].getBookName());
		
		myLibrary.printAllBorrowers();
	}
	
	private void addBooks() {
		// add books to the library
		String authorNBooks[][] = {{"Aimee","My life"},{"Flora","What does a fox say"},{"Bruno","Dad is great"},{"Charlie","Simon smells"},{"Olly","Arsenal suck"}};
		for (int i=0; i<authorNBooks.length; i++) {
				Book newBook = new Book(authorNBooks[i][0],authorNBooks[i][1]);
				myLibrary.addBooks(newBook);
		}
		System.out.println("Number of books is " + myLibrary.getBookCount());
	}
	
	private void addUsers() {
		//create a number of users and get them to register with the library
		String[] libUsers = {"Phil","Isabelle","Kate","Paul","Doc","Worz","Simon"};
		for (int i=0; i<libUsers.length; i++) {
			LibraryUser newUser = new LibraryUser(libUsers[i]);
			newUser.register(myLibrary);
		}
		System.out.println("Number of readers is " + myLibrary.getReaderCount());
	}
	
	public static void main(String[] args) {
		LibraryScript script = new LibraryScript();
		script.launch();
	}
}