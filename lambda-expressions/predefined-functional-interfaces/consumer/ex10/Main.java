import java.util.function.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Order order1 = new Order();
		order1.setProductName("Headphones");
		order1.setProductPrice(100.0);
		order1.setProductQuantity(2);

		Consumer<Order> processOrder = order -> {
			System.out.println("Order details:");
			System.out.println("Product Name: " + order.getProductName());
			System.out.println("Price: " + order.getProductPrice());
			System.out.println("Price: " + order.getProductQuantity());

			double discount = 0.1 * order.getProductPrice();
			order.setProductPrice(order.getProductPrice() - discount);
			System.out.println("Discounted price: " + order.getProductPrice());
		};

		processOrder.accept(order1);
		
	}
}

