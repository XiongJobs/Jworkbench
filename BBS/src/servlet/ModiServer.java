package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.DBClose;
import jdbc.MysqlConector;

/**
 * Servlet implementation class ModiServer
 */
@WebServlet("/ModiServer")
public class ModiServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModiServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String cont=request.getParameter("cont");
		/*response.getWriter().append("Served at: ").append(request.getContextPath()).
		append("需改变的id是"+id).append("需要改变的title为："+title).append("需要改变的cont为："+cont);*/
		
		Connection conn=MysqlConector.getConnection();
		String sql="update article set title = ? , cont = ? where id = ?";
		PreparedStatement pstmt=MysqlConector.getPrepStatement(conn,sql);
		try {
			pstmt.setString(1, title);
			pstmt.setString(2, cont);
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pstmt);
			DBClose.close(conn);
		}

		response.sendRedirect("Article.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
