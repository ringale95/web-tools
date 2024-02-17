<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.bookstore.pojo.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book List</h1>
        <table>
        <tr><td>ISBN</td><td>TITLE</td><td>Author</td></tr>
        <c:forEach var="book" items="${applicationScope.booklist}">
            <tr>
                <td><c:out value="${book.isbn}"></c:out></td>
                <td><c:out value="${book.title}"></c:out></td>
                <td><c:out value="${book.author}"></c:out></td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
