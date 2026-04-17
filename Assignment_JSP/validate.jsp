<%
String email = request.getParameter("email");
String pass = request.getParameter("password");

if("admin@gmail.com".equals(email) && "admin".equals(pass)){
    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
    rd.forward(request, response);
} else {
    out.print("Invalid Credentials");
}
%>
