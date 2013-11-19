public class Temp {
	
	public void launch() {
		String[] str = {"User1","User2","User3","User66","User989","User3","User777"};
		
		for (int i=0; i<str.length;i++) {
			int hash = str[i].hashCode(); // Every object in Java has the method hashCode(), that returns an int
			int hashKey=Math.abs(hash%100);
			System.out.println(str[i] + ":" + hashKey);
		}
		
		// now test the book map class
		String authorNBooks[][] = {{"Phil","Book1"},{"Jon","Book2"},{"Issy","Book3"},{"Aimee","Book4"},{"Flora","Book5"}};
		
		BookMap myBooks = new BookMap(100);
		
		for (int i=0; i<authorNBooks.length; i++) {
				Book newBook = new Book(authorNBooks[i][0],authorNBooks[i][1]);
				int hashKey = myBooks.shortHash(authorNBooks[i][0]+authorNBooks[i][1]);
				System.out.println(authorNBooks[i][0] + ":" + authorNBooks[i][1] + "-" + hashKey);
				myBooks.put(hashKey,newBook);
		}
		System.out.println("Bookmap size="+myBooks.getSize());
		myBooks.printMap();
	}
	
	public static void main(String[] args) {
		Temp myTemp = new Temp();
		myTemp.launch();
	}
}