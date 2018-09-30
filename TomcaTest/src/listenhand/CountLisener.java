package listenhand;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountLisener
 *
 */
@WebListener
public class CountLisener implements HttpSessionListener {
	
	private int usernumber=0;
   
    public CountLisener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	usernumber++;
//    	System.out.println("新增用户  当前用户数为："+usernumber);
    	se.getSession().getServletContext().setAttribute("usernumber", usernumber);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	usernumber--;
//    	System.out.println("减少用户  当前用户数为："+usernumber);
    	se.getSession().getServletContext().setAttribute("usernumber", usernumber);
    }
	
}
