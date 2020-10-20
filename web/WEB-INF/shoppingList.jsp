<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List JSP</title>
    </head>

    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${displayName} <a href=" <c:url value='/ShoppingList'> <c:param name='action' value='logout'/> </c:url> ">Logout</a>

            <form action="" method="POST">
                <h2>List</h2>
                <label>Add item: </label><input type="text" name="item"><input type="submit" value="Add">
                <input type="hidden" name="action" value="add">
            </form>

            <form action="" method="POST">
                <br>
                <table>
                <c:forEach items="${listOfItems}" var="item">
                    <tr>
                        <td>
                            <input type="radio" name="item" value="${item}">${item}
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Delete">
            <input type="hidden" name ="action" value="delete">
        </form>

    </body>
</html>
