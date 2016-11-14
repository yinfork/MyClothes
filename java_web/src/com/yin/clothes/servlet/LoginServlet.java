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


public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Override
	// protected void service(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// req.setCharacterEncoding("UTF-8");
	//
	// String userName = req.getParameter("uname");
	// String password = req.getParameter("upwd");
	//
	// System.out.println("用户名 ==》 " + userName);
	// System.out.println("密码 ==》 " + password);
	//
	// // 设置HTTP响应的文档类型,此处为Text/html,如果更改为application\msword则设置为word文档格式
	// // resp.setContentType("text/html");
	// // 设置响应所采用的编码方式
	// // resp.setCharacterEncoding("UTF-8");
	//
	// String forward = null;
	//
	// // if (userName.equals("darkmi") && password.equals("jikexueyuan")) {
	// if (userName.equals("极客学院") && password.equals("123456")) {
	//
	// req.getSession().setAttribute("flag", "login_success");
	// // 请求转发
	// forward = "/login/success.jsp";
	// // forward = "http://www.jikexueyuan.com";
	// RequestDispatcher rd = req.getRequestDispatcher(forward);
	// rd.forward(req, resp);
	//
	// // 请求重定向
	// // resp.sendRedirect(req.getContextPath() + "/14/success.jsp");
	// // resp.sendRedirect(forward);
	//
	// } else {
	// req.getSession().setAttribute("flag", "login_error");
	// // 请求转发
	// forward = "/login/error.jsp";
	// // forward = "http://www.jikexueyuan.com";
	// RequestDispatcher rd = req.getRequestDispatcher(forward);
	// rd.forward(req, resp);
	//
	// // 请求重定向
	// // resp.sendRedirect(req.getContextPath() + "/14/error.jsp");
	// // resp.sendRedirect(forward);
	// }
	// }
//
//	private UserDao userDao = new UserDaoImp();
//
//	public boolean check(User user) {
//
//		Connection conn = null;
//		try {
//			conn = ConnectionFactory.getInstance().makeConnection();
//			conn.setAutoCommit(false);
//			ResultSet resultSet = userDao.get(conn, user);
//			while (resultSet.next()) {
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//
//		// 取得参数username的值
//		String uname = request.getParameter("uname");
//		String passwd = request.getParameter("upwd");
//
//		System.out.println("用户名 ==》 " + uname);
//		System.out.println("密码 ==》 " + passwd);
//
//		RequestDispatcher rd = null;
//		String forward = null;
//		if (uname == null || passwd == null) {
//			request.setAttribute("msg", "用户名或密码为空");
//			rd = request.getRequestDispatcher("/login/error.jsp");
//			rd.forward(request, response);
//		} else {
//			User user = new User();
//			user.setName(uname);
//			user.setPassword(passwd);
//			boolean bool = check(user);
//
//			if (bool) {
//				forward = "/login/success.jsp";
//			} else {
//				forward = "/login/error.jsp";
//			}
//
//			rd = request.getRequestDispatcher(forward);
//			rd.forward(request, response);
//		}
//	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("uname");
		 String password = request.getParameter("upwd");
		 
		 if("yin".equals(userName) && "123456".equals(password)){
			 response.sendRedirect(request.getContextPath() + "/clothes.html");
		 } else {
			 response.sendRedirect(request.getContextPath() + "/login.html");
		}
	}
	
	
}
