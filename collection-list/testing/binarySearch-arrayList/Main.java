import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(10000000);

		for(int i=1;i<=10000000;i++) {
			arr.add(i);
		}

		Collections.shuffle(arr);
		Collections.sort(arr);
		
		for(int i=0;i<=10000000;i++) {
			int key=(int)(Math.random()*10000000)+1;
			int index=Collections.binarySearch(arr,key);

			if(index>=0) {
				System.out.println("Found " + key + " at index " + index);
			}
			else {
				System.out.println(key+ " not found");
			}
		}
	}
}


