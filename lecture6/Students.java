// To use ArrayLists, we must import them 

import java.util.ArrayList; 

public class Students{

	// Incorrect version 
	// Yikes! Tries to modify the object we're iterating over

	// public static ArrayList<String> compareRemove(ArrayList<String> studentGroup){
	// 	for (String name : studentGroup){
	// 	    if ( name.charAt(0) < 'E'){
	// 			studentGroup.remove(name); 
	// 		} 
	// 	}
	// 	return studentGroup;
	// }

	// Correct version 
	public static ArrayList<String> compareRemove(ArrayList<String> studentGroup){

		// Make a new copy of all the data 
		ArrayList<String> newGroup = new ArrayList<String>(studentGroup.size()); 
		for (String element: studentGroup){
			newGroup.add(element); 
		}

		// Now we can iterate through 
		for (String name : studentGroup){
		    if ( name.charAt(0) < 'E'){
				newGroup.remove(name); 
			} 
		}
		return newGroup;
	}

	public static void main(String[] args){

		// Declare and create an ArrayList object with capacity 5 
		ArrayList<String> studentGroup = new ArrayList<String>(5); 

		// Add elements to the array list 
		studentGroup.add("Mali");
		studentGroup.add("Chris");
		studentGroup.add("Divine"); 
		studentGroup.add("Temani"); 

		// This implicitly calls studentGroup.toString() 
		System.out.println(studentGroup); 

		// Retrieve elements 
		System.out.println(studentGroup.get(0));
		System.out.println(studentGroup.get(2)); 

		// Removing an element 
		studentGroup.remove("Chris");
		System.out.println(studentGroup);

		// Iterating through elements in a an ArrayList 
		for (String name : studentGroup){
		   System.out.println(name+ " signed up");
		}

		// Remove from our ArrayList any students whose names start 
		// with a letter before E
		studentGroup.add("Divine"); 
		studentGroup.add("Chris"); 
		ArrayList<String> out = compareRemove(studentGroup);
		System.out.println(out); 

	}
}