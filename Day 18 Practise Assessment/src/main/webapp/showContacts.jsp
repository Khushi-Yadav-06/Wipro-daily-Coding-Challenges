
<%@ page import="java.util.List" %>
<%@ page import="com.contact.model.Contact" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>All Contacts</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>

<body>

<div class="container">

    <h1>All Contacts</h1>

    <%
        String message =
                (String) session.getAttribute("message");

        if(message != null){
    %>

    <div class="success-msg">

        <%= message %>

    </div>

    <%
            session.removeAttribute("message");
        }
    %>

    <div class="table-container">

        <table class="table">

            <tr>

                <th>Name</th>

                <th>Phone</th>

                <th>Email</th>

                <th>Actions</th>

            </tr>

            <%

                List<Contact> contacts =
                        (List<Contact>) session.getAttribute("contacts");

                if (contacts != null) {

                    for (int i = 0; i < contacts.size(); i++) {

                        Contact c = contacts.get(i);

            %>

            <tr>

                <td><%= c.getName() %></td>

                <td><%= c.getPhone() %></td>

                <td><%= c.getEmail() %></td>

                <td>

                    <a href="editContact.jsp?index=<%=i%>&name=<%=c.getName()%>&phone=<%=c.getPhone()%>&email=<%=c.getEmail()%>">

                        <button class="edit-btn">

                            <i class="fa-solid fa-pen"></i>

                        </button>

                    </a>

                    <a href="deleteContact?index=<%=i%>">

                        <button class="delete-btn">

                            <i class="fa-solid fa-trash"></i>

                        </button>

                    </a>

                </td>

            </tr>

            <%
                    }
                }
            %>

        </table>

    </div>

    <a href="index.jsp">

        <button>

            Back

        </button>

    </a>

</div>

</body>
</html>
