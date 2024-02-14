package zoostuff;

public class Zookeeper{

	public static void main(String[] args){
		Zoo ourZoo = new Zoo(2); 

		ourZoo.addAnimal(new Animal("Leo", "Lion"));
		ourZoo.addAnimal(new Animal("Manny", "Elephant"));
		ourZoo.addAnimal(new Animal("Stripes", "Zebra")); 

	}
}