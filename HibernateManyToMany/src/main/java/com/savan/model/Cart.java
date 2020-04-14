/**
 * 
 */
package com.savan.model;

import java.util.Set;

/**
 * @author SAVAN
 *
 */
public class Cart {
	
	private long id;
	private double total;
	
	private Set<Item> items;
	

	/**
	 * no-arguments Constructor
	 */
	public Cart() {
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
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
