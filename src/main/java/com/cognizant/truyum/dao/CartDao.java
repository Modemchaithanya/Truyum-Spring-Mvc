package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId) throws CartEmptyException;

	public Cart getAllCartItems(long userId) throws CartEmptyException, ParseException;

	public void removeCartItem(long userId, long menuItemId);
}
