<html>
<body>
<form method="post">
    Enter Number: <input type="number" name="num">
    <input type="submit">
</form>

<%
    String n = request.getParameter("num");
    if(n != null){
        int num = Integer.parseInt(n);
        boolean prime = true;

        if(num <= 1) prime = false;

        for(int i=2; i<=num/2; i++){
            if(num % i == 0){
                prime = false;
                break;
            }
        }

        if(prime)
            out.print("Prime Number");
        else
            out.print("Not a Prime Number");
    }
%>
</body>
</html>
