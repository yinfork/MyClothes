package com.yin.clothes.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yin.clothes.dao.UserDao;
import com.yin.clothes.dao.impl.UserDaoImp;
import com.yin.clothes.dto.Clothes;
import com.yin.clothes.dto.User;
import com.yin.clothes.util.ConnectionFactory;

@Controller
public class LoginController {

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

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login"; 
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(String uname, String upwd,Model model,HttpSession httpSession) throws Exception {
		System.out.println("用户名 ==》 " + uname);
		System.out.println("密码 ==》 " + upwd);

		if (uname == null || upwd == null) {
			model.addAttribute("msg", "用户名或密码为空"); // 传参数给前端
			return "login";
		} else {
			User user = new User();
			user.setName(uname);
			user.setPassword(upwd);
			boolean bool = check(user);

			if (bool) {
				ArrayList<Clothes> clothesList = new ArrayList<Clothes>();
				clothesList.add(new Clothes(1,"1","resources/img/1.jpg"));
				clothesList.add(new Clothes(1,"2","resources/img/2.jpg"));
				clothesList.add(new Clothes(1,"3","resources/img/3.jpg"));
				clothesList.add(new Clothes(1,"4","resources/img/4.jpg"));
				clothesList.add(new Clothes(1,"5","resources/img/5.jpg"));
				clothesList.add(new Clothes(1,"6","resources/img/6.jpg"));
				clothesList.add(new Clothes(1,"7","resources/img/7.jpg"));
				clothesList.add(new Clothes(1,"8","resources/img/8.jpg"));
				clothesList.add(new Clothes(1,"9","resources/img/9.jpg"));
				clothesList.add(new Clothes(1,"10","resources/img/10.jpg"));
				httpSession.setAttribute("ClothesList", clothesList);  
				return "clothes";
			} else {
				return "login";
			}
		}
    }
}
