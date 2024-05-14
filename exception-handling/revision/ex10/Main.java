import java.util.*;
public class Main {
	public static void main(String[] args) {
		try {
			int arrNum[] = {1,2,3,4,5};
			System.out.println(arrNum[1]);
			System.out.println(arrNum[5]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("Max element is 5");
		}
	}
}

