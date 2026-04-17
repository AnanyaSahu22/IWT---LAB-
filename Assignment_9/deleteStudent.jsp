<%@ include file="db.jsp" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

PreparedStatement ps = conn.prepareStatement(
    "DELETE FROM student WHERE id=?"
);
ps.setInt(1, id);

ps.executeUpdate();

response.sendRedirect("displayStudents.jsp");
%>
