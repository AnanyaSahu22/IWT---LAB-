<%@ include file="navbar.jsp" %>
<%@ include file="db.jsp" %>

<form method="post">
Name: <input name="name"><br>
Email: <input name="email"><br>
Course: <input name="course"><br>
Age: <input name="age"><br>
CGPA: <input name="cgpa"><br>
<input type="submit" value="Add">
</form>

<%
if(request.getParameter("name") != null){
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String course = request.getParameter("course");
    int age = Integer.parseInt(request.getParameter("age"));
    float cgpa = Float.parseFloat(request.getParameter("cgpa"));

    PreparedStatement ps = conn.prepareStatement(
        "INSERT INTO student(name,email,course,age,cgpa) VALUES(?,?,?,?,?)"
    );
    ps.setString(1, name);
    ps.setString(2, email);
    ps.setString(3, course);
    ps.setInt(4, age);
    ps.setFloat(5, cgpa);

    ps.executeUpdate();
    out.println("Student Added Successfully");
}
%>
