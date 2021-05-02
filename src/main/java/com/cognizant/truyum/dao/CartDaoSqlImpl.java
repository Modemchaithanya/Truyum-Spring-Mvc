package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub

		boolean existInCart = false;
		try {
			Cart cart = getAllCartItems(userId);
			if (!(cart.getMenuItemList().isEmpty())) {
				for (MenuItem menu : cart.getMenuItemList()) {
					if (menu.getId() == menuItemId) {
						existInCart = true;
					}
				}

			}
		} catch (CartEmptyException e) {

		}

		if (!existInCart) {
			try {
				Connection con = ConnectionHandler.getConnection();

				String Query = "insert into cart(uid,menuid)" + "values (?,?) ";
				PreparedStatement stmt = con.prepareStatement(Query);
				stmt.setLong(1, userId);
				stmt.setLong(2, menuItemId);
				stmt.execute();
			} catch (ClassNotFoundException | IOException | SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		}

		/*
		 * try { Connection con = ConnectionHandler.getConnection(); String Query =
		 * "insert into cart(uid,menuid)" + "values (?,?) "; PreparedStatement stmt =
		 * con.prepareStatement(Query); stmt.setLong(1, userId); stmt.setLong(2,
		 * menuItemId); stmt.execute(); } catch (ClassNotFoundException | IOException |
		 * SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		MenuItem menu = null;
		List<MenuItem> lst = new ArrayList<>();
		Cart cart = null;
		try {
			Connection con = ConnectionHandler.getConnection();

			cart = new Cart(lst, 0);

			String query = "select * from menu_item JOIN cart ON menu_item.id = cart.menuid where cart.uid = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			float total = 0.00f;
			while (rs.next()) {
				menu = new MenuItem(rs.getLong("id"), rs.getString("name"), rs.getFloat("price"),
						rs.getBoolean("active"), rs.getDate("dateOfLaunch"), rs.getString("category"),
						rs.getBoolean("freeDelivery"));
				total = total + rs.getFloat("price");
				lst.add(menu);

			}

			if (lst.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");
			}
			cart.setTotal(total);
			System.out.println(total);
			cart.setMenuItemList(lst);

		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionHandler.getConnection();
			String query = "delete from cart where uid = ? AND menuid = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
