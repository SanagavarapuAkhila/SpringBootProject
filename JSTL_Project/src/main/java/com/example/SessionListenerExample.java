package com.example;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListenerExample implements HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {





  public void sessionCreated(HttpSessionEvent se) { 
  System.out.println("Session Created "+se.getSession().getId());
  }



/**

   * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)

   */

  public void requestDestroyed(ServletRequestEvent sre) { 
     // TODO Auto-generated method stub
  }



/**

   * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)

   */

  public void attributeRemoved(ServletRequestAttributeEvent srae) { 
     // TODO Auto-generated method stub
  }



/**

   * @see ServletRequestListener#requestInitialized(ServletRequestEvent)

   */

  public void requestInitialized(ServletRequestEvent sre) { 
     System.out.println("Servlet Request Event "+sre.getServletRequest().getParameter("user"));
  }



/**

   * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)

   */

  public void sessionDestroyed(HttpSessionEvent se) { 
     // TODO Auto-generated method stub
  }



/**

   * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)

   */

  public void attributeAdded(ServletRequestAttributeEvent srae) { 
     // TODO Auto-generated method stub
  }



/**

   * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)

   */

  public void attributeReplaced(ServletRequestAttributeEvent srae) { 
     // TODO Auto-generated method stub
  }



/**

   * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)

   */

  public void attributeAdded(HttpSessionBindingEvent se) { 
     // TODO Auto-generated method stub
  System.out.println("Session Attribute "+se.getSession().getAttribute("aaa"));
  }



/**

   * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)

   */

  public void attributeRemoved(HttpSessionBindingEvent se) { 

     // TODO Auto-generated method stub
  }



/**

   * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)

   */

  public void attributeReplaced(HttpSessionBindingEvent se) { 
     // TODO Auto-generated method stub
  System.out.println("Session Attribute "+se.getSession().getAttribute("aaa"));
  }
}