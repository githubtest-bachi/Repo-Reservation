package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostReserveLogic;
import model.ReserveBean;
import model.User;

/**
 * Servlet implementation class Reserve
 */
@WebServlet("/Reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
	      rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		String text = request.getParameter("text");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		ReserveBean rb = new ReserveBean(loginUser.getName(), date, text, start, end);
		PostReserveLogic postReserveLogic = new PostReserveLogic();
		boolean ableToReserve = postReserveLogic.execute(rb);
		
		if (ableToReserve) {
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/reserveResult.jsp");
		      rs.forward(request, response);
		} else {
			
			request.setAttribute("errorMsgReserve", "予約時間に重複があるため変更してください。");
			
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
		      rs.forward(request, response);
		}		
		
	}

}
