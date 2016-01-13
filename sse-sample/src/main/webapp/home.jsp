<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Home</title>
</head>
<%
    if(session.getAttribute("username") == null){
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
%>
<body>
Hello ${username}!
</body>
</html>