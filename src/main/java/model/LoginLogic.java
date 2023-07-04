package model;

import dao.LoginDAO;

public class LoginLogic {
	
	public User execute(User user) {
		
		LoginDAO dao = new LoginDAO();
	    User userCheck = dao.loginCheck(user);
	    if (userCheck != null) {
	    	return userCheck;
	    }
	    return null;
	}

}
