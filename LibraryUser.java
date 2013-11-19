public class LibraryUser {
	private String name;
	private int LibraryID;
	private Library library;
	private BookMap myBooks;
	
	public LibraryUser(String name) {
		this.name=name;
		myBooks = new BookMap(100);
	}
		
	public String getName() {
		return this.name;
	}
	
	public int getLibraryID() {
		return this.LibraryID;
	}
	
	public void register(Library library) {
		this.library=library;
		this.LibraryID=library.getID(this);
	}
	
	public void borrow(String author, String name) {
		Book newBook = library.takeBook(author, name);
		int bookID = myBooks.shortHash(newBook.getAuthor()+newBook.getBookName());
		myBooks.put(bookID, newBook);
	}
	
	public void returnBook(String author, String name) {
		library.returnBook(author, name);
		int bookID = myBooks.shortHash(author+name);
		myBooks.remove(bookID);
	}
	
	public int numberofBooksBorrowed() {
		return myBooks.getSize();
	}
	
	public Book[] booksBorrowed() {
		return myBooks.getAll();
	}
	
	public Library getLibrary() {
		return this.library;
	}
}