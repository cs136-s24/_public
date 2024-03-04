package ourstack; 

public class StackWithLinkedLists<Item> implements Stack<Item>{
    // We'll keep these private since we just want the stack operations 
    private Node<Item> first;     // top of stack
    private int numItems;         // size of the stack

    // Inner Node class 
    private static class Node<Item> {
        private Item data;
        private Node<Item> next;

        private Node(){
            this.data = null; 
            this.next = null; 
        }
    }

    /**
     * Constructor 
     * Initializes the empty stack 
     */
    public StackWithLinkedLists() {
        first = null;
        numItems = 0; 
    }

    
    /**
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return the number of items in this stack
     */
    public int size() {
        return this.numItems;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.data = item;
        first.next = oldfirst;
        numItems++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     */
    public Item pop() {
        if (isEmpty()){
            System.out.println("Stack is empty"); 
            return null; 
        }
        Item item = first.data;        // save item to return
        first = first.next;            // delete first node
        numItems--;
        return item;                   // return the saved item
    }

    public static void main(String[] args) {
        StackWithLinkedLists<String> stack = new  StackWithLinkedLists<String>();
            
        // Push some onto the stack
        stack.push("Webpage visited at 9am"); 
        stack.push("Webpage visited at 10am"); 
        stack.push("Webpage visited at 12pm");

        while(!stack.isEmpty()){
            System.out.println("Back button to:"+stack.pop());
        }
    }
}