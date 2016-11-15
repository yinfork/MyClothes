package com.yin.clothes.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yin.clothes.dao.UserDao;
import com.yin.clothes.dao.impl.UserDaoImp;
import com.yin.clothes.dto.User;
import com.yin.clothes.util.ConnectionFactory;


public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDaoImp();

	public boolean check(User user) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			ResultSet resultSet = userDao.get(conn, user);
			while (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if(null != conn){
					conn.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if(null != conn){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 取得参数username的值
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("upwd");

		System.out.println("用户名 ==》 " + uname);
		System.out.println("密码 ==》 " + passwd);

		RequestDispatcher rd = null;
		String forward = null;
		if (uname == null || passwd == null) {
			request.setAttribute("msg", "用户名或密码为空");
			rd = request.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		} else {
			User user = new User();
			user.setName(uname);
			user.setPassword(passwd);
			boolean bool = check(user);

			if (bool) {
				forward = "/clothesServlet";
			} else {
				forward = "/login.html";
			}

			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}
}
