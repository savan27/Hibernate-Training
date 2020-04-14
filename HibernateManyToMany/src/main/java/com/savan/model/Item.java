/**
 * 
 */
package com.savan.model;

import java.util.Set;

/**
 * @author SAVAN
 *
 */
public class Item {
	
	private long id;
	private double price;
	private String description;
	
	private Set<Cart> carts;
	
	

	/**
	 * no-arguments Constructor
	 */
	public Item() {
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the carts
	 */
	public Set<Cart> getCarts() {
		return carts;
	}

	/**
	 * @param carts the carts to set
	 */
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
}
