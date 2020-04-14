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
		private String name;
		private Set<Items> items;
		
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
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the items
		 */
		public Set<Items> getItems() {
			return items;
		}
		/**
		 * @param items the items to set
		 */
		public void setItems(Set<Items> items) {
			this.items = items;
		}
}
