public class LibraryUser {
	private String name;
	private int LibraryID;
	private Library library;
	
	public LibraryUser(String name) {
		this.name=name;
	}
	
	public void setLibraryID(int id) {
		this.LibraryID=id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLibraryID() {
		return this.LibraryID;
	}
	
	public void register(Library library) {
		this.library=library;
		this.LibraryID=library.getID();
	}
	
	public Library getLibrary() {
		return this.library;
	}
}