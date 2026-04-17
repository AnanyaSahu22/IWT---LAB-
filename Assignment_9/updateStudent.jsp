<%@ include file="navbar.jsp" %>
<%@ include file="db.jsp" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

PreparedStatement ps = conn.prepareStatement(
    "SELECT * FROM student WHERE id=?"
);
ps.setInt(1, id);

ResultSet rs = ps.executeQuery();
rs.next();
%>

<form method="post">
<input type="hidden" name="id" value="<%= id %>">

Name: <input name="name" value="<%= rs.getString("name") %>"><br>
Email: <input name="email" value="<%= rs.getString("email") %>"><br>
Course: <input name="course" value="<%= rs.getString("course") %>"><br>
Age: <input name="age" value="<%= rs.getInt("age") %>"><br>
CGPA: <input name="cgpa" value="<%= rs.getFloat("cgpa") %>"><br>

<input type="submit" value="Update">
</form>

<%
if(request.getParameter("name") != null){
    PreparedStatement ps2 = conn.prepareStatement(
        "UPDATE student SET name=?,email=?,course=?,age=?,cgpa=? WHERE id=?"
    );

    ps2.setString(1, request.getParameter("name"));
    ps2.setString(2, request.getParameter("email"));
    ps2.setString(3, request.getParameter("course"));
    ps2.setInt(4, Integer.parseInt(request.getParameter("age")));
    ps2.setFloat(5, Float.parseFloat(request.getParameter("cgpa")));
    ps2.setInt(6, id);

    ps2.executeUpdate();
    response.sendRedirect("displayStudents.jsp");
}
%>
