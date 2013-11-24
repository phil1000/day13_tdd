public class LibraryUser {
	private String name;
	private int LibraryID;
	private Library library;
	
	public LibraryUser(String name) {
		this.name=name;
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
	}
	
	public void returnBook(String author, String name) {
		library.returnBook(author, name);
	}
	
	public Library getLibrary() {
		return this.library;
	}
}