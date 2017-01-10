package com.yin.clothes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yin.clothes.dao.UserDao;
import com.yin.clothes.dto.User;


public class UserDaoImp implements UserDao{

	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO tbl_user(name, password) values (?, ?, ?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.execute();

	}

	/**
	 * id    准备更新的用户的ID
	 * user  新的用户信息
	 */
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql = "UPDATE tbl_user SET name = ?, password = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setLong(3, id);
		ps.execute();
	}

	/**
	 * 根据用户ID删除指定用户
	 */
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_user WHERE id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
	}

	@Override
	public ResultSet get(Connection conn,  User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_user WHERE s_username = ? AND s_password = ?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		return ps.executeQuery();
	}
}
