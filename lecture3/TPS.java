public class TPS{

	public static void negate(int a){
		a = -1 * a; 
	}

	public static void main(String[] args){
		int a = 17; 
		System.out.println(a); 
		negate(a); 
		System.out.println(a); 
	}

}