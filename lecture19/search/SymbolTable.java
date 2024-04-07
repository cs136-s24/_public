package search;

public interface SymbolTable<Key, Value>{

	// Put the key-value pair into the table 
	// If val is null, remove key from the table
	public abstract void put(Key key, Value val); 

	// Returns the value paired with the key 
	// Returns null if the key is not in the table
	// "Search operation" 
	public abstract Value get(Key key);

	// Remove the key (and its value) from the table 
	public abstract void delete(Key key); 

	// Is the table empty? 
	public abstract boolean isEmpty();

	// Returns the number of keys 
	public abstract int size();   
}