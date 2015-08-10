package com.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.user.service.LoginService;
import com.user.vo.Users;

@Controller
public class HomeController {

	@Autowired
	LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/home")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	int count = 0;

	@RequestMapping(value = "/loginVerification", method = RequestMethod.POST)
	public ModelAndView addNewUser(@RequestParam("uname") String emailID,
			@RequestParam("passwd") String password,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HELLO");
		String message;
		ModelAndView mv = new ModelAndView("logIn");
		System.out.println("hello");

		Users objectUsers = new Users();
		objectUsers.setEmailID(emailID);
		objectUsers.setPassword(password);
		objectUsers.setAccountStatus("2 ");

		Users returnObject = null;
		returnObject = loginService.checkValidation(objectUsers);
		System.out.println("Result 123:" + returnObject);
		if (returnObject == null) {
			count++;
			System.out.println("Count: " + count);

			if (count == 3) {
System.out.println("qwertyuio");
				//Users addAccountStatus = new Users();
				System.out.println("qwertyuio");
				/*
				 * addAccountStatus.setEmailID(emailID);
				 * addAccountStatus.setPassword(password);
				 */
				objectUsers.setAccountStatus("3");
				System.out.println("qwertyuio");
				/*System.out.println("Account Status: "
						+ objectUser.getAccountStatus());*/
				boolean status = loginService
						.addAccountStatus(objectUsers);
				if (status) {
					message = "Your account is locked, Use forgot password functionality to reset your password";
					mv.addObject("message", message);
				} else {
					System.out.println("not true");
				}
			}
			System.out.println("Not Logged in");
			mv = new ModelAndView("error");
		}

		else if (returnObject.getAccountStatus().equals("1")) {
			System.out.println("dsvbj,sfd");
			mv = new ModelAndView("accountStatusError");
		}

		else if (returnObject != null) {
			HttpSession session = request.getSession();
			session.setAttribute("User Object", objectUsers);
			System.out.println("Logged In Successfully");
		}

		return mv;
	}

}
