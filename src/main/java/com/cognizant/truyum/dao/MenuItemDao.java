package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin()
			throws ClassNotFoundException, IOException, SQLException, ParseException;

	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException;

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(Long menuItemId);

}
