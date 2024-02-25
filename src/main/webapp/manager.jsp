<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ryerson.rentview.Helper.MemberInfo"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RentView Manager Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <header>
            <nav>
                <form action="index.jsp">
                        <button type="submit">Home</button>
                </form>
                <form action="logout.jsp">
                    <button type="submit">Logout</button>
                </form>
            </nav>
        </header>
        <h1>Manager Page</h1>
        <table>
            <tr>
                <th>Member ID</th>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
                <th>Member Type</th>
                <th>Last 4 Digits</th>
                <th>Card Type</th>
                <th>Expiration Date</th>
                <th>Action</th>
            </tr>
            <% 
                List<MemberInfo> users = (List<MemberInfo>) request.getAttribute("users");
                if (users != null) {
                    for (MemberInfo user : users) {
            %>
                        <tr>
                            <td><%= user.getMemberID() %></td>
                            <td><%= user.getEmailAddress() %></td>
                            <td><%= user.getFirstName() %></td>
                            <td><%= user.getLastName() %></td>
                            <td><%= user.getDateOfBirth() %></td>
                            <td><%= user.getMemberType() %></td>
                            <td><%= user.getLastFourDigits() %></td>
                            <td><%= user.getCardType() %></td>
                            <td><%= user.getExpirationDate() %></td>
                            <td>
                                <form action="UserManagementServlet" method="post">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="email" value="<%= user.getEmailAddress() %>">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
            <% 
                    }
                }
            %>
        </table>
        <h2>Add User</h2>
        <!-- Addition form -->
        <form action="UserManagementServlet" method="post">
            <input type="hidden" name="action" value="add">
            <input type="text" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <input type="text" name="firstName" placeholder="First Name">
            <input type="text" name="lastName" placeholder="Last Name">
            <input type="text" name="dob" placeholder="Date of Birth (YYYY-MM-DD)">
            <select name="memberType">
                <option value="user">user</option>
                <option value="manager">manager</option>
            </select>
            <button type="submit">Add User</button>
        </form>
    </body>
</html>
