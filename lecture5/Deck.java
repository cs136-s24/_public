/*
* Creates a deck of cards 
* Illustrates how to use arrays as instance and static variables
*/
import java.util.Arrays;

public class Deck{
	
	// Instance variable 
	public String[] currentDeck; 

	// Static variables (constants that never changes)
	public static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
    };

    public static final String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };

    // Constructor 
    public Deck(){
        int totalCards = RANKS.length*SUITS.length;

        this.currentDeck = new String[totalCards];

        // Intialize 
        for(int i=0; i<RANKS.length; i++){
            for(int j=0; j<SUITS.length; j++){
                this.currentDeck[SUITS.length*i + j] = RANKS[i]+ " of "+ SUITS[j]; 
            }
        }
    }
    
    public static void main(String[] args){
        Deck deck1 = new Deck(); 
        System.out.println(deck1.currentDeck.length);
        System.out.println(Arrays.toString(deck1.currentDeck)); 
    	
    }

}