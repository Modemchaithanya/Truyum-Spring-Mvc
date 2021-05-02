package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

class MenuItemDaoSqlImplTest {
	public static void main(String[] args) {

	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException, ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> lst = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : lst) {
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getDateOfLaunch());
		}
	}

	@Test
	void testGetMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> lst = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : lst) {
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getDateOfLaunch());
		}

	}

	@Test
	void testModifyMenuItem() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItem = new MenuItem(2L, "burger", 88.00f, true, DateUtil.convertToDate("2022/06/24"), "Starters",
				true);
		menuItemDao.modifyMenuItem(menuItem);

	}

	@Test
	void testGetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(2L);
		System.out.println(menuItem.getName());
		System.out.println(menuItem.getCategory());
	}

}
