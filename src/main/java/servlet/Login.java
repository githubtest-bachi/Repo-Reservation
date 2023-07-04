package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		rs.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		
		User user = new User(mail, pass);
		
		LoginLogic loginLogic = new LoginLogic();
		User userCheck = loginLogic.execute(user);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", userCheck);
		
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		rs.forward(request, response);		
	}

}
