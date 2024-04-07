/** 
 * Inspired by: // https://algs4.cs.princeton.edu/31elementary/SequentialSearchST.java.html
 *
 * To compile: 
 * 	 javac -d bin search/*.java
 * 
 * To run (with assertions): 
 *   java -ea -cp bin search.SequentialSearch
 */

package search; 

public class SequentialSearch<Key, Value> implements SymbolTable<Key, Value>{
	
	private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

	public SequentialSearch(){

	}

	// Returns the number of keys 
	public int size(){
		return n; 
	}

	// Is the table empty? 
	public boolean isEmpty(){
		return size() == 0; 
	}

	// Helper functions that checks if the key is null 
	// If so, throws an exception
	public void checkNullKey(Key key){
		if (key == null){
			throw new IllegalArgumentException("keys cannot be null");
		}
	}

	// Put the key-value pair into the table 
	// If val is null, remove key from the table
	public void put(Key key, Value val){
		checkNullKey(key); 

		// Null values are the equivalent of deleting a key,value pair 
		if (val == null) {
            delete(key);
            return;
        }

        // Need to update the value if the key already exists
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }

        // Otherwise add a new node at the beginning 
        first = new Node(key, val, first);
        n++;
	}

	// Returns the value paired with the key 
	// Returns null if the key is not in the table
	// "Search operation" 
	public Value get(Key key){
		checkNullKey(key);

		// Traverse the list until we find a key that is equal
		for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }

        // If we don't find anything, return null 
        return null;
	}

	// Remove the key (and its value) from the table 
	public void delete(Key key){
		checkNullKey(key); 
		first = deleteHelper(first, key);
	} 

	private Node deleteHelper(Node x, Key key) {
        // If we have an empty list 
        if (x == null) return null;

        // Delete and update 
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        // Otherwise keep going through the linked list 
        x.next = deleteHelper(x.next, key);
        return x;
    }


	public static void main(String[] args){
		// Application: Simplified search engine 
		// Keys: Strings with terms (e.g., "cat", "dog")
		// Values: Integers for the webpage ids (only 1 per term)
		SequentialSearch<String, Integer> ss = new SequentialSearch<String, Integer>(); 

		// Test put and size  
		ss.put("cat", 0); 
		ss.put("dog", 2); 
		ss.put("horse", 1);
		assert ss.size() == 3; 

		// Test get 
		assert ss.get("cat") == 0; 
		assert ss.get("truck") == null; 

		//Test delete
		ss.delete("dog"); 
		assert ss.get("dog") == null;
		assert ss.size() == 2; 
	}
}