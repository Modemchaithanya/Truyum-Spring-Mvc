package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> list = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select * from menu_item");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			MenuItem menu = new MenuItem(rs.getLong("id"), rs.getString("name"), rs.getFloat("price"),
					rs.getBoolean("active"), rs.getDate("dateOfLaunch"), rs.getString("category"),
					rs.getBoolean("freeDelivery"));
			list.add(menu);
			/*
			 * for (MenuItem menuItem : list) {
			 * System.out.println(menuItem.getDateOfLaunch()); }
			 */
		}
		return list;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> list = new ArrayList<>();

		PreparedStatement stmt = con
				.prepareStatement("select * from menu_item where active=true AND dateOfLaunch < NOW()");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			MenuItem menu = new MenuItem(rs.getLong("id"), rs.getString("name"), rs.getFloat("price"),
					rs.getBoolean("active"), rs.getDate("dateOfLaunch"), rs.getString("category"),
					rs.getBoolean("freeDelivery"));
			list.add(menu);
		}

		return list;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub]
		Long pid = menuItem.getId();
		String pname = menuItem.getName();

		Float pprice = menuItem.getPrice();
		java.sql.Date pDate = new java.sql.Date(menuItem.getDateOfLaunch().getTime());
		String pcategory = menuItem.getCategory();
		boolean pdelivery = menuItem.isFreeDelivery();
		boolean pactive = menuItem.isActive();
		try {
			Connection con = ConnectionHandler.getConnection();
			String query = "update menu_item "
					+ "set name = ?,price = ?,active = ?,dateOfLaunch = ?,category = ?,freeDelivery = ?"
					+ " where id = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, pname);
			stmt.setFloat(2, pprice);
			stmt.setBoolean(3, pactive);
			stmt.setDate(4, pDate);
			stmt.setString(5, pcategory);
			stmt.setBoolean(6, pdelivery);
			stmt.setLong(7, pid);
			stmt.executeUpdate();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) {
		// TODO Auto-generated method stub
		MenuItem menu = null;
		try {
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from menu_item where id=" + menuItemId + " ");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				menu = new MenuItem(rs.getLong("id"), rs.getString("name"), rs.getFloat("price"),
						rs.getBoolean("active"), rs.getDate("dateOfLaunch"), rs.getString("category"),
						rs.getBoolean("freeDelivery"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menu;
	}

}
