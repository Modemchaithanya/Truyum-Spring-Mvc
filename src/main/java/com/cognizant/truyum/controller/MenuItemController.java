package com.cognizant.truyum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model)
			throws ClassNotFoundException, IOException, SQLException, ParseException {
		LOGGER.info("start");
		model.put("menuAdmin", menuItemService.getMenuItemListAdmin());
		LOGGER.info("End");
		return "menu-item-list-admin";

	}

	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws ClassNotFoundException, IOException, SQLException {
		LOGGER.info("Start");
		model.put("menuCustomer", menuItemService.getMenuItemListCustomer());
		LOGGER.info("End");

		return "menu-item-list-customer";

	}

	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam String id, ModelMap model, @ModelAttribute MenuItem menuItem) {
		LOGGER.info("Start");
		MenuItem menu = menuItemService.getMenuItem(Long.valueOf(id));
		model.put("menuItem", menu);

		LOGGER.info("End");

		return "edit-menu-item";

	}

	@PostMapping("/edit-menu-item")
	public String editMenuItem(@Valid MenuItem menu, BindingResult bindingResult, ModelMap model) {
		LOGGER.info("Start");
		if (bindingResult.hasErrors()) {
			return "edit-menu-item";
		} else {
			menuItemService.modifyMenuItem(menu);
			model.put("menu", new MenuItem());
			LOGGER.info("End");
			return "edit-menu-item-status";
		}

	}

}
