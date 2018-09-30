package filterhand;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter(
		description = "This is Firstfilt",
		initParams={@WebInitParam(name = "noLoginPaths", value = "Login.jsp;Error.jsp;Loginserver")},
		urlPatterns = { "/*" })
public class FirstFilter implements Filter {
	private FilterConfig filter;
	
    public FirstFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("filter destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("do Tomcatest filter");
		
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		HttpSession session=httpRequest.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String url = httpRequest.getRequestURL().toString();
		
		String nofilt=filter.getInitParameter("noLoginPaths");
		if(nofilt !=null) {
			String[] nofilts=nofilt.split(";");
			for(int i=0;i<nofilts.length;i++) {
				if(url.indexOf(nofilts[i]) !=-1) {
					chain.doFilter(request, response);
					return;
				}
			}
		}
/*		if(url.indexOf("Login.jsp") !=-1 || url.indexOf("Loginserver") !=-1) {
			chain.doFilter(request, response);
			return;
		}*/
		
		
		
		if(session.getAttribute("username") !=null) {
			chain.doFilter(request, response);
			
		}else {
			httpResponse.sendRedirect("Login.jsp");
		}
		
		
		
		// System.out.println("Toncatest filter done");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init filter");
		filter=fConfig;
	}

}
