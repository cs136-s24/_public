public class Recurse{

	/**
	 * Problem #4: 
	 * 
	 * @param setofNums A set of integer numbers 
	 *                  (here, the "set" refers to there being no duplicates) 
	 * @param targetSum An integer
	 * @return true if a subset of setofNums can equal the targetSum;
	 *         otherwise return false 
	 * 
	 * Examples: 
	 * 	1. setofNums={3, 7, 1, 8, -3}, targetSum=4->true (since 3+1=4)
	 *  2. setofNums={3, 7, 1, 8, -3}, targetSum=13-> false (since no combination can make the target sum)
	 * 
	 * Notes: 
	 * - You may find it helpful to write a helper method for this problem.  
	 */
	public static boolean p4_canMakeSum(int[] setOfNums, int targetSum){
		return helper(setOfNums, targetSum, 0);
		
	}

	public static boolean helper(int[] setOfNums, int currentSum, int index){
		// Base case(s)
		if (currentSum == 0){
			//return true; 
			return false;
		}
		else if(index == setOfNums.length){
			return false; 
		}
		// Recursive step 

		// Branch 1: Including element 
		boolean branch1 = helper(setOfNums, currentSum - setOfNums[index], index+1); 

		// Branch 2: Exclude element 
		boolean branch2 = helper(setOfNums, currentSum, index+1); 

		return branch1 || branch2; 
	}
	
	public static void main(String[] args){
		int[] setOfNums = {3, -1, 1}; 
		boolean check1 = p4_canMakeSum(setOfNums, 4); 
		boolean check2 = p4_canMakeSum(setOfNums, 10); 
		System.out.println(check1);
		System.out.println(check2);

		assert check1 == true: "Check1 fails!"; 
		assert check2 == false: "Check2 fails!";

	}
}