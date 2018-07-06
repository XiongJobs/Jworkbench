package sessionstu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionInfoSer
 */
@WebServlet("/SessionInfoSer")
public class SessionInfoSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionInfoSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//true表示如果没有session则创建一个新的session
		HttpSession mysession=request.getSession(true);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session Info Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Session Information</h3>");
		out.println("New Session: "+mysession.isNew());//查看是否是新建session
		out.println("<br>Session ID: "+mysession.getId());
		out.println("<br>Session Create Time: "+
		new java.util.Date(mysession.getCreationTime()));//查看session创建时间
		out.println("<br>Session Last Accessed Time: "+
		new java.util.Date(mysession.getLastAccessedTime()));//查看session最近相应时间
		out.println("<h3>Request Information</h3>");
		out.println("Session ID from Request: "+request.getRequestedSessionId());
		out.println("<br>Session ID via Cookie: "+request.isRequestedSessionIdFromCookie());
		out.println("<br>Session ID via rewritten URL: "+request.isRequestedSessionIdFromURL());
		out.println("<br>Valid Session ID: "+request.isRequestedSessionIdValid());
		out.println("<br><a href="+response.encodeURL("SessionInfoSer")
		+">refresh</a>");
		out.println("</body></html>");
		
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
