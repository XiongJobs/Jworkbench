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
 * Servlet implementation class ShowCookies
 */
@WebServlet("/ShowCookies")
public class ShowCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String title="Show Cookies";
		
		out.println("<html><head><title>获取客户端Cookie</title></head>"
				+"<body bgcolor=\"#fdf5e6\">\n"
				+"<h1 align=\"center\">"+title+"</h1>\n"
				+"<table border=1 align=\"center\">\n"
				+"<th>Cookie Name</th>\n"
				+"<th>Cookie Value</th>");
		Cookie[] cookies=request.getCookies();
		if(cookies !=null) {
			Cookie cookie;
			for(int i=0;i<cookies.length;i++) {
				cookie=cookies[i];
				out.println("<tr>\n"+
				"<td>"+cookie.getName()+"</td>\n"+
				"<td>"+cookie.getValue()+"</td></tr>\n");
			}			
		}
		out.println("</table></body></html>");
		
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
