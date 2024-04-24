package bacon;  

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * @param  item the item to add to this bag
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    /**
     * An Iterator for the nodes we have in linked lists
     */
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

         public LinkedIterator(Node<Item> initial) {
            current = initial;
        }

        public boolean hasNext()  {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        // Example usage 
        Bag<Integer> bag = new Bag<Integer>(); 
        bag.add(1); 
        bag.add(2); 
        bag.add(4); 

        for(Integer item : bag){
            System.out.println(item); 
        }
    }

}