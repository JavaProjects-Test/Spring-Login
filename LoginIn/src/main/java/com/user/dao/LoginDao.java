package com.user.dao;

import com.user.vo.Users;

public interface LoginDao {

	public Users checkValidation(Users objectCheckValidation);

	public boolean addAccountStatus(Users objectAddStatus);
}
