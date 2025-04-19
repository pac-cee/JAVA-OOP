package Assignment1Solution.Exercise2_OnlineShopping;

import java.util.*;

public class ShoppingCart {
    private String cartId;
    private List<CartItem> cartItems;
    private double totalPrice;
    private final Customer customer;

    public ShoppingCart(String cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.cartItems = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public boolean addItem(ShoppingItem item, int quantity) {
        if (quantity > item.stockAvailable) {
            System.out.println("Cannot add more than available stock.");
            return false;
        }
        for (CartItem ci : cartItems) {
            if (ci.getItem().itemId.equals(item.itemId)) {
                if (ci.getQuantity() + quantity > item.stockAvailable) {
                    System.out.println("Cart quantity exceeds available stock.");
                    return false;
                }
                ci.increaseQuantity(quantity);
                recalculateTotal();
                return true;
            }
        }
        cartItems.add(new CartItem(item, quantity));
        recalculateTotal();
        return true;
    }

    public boolean removeItem(String itemId) {
        Iterator<CartItem> it = cartItems.iterator();
        while (it.hasNext()) {
            CartItem ci = it.next();
            if (ci.getItem().itemId.equals(itemId)) {
                it.remove();
                recalculateTotal();
                return true;
            }
        }
        return false;
    }

    private void recalculateTotal() {
        totalPrice = 0.0;
        for (CartItem ci : cartItems) {
            totalPrice += ci.getItem().price * ci.getQuantity();
        }
    }

    public double getTotalPrice() { return totalPrice; }
    public List<CartItem> getCartItems() { return cartItems; }
    public Customer getCustomer() { return customer; }
    public String getCartId() { return cartId; }
}

class CartItem {
    private ShoppingItem item;
    private int quantity;
    public CartItem(ShoppingItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public ShoppingItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public void increaseQuantity(int q) { this.quantity += q; }
}
