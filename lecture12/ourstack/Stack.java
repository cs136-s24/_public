package ourstack; 

public interface Stack<Item>{

	// Pushes an item onto the stack 
	public abstract void push(Item item);

	// Remove the most recently added item
	public abstract Item pop(); 

	// Returns true if the stack is empty 
	public abstract boolean isEmpty(); 

	// Returns the number of items in the stack 
	public abstract int size(); 
}