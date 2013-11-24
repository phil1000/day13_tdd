import java.lang.reflect.*;

public class HashMap<K,V> {

    private Hashnode<K,V>[] nodes;
	private final int maxNumberofNodes;
	private int currentNumberofNodes;

    public HashMap(int size) {
		this.maxNumberofNodes=size;
        nodes = new Hashnode[size];
		
		for (int i=0;i<maxNumberofNodes;i++) {
			nodes[i]=null;
		}
		this.currentNumberofNodes=0;
    }

    public int getIndex(K key){
		// generate a key that is always between 1 and max number of nodes
		// and so will always fit into the hash table
        int hash = key.hashCode();
		int hashKey = Math.abs(hash%this.maxNumberofNodes);
        return hashKey;
    }

	public void put(K key, V data) {
        int hashKey = getIndex(key);
		
		if (nodes[hashKey]==null) {
			Hashnode<K,V> node = new Hashnode<K,V>(key, data);
			nodes[hashKey] = node;
			currentNumberofNodes++;
		} else {
			System.out.println("User already has exists so nothing done");
		}

    }

    public V get(K key){
        int hashKey = getIndex(key);
		if (nodes[hashKey]!=null) {
			return nodes[hashKey].data;
		} else {
			return null;
		}
	}
	
	public <T> T[] getAll(Class cls) {
		// I have to mess around with the Array class to create a new array
		// of the the type cls where class is passed in from the calling program
		// for example, if I want to create an array of Books, the calling program
		// should contain books.getAll(Book.class)
		T[] valueArray = (T[]) Array.newInstance(cls, currentNumberofNodes);
		int j=0;
		for (int i=0;i<nodes.length;i++) {
			if (nodes[i]!=null) {
				valueArray[j]=(T)nodes[i].data;//copying the (casted) object instance at this point to the value array
				j++;
			}
		}
		if (j==0) return null;
		else return valueArray;
	}
	
	public K getKey(K key){
        int hashKey = getIndex(key);
		if (nodes[hashKey]!=null) {
			return nodes[hashKey].key;
		} else {
			return null;
		}
	}

	public void remove(K key) {
		int hashKey = getIndex(key);
		nodes[hashKey]=null;
		this.currentNumberofNodes--;
	}

	public int getSize() {
		return currentNumberofNodes;
	}
	
	public boolean isEmpty() {
		if (this.currentNumberofNodes==0) return true;
		else return false;
	}

	static class Hashnode<K,V> {
        final K key;
        V data;

		public Hashnode(K k, V v){
            key = k;
            data = v;
        }
    }
}