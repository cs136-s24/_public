package zoostuff;

public class Zoo{

	public Animal[] animals; 
	public int count; 

	public Zoo(int capacity){
		this.animals = new Animal[capacity]; 
		this.count = 0; 
	}

	public void addAnimal(Animal animal){
		if(count < animals.length){
			animals[count] = animal; 
			count ++; 
			System.out.println(animal.toString()+" added too the zoo.");
		}
		else{
			System.out.println("Zoo full!!"); 
		}

	}
}