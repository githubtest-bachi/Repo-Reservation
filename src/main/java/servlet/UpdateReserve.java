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

import model.GetReserveLogic;
import model.ReserveBean;
import model.UpdateReserveLogic;
import model.User;

/**
 * Servlet implementation class UpdateReserve
 */
@WebServlet("/UpdateReserve")
public class UpdateReserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		
		GetReserveLogic grl = new GetReserveLogic();
		List<ReserveBean> reserveList = grl.execute();
		request.setAttribute("reserveList", reserveList);
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if (loginUser.getName().equals(name) || loginUser.getUserType() == 1) {
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/updateReserve.jsp");
		      rs.forward(request, response);
		} else {
			
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsgUpdate", "変更を行えるのは予約者本人または管理者だけとなります");
			
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
		String date = request.getParameter("date");
		String text = request.getParameter("text");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		UpdateReserveLogic url = new UpdateReserveLogic();
		
		boolean updateCheck = url.execute(id, date, text, start, end);
		
		if(updateCheck) {
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/updateReserveResult.jsp");
		      rs.forward(request, response);
		      
		} else {			
			request.setAttribute("id", id);
			
			GetReserveLogic grl = new GetReserveLogic();
			List<ReserveBean> reserveList = grl.execute();
			request.setAttribute("reserveList", reserveList);
			
			request.setAttribute("errorMsgUpdateReserve", "予約内容を変更してください");
			
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/updateReserve.jsp");
		      rs.forward(request, response);
		}
		
	}

}
