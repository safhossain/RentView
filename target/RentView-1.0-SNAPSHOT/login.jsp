<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rentview Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            Email: <input type="text" name="email"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
        <% if (request.getParameter("error") != null) { %>
            <p style="color: red;"><%= request.getParameter("error") %></p>
        <% } %>
    </body>
</html>

