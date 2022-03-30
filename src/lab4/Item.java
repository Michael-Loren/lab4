package lab4;

public enum Item {
	MILK_QUART(2.99, 2.15),
	MILK_GALLON(4.99, 8.6),
	WATERMELON(2.99, 20),
	CHEETOS(1.99, 0.5);

	private double price;
	private double weight;

	private Item(double price, double weight) {

		this.price = price;
		this.weight = weight;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {

		return this.name();
	}

}
