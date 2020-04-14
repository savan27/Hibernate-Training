package com.savan.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author SAVAN
 *
 */
@Embeddable
public class Address {
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "stste")
	private String stste;
	
	@Column(name = "country")
	private String country;

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the stste
	 */
	public String getStste() {
		return stste;
	}

	/**
	 * @param stste the stste to set
	 */
	public void setStste(String stste) {
		this.stste = stste;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
