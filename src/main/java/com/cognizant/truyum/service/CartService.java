package com.cognizant.truyum.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;

	public void addCartItem(long userId, long menuItemId) throws CartEmptyException {
		cartDao.addCartItem(userId, menuItemId);
	}

	public Cart getAllCartItems(long userId) throws CartEmptyException, ParseException {
		return cartDao.getAllCartItems(userId);

	}

	public void removeCartItem(long userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}

}
