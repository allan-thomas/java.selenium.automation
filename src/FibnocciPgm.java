import java.util.Scanner;

public class FibnocciPgm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int First = 0, Second = 1, next;

		Scanner inScanner = new Scanner(System.in);
		
		int num = inScanner.nextInt();
		
		for (int i =0;i<num;i++) {
			next = First + Second;
			System.out.println(First);
			First = Second;
			Second =next;
		}

	}

}
