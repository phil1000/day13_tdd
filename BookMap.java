public class BookMap {
	// implement Simple Map when i understand generics  ... public class BookMap implements SimpleMap { ...
	private Book[] myBooks;
	private final int maxNumberofBooks;
	private int currentNumberofBooks;
	
	public BookMap(int maxNumberofBooks) {
		this.maxNumberofBooks=maxNumberofBooks;
		myBooks = new Book[this.maxNumberofBooks]; /// this fails at compile time if I use a generic here
		
		for (int i=0;i<maxNumberofBooks;i++) {
			myBooks[i]=null;
		}
		this.currentNumberofBooks=0;
	}
	
	public int shortHash(String authorAndName) {
		// want to generate a key that is always between 1 and max number of users and so will always fit into my array
		
		int hash = authorAndName.hashCode(); // Every object in Java has the method hashCode(), that returns an int
		int hashKey=Math.abs(hash%this.maxNumberofBooks);
		return hashKey;
	}
	
	public void put(int hashKey, Book book) {		
		if (myBooks[hashKey]==null) {
			myBooks[hashKey]=book;
			currentNumberofBooks++;
		} else {
			System.out.println("User already has exists so nothing done");
		}
	}
	
	public Book get(int hashKey) {
		if (myBooks[hashKey]!=null) {
			return myBooks[hashKey];
		} else {
			return null;
		}
	}
	
	public void remove(int hashKey) {
		myBooks[hashKey]=null;
		this.currentNumberofBooks--;
	}
	
	public int getSize() {
		return currentNumberofBooks;
	}
	
	public boolean isEmpty() {
		if (this.currentNumberofBooks==0) return true;
		else return false;
	}
	
	public Book[] getAll() {
		Book[] bookArray = new Book[currentNumberofBooks];
		int j=0;
		for (int i=0; i<this.maxNumberofBooks; i++) {
			if (myBooks[i]!=null) {
				bookArray[j]=myBooks[i];
				j++;
			}
		}
		if (j>0) return bookArray;
		else return null;
	}
	
	public void printMap() {
		for (int i=0; i<this.maxNumberofBooks; i++) {
			if (myBooks[i]!=null) {
				System.out.println(i + ":" + myBooks[i].getAuthor() + ":" + myBooks[i].getBookName() + Boolean.toString(myBooks[i].isTaken()));
			}
		}
	}
	
}