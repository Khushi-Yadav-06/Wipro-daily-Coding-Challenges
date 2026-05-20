
<%@ page import="java.util.List" %>
<%@ page import="com.contact.model.Contact" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Contacts</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>All Contacts</h1>

    <div class="table-container">

        <table class="table">

            <tr>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>

            <%
                List<Contact> contacts =
                        (List<Contact>) session.getAttribute("contacts");

                if (contacts != null) {

                    for (Contact c : contacts) {
            %>

            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getPhone() %></td>
                <td><%= c.getEmail() %></td>
            </tr>

            <%
                    }
                }
            %>

        </table>

    </div>

    <a href="index.jsp">
        <button>Back</button>
    </a>

</div>

</body>
</html>
