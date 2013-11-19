public class LibraryUserMap {
	private LibraryUser[] myLibraryUsers;
	private final int maxNumberofUsers;
	private int currentNumberofUsers;
	
	public LibraryUserMap(int maxNumberofUsers) {
		this.maxNumberofUsers=maxNumberofUsers;
		myLibraryUsers = new LibraryUser[this.maxNumberofUsers];
		for (int i=0; i<this.maxNumberofUsers; i++) {
			myLibraryUsers[i]=null;
		}
		this.currentNumberofUsers=0;
	}
	
	public int shortHash(String libraryUser) {
		// want to generate a key that is always between 1 and max number of users and so will always fit into my array
		
		int hash = libraryUser.hashCode(); // Every object in Java has the method hashCode(), that returns an int
		int hashKey=Math.abs(hash%this.maxNumberofUsers);
		return hashKey;
	}
	
	public void put(int hashKey, LibraryUser user) {		
		if (myLibraryUsers[hashKey]==null) {
			myLibraryUsers[hashKey]=user;
			currentNumberofUsers++;
		} else {
			System.out.println("User " + user.getName() + " already has exists so nothing done");
		}
	}
	
	public LibraryUser get(int hashKey) {
		if (myLibraryUsers[hashKey]!=null) {
			return myLibraryUsers[hashKey];
		} else {
			return null;
		}
	}
	
	public void remove(int hashKey) {
		myLibraryUsers[hashKey]=null;
		this.currentNumberofUsers--;
	}
	
	public int getSize() {
		return currentNumberofUsers;
	}
	
	public boolean isEmpty() {
		if (this.currentNumberofUsers==0) return true;
		else return false;
	}
	
	public LibraryUser[] getAll() {
		LibraryUser[] allUsers = new LibraryUser[currentNumberofUsers];
		int j=0;
		for (int i=0; i<this.maxNumberofUsers; i++) {
			if (myLibraryUsers[i]!=null) {
				allUsers[j]=myLibraryUsers[i];
				j++;
			}
		}
		if (j>0) return allUsers;
		else return null;
	}
	
	public void printMap() {
		for (int i=0; i<this.maxNumberofUsers; i++) {
			if (myLibraryUsers[i]!=null) {
				System.out.println(i + ":" + myLibraryUsers[i].getName() + ":" + myLibraryUsers[i].numberofBooksBorrowed());
			}
		}
	}
	
}