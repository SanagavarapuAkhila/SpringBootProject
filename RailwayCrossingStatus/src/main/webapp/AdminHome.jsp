<%@page import="com.railway.bean.RailwayCrossingBean"%>
<%@page import="com.railway.dao.RailwayCrossingDao"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
 <link rel="stylesheet" href="./mystyle.css"></link>
</head>
<body>
 <h1 style="text-align: center;">Railway Crossings</h1>


<!-- Logout Button -->
 <div style="text-align: right; margin-bottom: 20px;">
 <form action="Login.jsp" method="get" style="display: inline;">
 <button type="submit">Logout</button>
 </form>
 </div>



 <!-- Add & Search Section -->
 <div style="display: flex; justify-content: space-between; margin-bottom: 30px;">
 <form action="AddForm.jsp" method="get">
 <%
 RailwayCrossingBean newCrossing = new RailwayCrossingBean();
session.setAttribute("add", newCrossing);
%>
 <button type="submit">Add</button>
 </form>


 <form action="SearchResult.jsp" method="get">
 <input type="text" name="searchName" placeholder="Enter crossing name" required />
 <button type="submit">Search</button>
 </form>
 </div>



 <!-- Crossings Table -->
 <table border="1" cellpadding="10" cellspacing="0" style="width: 100%;">
 <tr>
 <th>Sr.No</th>
 <th>Name</th>
 <th>Address</th>
 <th>Landmark</th>
 <th>Train Schedule</th>
 <th>Person In-charge</th>
 <th>Status</th>
 <th>Action</th>
 </tr>



 <%
 ArrayList<RailwayCrossingBean> allCrossings = RailwayCrossingDao.selectAll();
 int i = 1;
for (RailwayCrossingBean rcb : allCrossings) {
%>
 <tr>
 <td><%= i %></td>
 <td><%= rcb.getName() %></td>
 <td><%= rcb.getAddress() %></td>
 <td><%= rcb.getLandmark() %></td>
 <td><%= rcb.getTrainschedules() %></td>
 <td><%= rcb.getPersonincharges() %></td>
 <td><%= rcb.getStatus() %></td>
 <td>
 <!-- Update Button -->
 <form action="UpdateForm.jsp" method="get" style="display: inline;">
 <input type="hidden" name="name" value="<%= rcb.getName() %>"/>
 <button type="submit">Update</button>
 </form>

 <!-- Delete Button -->
 <form action="DeleteCrossingForm.jsp" method="get" style="display: inline;">
 <input type="hidden" name="name" value="<%= rcb.getName() %>"/>
 <button type="submit">Delete</button>
 </form>
 </td>
 </tr>
 <%
 i++;
 }
 %>
 </table>
</body>
</html>