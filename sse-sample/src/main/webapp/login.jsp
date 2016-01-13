<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Example</title>
<%
    String username = request.getParameter("username");
    String pwd = request.getParameter("password");
    if(username != null){
        session.setAttribute("username", username);
        response.sendRedirect("home.jsp");
    }
%>
</head>
<body>
<form method="post" action="login.jsp">
    <div style="text-align: center;">
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>