public class LibraryScript {
	private Library myLibrary;
	
	public void launch() {
		// build a new library
		myLibrary = new Library("Harpenden");
		System.out.println(myLibrary.getName() + " now open");
		
		this.addBooks();
		this.addUsers();
		
		myLibrary.printAllBooks();
		myLibrary.printAllUsers();
		
		/*
		allUsers[0].borrow("Aimee","My life");
		allUsers[0].borrow("Flora","What does a fox say");
		this.printAllBooks(allBooks);
		
		Book[] allUserBooks = allUsers[0].booksBorrowed();
		System.out.println("User " + allUsers[0].getName() + " has borrowed: ");
		for (int i=0;i<allUserBooks.length;i++) {
			System.out.println(allUserBooks[i].getAuthor() + ":" + allUserBooks[i].getBookName());
		}
		
		allUsers[0].returnBook("Aimee","My life");
		allUsers[0].returnBook("Flora","What does a fox say");
		this.printAllBooks(allBooks);
		*/
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