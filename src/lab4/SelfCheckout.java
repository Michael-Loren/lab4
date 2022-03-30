package lab4;

import java.util.EnumMap;

public class SelfCheckout {

	private EnumMap<Item, Integer> cart = new EnumMap<Item, Integer>(Item.class);
	private double totalWeight = 0;
	private double totalPrice = 0;


	/**
	 * 
	 * @param e   - Item to target
	 * @param qty - Amount to change. Positive values add items, negative values
	 *            remove items. If quantity of item in the cart ends up becoming <=
	 *            0, remove item
	 *            from cart
	 */
	public void changeItemQty(Item e, int qty) {
		if (qty == 0)
			return; // save pointless computation

		totalPrice += e.getPrice() * qty;
		totalWeight += e.getWeight() * qty;
		if (this.cart.containsKey(e)) {

			qty += cart.get(e);

			// quantity is absolute, negative values don't make sense
			if (qty <= 0) {
				totalPrice -= e.getPrice() * qty;
				totalWeight -= e.getWeight() * qty; // prevent negative values
				remove(e);
				return;
			}
		}

		cart.put(e, qty);
	}

	/**
	 * Helper method to remove item from cart
	 * 
	 * @param e - if present, removes item with this key value
	 */
	public void remove(Item e) {
		cart.remove(e);
	}

	public EnumMap<Item, Integer> getCart() {
		return cart;
	}

	@Override
	public String toString() {
		return cart.toString();
	}

	public void displayCart() {
		System.out.printf("%n%-15s %-15s %-15s %-15s\n", "ITEM", "QUANTITY", "PRICE", "WEIGHT");
		cart.forEach((key, val) -> {
			System.out.printf("%-15s %-15d $%-15.2f %-15.2f%n", key, val, key.getPrice(), key.getWeight());
		});

		System.out.printf("%nTotal price: %.2f%nTotal weight: %.2f%n", totalPrice, totalWeight);
	}

	public void clear() {
		cart.clear();
		totalWeight = 0;
		totalPrice = 0;
		System.out.println("\nCleared cart\n");
	}

	public static void main(String[] args) {

		SelfCheckout f = new SelfCheckout();
		f.changeItemQty(Item.MILK_GALLON, 1);
		f.displayCart();
		f.changeItemQty(Item.MILK_QUART, 3);
		f.displayCart();
		f.changeItemQty(Item.MILK_GALLON, 4);
		f.displayCart();
		f.changeItemQty(Item.MILK_GALLON, -2);
		f.displayCart();

		f.clear();

		f.displayCart();

	}

}
