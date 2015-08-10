package com.user.service;

import com.user.dao.LoginDao;
import com.user.vo.Users;

public class LoginServiceImpl implements LoginService {

	LoginDao logInDao;

	public void setLogInDao(LoginDao logInDao) {
		this.logInDao = logInDao;
	}

	public Users checkValidation(Users objectCheckValidation) {

		return logInDao.checkValidation(objectCheckValidation);
	}

	public boolean addAccountStatus(Users objectAddStatus) {

		return logInDao.addAccountStatus(objectAddStatus);
	}

}
