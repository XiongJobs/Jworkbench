package cookieserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SetCookies
 */
@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create cookies
		for(int i=0; i<3;i++) {
			Cookie cookie =new Cookie("Session-Cookie-"+i,"Cookie-Value-S"+i);
			response.addCookie(cookie);
			cookie=new Cookie("Persistent-Cookie-"+i,"Cookie-Value-P"+i);
			//set cookies valid for 3600 seconds
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		
		response.setContentType("text/hetml;charset=utf-8");
		PrintWriter out=response.getWriter();
		String title="Setting Cookies";
		out.println("<html><head><title>…Ë÷√Cookie</title></head>"
				+"<BODY BGCOLOR=\"#FDF5E6\">\n <H1 ALIGN=\"CENTER\">"
				+title+"</H1>\n"
				+"<a href=\"ShowCookies\">"
				+"ShowCookies servlet</a>\n"
				+"</BODY></HTML>");
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
