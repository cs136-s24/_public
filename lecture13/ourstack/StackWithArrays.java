package ourstack; 

public class StackWithArrays<Item> implements Stack<Item> {
    
    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private Item[] arr;         // array of items
    private int numItems;       // number of elements on stack

    /**
     * Initializes an empty stack.
     */
    public StackWithArrays() {
        arr = (Item[]) new Object[INIT_CAPACITY];
        numItems = 0;
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return numItems == 0;
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return numItems;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < numItems; i++) {
            copy[i] = arr[i];
        }
        arr = copy;
    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(Item item) {
        if (numItems == arr.length){
            resize(2*arr.length);    // double size of array if necessary
        }
        arr[numItems++] = item;                            // add item
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     */
    public Item pop() {
        if (isEmpty()){
            System.out.println("Stack is empty"); 
            return null; 
        }
        Item item = arr[numItems-1];
        arr[numItems-1] = null;                             
        numItems--;
        return item;
    }

    public static void main(String[] args) {
        StackWithArrays<Integer> s = new StackWithArrays<Integer>(); 
        int n = 10; 
        while (n>0){
            s.push(n % 2); 
            n = n/2; 
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()); 
        }
        System.out.println(); 
    }
}
