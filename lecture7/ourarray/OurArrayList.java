package ourarray; 

public class OurArrayList<T> implements OurListInterface<T>{

    private static final int DEFAULT_INITIAL_CAPACITY = 10; 
    private static final double GROWTH_FACTOR = 2.0; 

	private Object[] privateArray; 
    private int currentNumElements; 

    public OurArrayList(int capacity){
        privateArray = new Object[capacity]; 
        currentNumElements = 0;
    }

    // Overloaded constructor 
    public OurArrayList(){
        this(DEFAULT_INITIAL_CAPACITY); 
    }

    public int size(){
    	return this.currentNumElements; 
    }

    public String toString(){
        String out = "["; 
        for(int i=0; i<this.currentNumElements; i++){
            out += privateArray[i].toString()+", ";
        }
        out += "]"; 
        return out; 
    }

    public void add(T element) {
        checkExpand();
        privateArray[currentNumElements++] = element; // Using the post-increment operator (++)
                                                    // this will increment currentNumElements by one but return the old value 
    }

    /**
     * Checks if the underlying array has capacity,
     * if it does not, it expands it by the set GROWTH_FACTOR  
     */ 
    private void checkExpand() {
        if (this.currentNumElements == privateArray.length) {
            int newSize = (int) (privateArray.length * GROWTH_FACTOR); // This will cast to an int and truncate the decimal 
            Object[] newArray = new Object[newSize];
            

            // Copy over the elements: 
            for(int i =0; i<privateArray.length; i++){
                newArray[i] = privateArray[i]; 
            }

            // Update what our instance variable refers to by aliasing
            this.privateArray = newArray; 
        }
    }

    public void remove(T element){
        // We'll remove the first time element occurs

        Object[] newArray = new Object[privateArray.length]; 

        boolean removedFirst = false;

        for(int i=0, j=0; i<currentNumElements; i++){
            if(privateArray[i].equals(element) & !removedFirst){
                removedFirst = true; 
                continue; 

            }
            newArray[j++] =  privateArray[i];
        }

        // Update the instance variables 
        this.privateArray = newArray; 
        this.currentNumElements --; 
    }

    public void set(int index, T element){
        if (index < 0 || index >= this.currentNumElements){
            System.out.println("Index out of range"); 
        }
        else{
            this.privateArray[index] = element; 
        }  
    }

    // TODO 
    public T get(int index){
        return null; 
    }

	public static void main(String[] args){
        // Some testing for our implementation 
        OurArrayList<String> test = new OurArrayList<String>(); 
        System.out.println(test.size()); // Should be 0
        System.out.println(test.toString()); 

        // Let's test adding something 
        test.add("a");
        test.add("b"); 
        test.add("c"); 
        System.out.println(test.toString()); 

        // Testing removing 
        test.remove("b"); 
        System.out.println(test.toString()); 
	}
}