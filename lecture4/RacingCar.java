public class RacingCar{
	public double horsePower;
	public String make; 

	public RacingCar(double hp, String make){
		this.horsePower = hp; 
		this.make = make; 
	}

	public static RacingCar race(RacingCar leftCar, RacingCar rightCar){
		// Ties go to the car on the left
		if (leftCar.horsePower >= rightCar.horsePower){
			return leftCar; 
		}
		else{
			return rightCar; 
		}
	}

	public static void swap(RacingCar leftCar, RacingCar rightCar){
		RacingCar temp = leftCar; 
		leftCar = rightCar; 
		rightCar = temp;
		temp.make = "honda";  
	}

	public static void main(String[] args){
		RacingCar car1 = new RacingCar(1605.0, "ford");
		RacingCar car2 = new RacingCar(1500.0, "ferrari"); 

		//TPS 1
		RacingCar winner = race(car1, car2);
		System.out.println(winner.make);  

		// TPS 2 
		swap(car1, car2); 
		System.out.println(car1.horsePower+" "+car1.make);
	}
}