package com.hybrid.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hybrid.command.LoginCommand;
import com.hybrid.exception.LoginFailException;
import com.hybrid.model.Member;
import com.hybrid.service.LoginService;

@Controller
@RequestMapping("/user")
public class LoginController {
	static Log log = LogFactory.getLog(LoginController.class);

	@Autowired
	LoginService loginService;

	/*
	 * login.html
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String getLoginView(HttpSession session) {
		log.info("getLoginView()...");
		
		session.invalidate();
		return "user/login";
	}

	/*
	 * Login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginCommand login(@RequestBody LoginCommand command, HttpSession session) {
		log.info("email = " + command.getEmail());
		log.info("password = " + command.getPassword());

		Member member = loginService.login(command.getEmail(), command.getPassword());
		session.setAttribute("login", true);
		session.setAttribute("member", member);

		return command;
	}

	/*
	 * Logout
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		log.info("logout()...");

		session.invalidate();

		return "redirect:/user/login.html";
	}

	/*
	 *	Login Check 
	 */
	@RequestMapping(value = "/logincheck", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> logincheck(HttpSession session) {
		Map<String, Object> map = new HashMap<>();

		Boolean login = (Boolean) session.getAttribute("login");
		if (login != null && login == true) {
			map.put("login", true);
			map.put("member", session.getAttribute("member"));
		} else {
			map.put("login", false);
		}

		return map;
	}

	/*
	 * error 처리
	 */
	@ExceptionHandler // 외부에서 요청하는 것이 아니라 내부에서 Exception이 발생했을때 호출되는 메소드
	@ResponseBody 	  // 데이터를 json형태로 받기위해서
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400에러처리
	public Map<String, Object> loginfail(LoginFailException e) {
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("message", e.getMessage());
		return error;
	}

}
