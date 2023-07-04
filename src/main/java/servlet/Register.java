package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterLogic;
import model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 新規登録画面にフォワード
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
	      	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		int userType = Integer.parseInt(request.getParameter("type"));
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		
		User user = new User(userType, name, mail, pass);
		
		RegisterLogic registerLogic = new RegisterLogic();
		boolean userRegister = registerLogic.execute(user);
		
		if(userRegister) {
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/registerResult.jsp");
		      rs.forward(request, response);
		} else {
			request.setAttribute("errorMsgRegister", "そのユーザー名はすでに登録されています。");
			
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		      rs.forward(request, response);
		}
	}

}
