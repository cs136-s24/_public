/**
 * An interface for a first-in-first-out (FIFO) Queue 
 */

package ourqueue; 

public interface Queue<Item>{
	 // Returns true if the queue is empty 
	public abstract boolean isEmpty(); 

	// Returns the number of items in the queue 
	public abstract int size();

	// Adds an item to the end of the queue 
	public abstract void enqueue(Item item); 

	// Returns the element that is first in the queue 
	// (and removes that item from the queue) 
	public abstract Item dequeue(); 

	// Returns the element that is first in the queue (but does NOT remove it)
	public abstract Item peek(); 
}