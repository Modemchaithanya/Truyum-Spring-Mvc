package com.cognizant.truyum.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class MenuItem {
	private Long id;
	@NotEmpty(message = "Title is required")
	@Size(min = 2, max = 65, message = "Title should have 2 to 65 characters")
	private String name;
	@NotNull(message = "Price is required")
	// @Min(value = 0, message = "Price has to be a number")
	// @Max(value = (long) Float.MAX_VALUE, message = "Price has to be a number")
	private float price;
	private boolean active;
	@NotNull(message = "Launch Date required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

	public MenuItem() {

	}

	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return String.format(
				"MenuItem [id=%s, name=%s, price=%s, active=%s, dateOfLaunch=%s, category=%s, freeDelivery=%s]", id,
				name, price, active, dateOfLaunch, category, freeDelivery);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
