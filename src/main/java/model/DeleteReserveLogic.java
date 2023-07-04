package model;

import dao.ReserveDAO;

public class DeleteReserveLogic {
	
	public void execute(String strId) {
		
		int id = Integer.parseInt(strId);
		ReserveDAO dao = new ReserveDAO();
		dao.delete(id);		
	}

}
