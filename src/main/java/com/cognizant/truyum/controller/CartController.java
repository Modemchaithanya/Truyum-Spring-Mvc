package com.cognizant.truyum.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam String id, ModelMap model)
			throws NumberFormatException, CartEmptyException, ParseException {
		LOGGER.info("start");
		cartService.addCartItem(1, Long.valueOf(id));
		model.put("addCartStatus", true);
		LOGGER.info("End");
		return "forward:/show-menu-list-customer";

	}

	@GetMapping("/show-cart")
	public String showCart(ModelMap model) throws NumberFormatException, CartEmptyException, ParseException {
		LOGGER.info("start");
		try {
			model.addAttribute("cart", cartService.getAllCartItems(1));
		} catch (CartEmptyException e) {
			return "cart-empty";
		}
		LOGGER.info("End");
		return "cart";

	}

	@GetMapping("/remove-cart-item")
	public String removeCart(@RequestParam String id, ModelMap model) throws ParseException {
		LOGGER.info("start");
		cartService.removeCartItem(1, Long.valueOf(id));
		try {
			cartService.getAllCartItems(1);
		} catch (CartEmptyException e) {
			return "cart-empty";
		}
		model.addAttribute("removeCartItemStatus", true);
		LOGGER.info("End");
		return "forward:/show-cart";
	}

}
