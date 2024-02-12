public class Car{
	// 1. Instance variables

	// Variables with `final` keyword will not change 
	public final double horsePower;
	public final String make, model;

	// Here, we have (non-final) variables that might change 
	public String color; 
	public boolean isBlackWhite;


	// private variables are not accessible outside of the class
	private String vinNumber; // A VIN number is "Vehicle Identification Number"
							  // analogous to a social security number for humans 

	// A static variable (so this is not an instance variable)
	// and thus belong to the entire class 
	public static int totalCars = 0;   

	// 2. Constructor
	public Car(String color){
		this.color = color;

		setBlackWhite(color);

		this.horsePower = 0.0; 
		this.make = ""; 
		this.model = ""; 
		this.vinNumber = "";  
	}

	// Overloaded constructor 
	public Car(String make, String model, String color_input, double horsePower){
		// We don't need `this` to refer to the instance variable `color` 
		color = color_input;
		// Alternatively: this.color = color_input 

		// `this` is helpful when constructer parameters are the same as
		// the field variables 
		this.make = make; 
		this.model = model; 
		this.horsePower = horsePower; 
		
		// Sometimes, we have a more complicated expression within a constructor 
		setBlackWhite(color);

		// This will increase for every time we make a new Car object 
		totalCars += 1; 

		// Contrived VIN number example 
		vinNumber = "A"+totalCars; 
	}
	
	// 3. Instance methods
	public void setBlackWhite(String color){
		if(color == "black" || color == "white"){
			this.isBlackWhite = true; 
		}
		else{
			this.isBlackWhite = false; 
		}
	}

	public void repaint(String newColor){
		this.color = newColor; 
	}

	// Getter
	public String getVIN(){
		return this.vinNumber; 
	}

	// Setter
	public void setVIN(String newVin){
		this.vinNumber = newVin; 
	}

	// 4. Static methods
	public static boolean hasFourWheels(){
		return true; 
	} 

	// 5. Main
	public static void main(String[] args){
		// Testing our constructor
		Car car1 = new Car("Ford", "F150", "red", 700.0); 
		Car car2 = new Car("Honda", "Fit", "white", 130.0);
		System.out.println(car1.isBlackWhite);
		System.out.println(car2.isBlackWhite);  

		// Getter (public instance variable)
		Car car3 = new Car("white");
		car3.repaint("pink"); 
		System.out.println(car3.color); // Using the dot operator 

		// Setters (public instance variable ) 
		car3.color = "blue";
		System.out.println(car3.color); 

		// Getter (private instance variable)
		Car car4 = new Car("Mercedes-Benz", "420", "blue", 201.0);
		System.out.println(car4.getVIN()); 

		// Setter (private instance variable)
		car4.setVIN("A12345"); 
		System.out.println(car4.getVIN());
	}
}