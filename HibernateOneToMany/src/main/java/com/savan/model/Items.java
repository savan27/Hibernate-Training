/**
 * 
 */
package com.savan.model;

/**
 * @author SAVAN
 *
 */
public class Items {

	private long id;
	private String itemId;
	private double itemTotal;
	private int quantity;
	private Cart cart;
	
	
	/**
	 * no-arguments Constructor
	 */
	public Items() {
	}
	/**
	 * @param itemId
	 * @param itemTotal
	 * @param quantity
	 * @param cart
	 */
	public Items(String itemId, double itemTotal, int quantity, Cart cart) {
		this.itemId = itemId;
		this.itemTotal = itemTotal;
		this.quantity = quantity;
		this.cart = cart;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the itemTotal
	 */
	public double getItemTotal() {
		return itemTotal;
	}
	/**
	 * @param itemTotal the itemTotal to set
	 */
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
