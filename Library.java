public class Library {
	private String name;
	private int maxBooksPerUser;
	int currentUserId;
	
	public Library(String name) {
		this.name=name;
		currentUserId=0;
	}
	
	public int getID() {
		this.currentUserId=++this.currentUserId;
		return this.currentUserId;
	}
	
	public void setMaxBooksPerUser(int maxBooks) {
		this.maxBooksPerUser=maxBooks;
	}
	
	public int getMaxBooksPerUser() {
		return this.maxBooksPerUser;
	}
}