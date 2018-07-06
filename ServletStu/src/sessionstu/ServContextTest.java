package sessionstu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServContextTest
 */
@WebServlet("/ServContextTest")
public class ServContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServContextTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		ServletContext application=this.getServletContext();
		Integer intcount=(Integer)application.getAttribute("ascount");
		
		if(intcount==null) {
			intcount=new Integer(0);
			System.out.println(intcount);
		}else {
			intcount=new Integer(intcount.intValue()+1);
			System.out.println("in if add"+intcount);
		}
		
		application.setAttribute("ascount", intcount);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session в╥вы</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">");
		out.println(intcount);
		out.println("</body>");
		out.println("</html>");
		
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
