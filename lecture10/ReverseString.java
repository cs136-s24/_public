public class ReverseString{

	public static String mystery(String s){
		int strLen = s.length(); 

		if(strLen <=1){
			return s; 
		}

		String a = s.substring(0, strLen/2);
		String b = s.substring(strLen/2, strLen); 
		return mystery(b) + mystery(a);  
	}

	public static void main(String[] args){
		System.out.println(mystery("gates"));
	}
}