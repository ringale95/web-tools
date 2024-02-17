<%-- 
    Document   : book-view
    Created on : Feb 10, 2024, 11:28:37 AM
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
        <h1>Book Search Page</h1>
        <form method='get' action='book.htm'>
            Enter ISBN, Author, or Title: <input type='text' name='searchkey'/><br/>
            <input type='hidden' name='action' value='result'/>
            <input type='submit' value='Search Books' />
        </form>
    </body>
</html>
