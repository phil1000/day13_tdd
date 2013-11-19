import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTest {
	Book newBook; // these objects to be used throughout and so make visible to entire class
	LibraryUser newUser; // ditto
	Library newLibrary;
	
	@Before
	public void buildUp() {
		// buildup class used to do stuff that may be needed across multiple test
		// methods so that we only do once
		newBook = new  Book("AN Author","A Great Read");
		newUser = new LibraryUser("User1");
		newLibrary = new Library("Harpenden");
	}
	
	@Test
	public void testBookCreation() {
		//test that the correct book has been created
		assertEquals("AN Author", newBook.getAuthor());
	}
	
	@Test
	public void testLibraryUserCreation() {
		//test that the correct user has been created
		assertEquals("User1", newUser.getName());
	}
	
	@Test
	public void testLibraryIDisNotSet() {
		//test that the library ID has not yet been set
		assertEquals(0, newUser.getLibraryID());
	}
		
	@Test
	public void testLibraryIDisSetbyRegister() {
		//test that library ID can be set via registering with the library
		newUser.register(newLibrary);
		assertEquals(94, newUser.getLibraryID());
		newUser.register(newLibrary);
		assertEquals(95, newUser.getLibraryID());
	}
	
	@Test
	public void testLibraryMaxBooks() {
		//test that library ID can be set via registering with the library
		
		newLibrary.setMaxBooksPerUser(3);
		assertEquals(3, newLibrary.getMaxBooksPerUser());
	}
}