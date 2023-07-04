package model;

import dao.LoginDAO;

public class RegisterLogic {
	
	public boolean execute(User user) {
		
		LoginDAO dao = new LoginDAO();
		
		boolean userCheck = dao.newUserCheck(user);
		if(userCheck) {
			
			boolean userRegister = dao.register(user);
		    if (userRegister) {
		    	return true;
		    }
		    return false;
			
		}
		return false;
		
	}

}
