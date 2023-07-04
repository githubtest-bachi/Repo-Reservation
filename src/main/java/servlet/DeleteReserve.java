package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteReserveLogic;
import model.GetReserveLogic;
import model.ReserveBean;
import model.User;

/**
 * Servlet implementation class DeleteReserve
 */
@WebServlet("/DeleteReserve")
public class DeleteReserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		request.setAttribute("id", id);
//		request.setAttribute("name", name);
		
		GetReserveLogic grl = new GetReserveLogic();
		List<ReserveBean> reserveList = grl.execute();
		request.setAttribute("reserveList", reserveList);
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if (loginUser.getName().equals(name) || loginUser.getUserType() == 1) {
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/deleteConfirm.jsp");
		      rs.forward(request, response);
		} else {
			
			request.setAttribute("errorMsgDel", "削除を行えるのは予約者本人または管理者だけとなります");
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		      rs.forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		DeleteReserveLogic drl = new DeleteReserveLogic();
		drl.execute(id);
		
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/deleteReserveResult.jsp");
	      rs.forward(request, response);
	}

}
