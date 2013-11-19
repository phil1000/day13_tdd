public interface SimpleMap {
	void put(int key, String value);
	String get(int key);
	void remove(int key);
	boolean isEmpty();
}