 import java.util.ArrayList;
 import java.util.Scanner;
 import java.util.Iterator;

 public class WorldCar {
	 public static void main(String[] args) {
		 ArrayList<Car> carList = new ArrayList<>();
		 Scanner sc = new Scanner(System.in);

		 try {
			 System.out.println("Enter the car information");
			 for(int i=0;i<5;i++) {
				 System.out.println("Enter the car name:");
				 String input1=sc.nextLine();
				 carList.add(i,Car.setCarName(input1));
				 System.out.println("Enter the car model:");
				 String input2=sc.nextLine();
				 carList.add(i,Car.setCarModel(input2));
				 System.out.println("Enter the car year:");
				 int input3=sc.nextInt();
				 Car car = new Car(input1,input2,input3);
				 carList.add(car);
			 }
		 }
		 catch(Exception e) {
			 System.out.println(e.getMessage());



		 }








