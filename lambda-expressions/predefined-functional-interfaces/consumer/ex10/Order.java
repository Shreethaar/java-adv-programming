public class Order {
	private String productName;
	private double productPrice;
	private int productQuantity;
	
	public Order() {

	}

	public Order(String productName, double productPrice, int productQuantity) {
		this.productName=productName;
		this.productPrice=productPrice;
		this.productQuantity=productQuantity;
	}

	public void setProductName(String productName) {
		this.productName=productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice=productPrice;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity=productQuantity;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
}

