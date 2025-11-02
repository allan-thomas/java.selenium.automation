
import java.util.ArrayList;
import java.util.Arrays;

public class geekforgeeks {

	public static void main(String[] args) {

		String s = "SONA",revString ="";
		String c="a"; System.out.println(s.length()); 

		for (int i = s.length()-1; i >= 0; i--) {
			revString = revString + s.charAt(i);
		}
		System.out.println(revString);
		
		ArrayList<String> arr = new ArrayList<String>(Arrays.asList("A",""));
		System.out.println(arr.contains(c));

	}
}
