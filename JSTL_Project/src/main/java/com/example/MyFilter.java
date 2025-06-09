package com.example;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MyFilter extends HttpFilter implements Filter {
public void destroy() {

}
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
HttpServletResponse res=(HttpServletResponse) response;
HttpServletRequest req=(HttpServletRequest)request;
String usr=req.getParameter("user");
PrintWriter pw=res.getWriter();
pw.println("Preprocessing................. "+usr);
chain.doFilter(request, response);
}



public void init(FilterConfig fConfig) throws ServletException {
}

}