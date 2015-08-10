package com.user.service;

import com.user.vo.Users;

public interface LoginService {

	public Users checkValidation(Users objectCheckValidation);
	
	public boolean addAccountStatus(Users objectAddStatus);

}
