/* Problem Statement:

You are given a list of pairs of integers, where each pair represents the coordinates of a point in a 2D plane. Your task is to create a BiConsumer that processes each pair of integers by calculating and printing the Euclidean distance from the origin (0, 0) for each point. The Euclidean distance for a point (x, y) is given by the formula:

*/

import java.util.function.BiConsumer;
import java.util.List;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		List<Integer> points = Arrays.asList(3,4,6,8,0,5);
		BiConsumer<Integer, Integer> calculateDistance = (x,y) -> {
			double distance = Math.sqrt(x*x+y*y);
			System.out.println("Distance from (" + x + ", " + y + ") to origin: " + distance);
		};
		processPoints(points,calculateDistance);
	}

	public static void processPoints(List<Integer> points, BiConsumer<Integer,Integer> biConsumer) {
		for(int i=0;i<points.size();i+=2){
			int x=points.get(i);
			int y=points.get(i+1);
			biConsumer.accept(x,y);
		}
	}
}

