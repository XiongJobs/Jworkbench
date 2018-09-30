package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginserver
 */
@WebServlet("/Loginserver")
public class Loginserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginserver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		System.out.println(username);
		
		if("admin".equals(username) && "admin".equals(password)) {
			request.getSession().setAttribute("username", username);
			response.sendRedirect("Myjs.jsp");
		}else {
			response.sendRedirect("Login.jsp");
		}
		
/*		response.getWriter().append("Served at: ").append(request.getContextPath()+"<br />").append("username is : "+username
				+"<br />").append("password is: "+password);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
