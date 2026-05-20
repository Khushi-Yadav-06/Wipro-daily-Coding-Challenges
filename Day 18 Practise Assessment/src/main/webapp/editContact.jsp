
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Edit Contact</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="container">

    <h1>Edit Contact</h1>

    <form action="editContact" method="post">

        <input type="hidden"
               name="index"
               value="<%= request.getParameter("index") %>">

        <input type="text"
               name="name"
               value="<%= request.getParameter("name") %>"
               required>

        <input type="text"
               name="phone"
               value="<%= request.getParameter("phone") %>"
               required>

        <input type="email"
               name="email"
               value="<%= request.getParameter("email") %>"
               required>

        <button type="submit">

            Update Contact

        </button>

    </form>

</div>

</body>
</html>
