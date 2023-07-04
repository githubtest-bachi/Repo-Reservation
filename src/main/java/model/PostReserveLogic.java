package model;

import dao.ReserveDAO;

public class PostReserveLogic {
	
	public boolean execute(ReserveBean rb) {		
		
		ReserveDAO dao = new ReserveDAO();
		
		boolean reserveCheck = dao.reserveCheck(rb);
		if (reserveCheck) {
			
			boolean reserve = dao.reserve(rb);
			if(reserve) {
				return true;
			}
			return false;
		}
		return false;		
	}

}
