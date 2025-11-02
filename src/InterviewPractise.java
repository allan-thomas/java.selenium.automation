import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InterviewPractise {

	public static void main(String[] args) {
		
		String name= "Allan Thomas";

		ArrayList<Character> arr = new ArrayList<Character>();

		for(int i=0;i<name.length();i++){
		arr.add(name.charAt(i));
		    
		}

		List<Character> desc= arr.stream().sort(Comparator.reverseOrder()).collect(collectors.toList());

		Collections.sort(arr, Comparator.reverseOrder());
		System.out.println(arr);
	}
}	
		
		// TODO Auto-generated method stub
