package com.example;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/abc")
public class ServletDemo extends HttpServlet{
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
res.setContentType("text/html");
String user=req.getParameter("user");
HttpSession session=req.getSession();
session.setAttribute("aaa",user);
PrintWriter pw=res.getWriter();
pw.println("<html><body bgcolor='pink'>Hai "+user+"<br/>");
pw.println("<form action='Second.jsp'><button type='submit'>Click me</button></form></body></html>");
}
}