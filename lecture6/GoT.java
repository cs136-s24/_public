import java.util.ArrayList;


// Base class for all characters in Game of Thrones
class GoTCharacter {
    String name;
    String house;

    public GoTCharacter(String name, String house) {
        this.name = name;
        this.house = house;
    }

    public void declare() {
        System.out.println(name + " of House " + house + " stands proud.");
    }
}

// Knight class extending GoTCharacter
class Knight extends GoTCharacter {

    public int strength; 

    public Knight(String name, String house, int strength) {
        super(name, house);
        this.strength = strength; 
    }

    @Override
    public void declare() {
        System.out.println("For the honor of House " + house + ", I, " + name + ", will fight until my last breath!");
    }

    /**
     * A method to increase the strength of a knight 
     *  
     * @param amountIncrease is the amount to increase the Knight's strength
    */
    public void increaseStrength(int amountIncrease){
        this.strength += amountIncrease; 
    }
}

public class GoT{

    public static void main(String[] args) {
        // Creating an ArrayList to hold an alliance of characters
        ArrayList<GoTCharacter> characters = new ArrayList<GoTCharacter>();

        // Adding characters
        characters.add(new GoTCharacter("Sansa", "Stark"));
        characters.add(new Knight("Brienne", "Tarth", 10));
        characters.add(new Knight("Sandor", "Clegane", 9));


        for (GoTCharacter character : characters){
            character.declare();
        }
    }
}