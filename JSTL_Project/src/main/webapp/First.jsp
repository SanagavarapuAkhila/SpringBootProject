<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<body>
<sql:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"
 url = "jdbc:mysql://localhost/mphasis"
 user = "root" password = "root"/>
 <sql:update dataSource = "${snapshot}" var = "result">
 INSERT INTO student VALUES (111,'Bhuvan','EEE');
 </sql:update>
 <sql:query dataSource = "${snapshot}" var = "result">
 SELECT * from student;
 </sql:query>
 <table border = "1" width = "100%">
 <tr>
 <th>Rollno</th>
 <th>Name</th>
 <th>Branch</th>
 </tr>
 <c:forEach var = "row" items = "${result.rows}">
 <tr>
 <td><c:out value = "${row.rollno}"/></td>
 <td><c:out value = "${row.name}"/></td>
 <td><c:out value = "${row.branch}"/></td>
 </tr>
 </c:forEach>
 </table>
</body>
</html>