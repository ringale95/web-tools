<%-- 
    Document   : scope
    Created on : Feb 10, 2024, 10:25:40 AM
    Author     : ysfneu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:scriptlet>
            String user = application.getInitParameter("dbuser");
            String pass = application.getInitParameter("dbpass");
            String host = application.getInitParameter("dbip");
            String connection = config.getInitParameter("connection");
        </jsp:scriptlet>    
        User: <%= user %><br/>
        Password: <jsp:expression>pass</jsp:expression><br/>
        Host: <jsp:expression>host</jsp:expression><br/>
        Connection: <jsp:expression>connection</jsp:expression><br/>
    </body>
</html>
