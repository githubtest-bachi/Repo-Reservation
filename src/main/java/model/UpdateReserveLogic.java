package model;

import dao.ReserveDAO;

public class UpdateReserveLogic {
	
	public boolean execute(String strId, String date, String text, String start, String end) {
		
		int id = Integer.parseInt(strId);
		
		ReserveDAO dao = new ReserveDAO();
		
		boolean urc = dao.updateReserveCheck(id, date, text, start, end);
		if(urc) {			
			boolean upd = dao.update(id, date, text, start, end);
				if(upd) {
					return true;
				}
				return false;			
			}
			return false;		
				
	}

}
