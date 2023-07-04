package model;

import java.util.List;

import dao.ReserveDAO;

public class GetReserveLogic {
	
	public List<ReserveBean> execute() {
		
		ReserveDAO dao = new ReserveDAO();
		List<ReserveBean> reserveList = dao.findAll();
		return reserveList;		
	}

}
