package com.cognizant.truyum.dao;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

class CartDaoSqlImplTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(2L, 1L);

	}

	@Test
	void testGetAllCartItems() throws CartEmptyException, ParseException {
		CartDao cartDao = new CartDaoSqlImpl();
		Cart cart = cartDao.getAllCartItems(2L);
		for (MenuItem menu : cart.getMenuItemList()) {
			System.out.println(menu.getName());
			System.out.println(menu.isActive());
			System.out.println(menu.getDateOfLaunch());
		}
	}

	@Test
	void testRemoveCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1L, 2L);

	}

}
