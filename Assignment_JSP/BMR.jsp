<html>
<body>
<form method="post">
    Age: <input type="number" name="age"><br>
    Gender:
    <input type="radio" name="gender" value="male">Male
    <input type="radio" name="gender" value="female">Female<br>
    Height (cm): <input type="number" name="height"><br>
    Weight (kg): <input type="number" name="weight"><br>
    <input type="submit">
</form>

<%
    if(request.getParameter("age") != null){
        int age = Integer.parseInt(request.getParameter("age"));
        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        String gender = request.getParameter("gender");

        double bmr;

        if("male".equals(gender)){
            bmr = (10*weight) + (6.25*height) - (5*age) + 5;
        } else {
            bmr = (10*weight) + (6.25*height) - (5*age) - 161;
        }

        out.print("Your BMR: " + bmr + " Calories/day");
    }
%>
</body>
</html>
