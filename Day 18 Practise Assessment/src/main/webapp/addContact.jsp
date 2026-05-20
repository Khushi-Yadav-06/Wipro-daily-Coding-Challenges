
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Contact</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Add Contact</h1>

    <form action="addContact" method="post">

        <input type="text"
               name="name"
               placeholder="Enter Name"
               required>

        <input type="text"
               name="phone"
               placeholder="Enter Phone"
               required>

        <input type="email"
               name="email"
               placeholder="Enter Email"
               required>

        <button type="submit">Save Contact</button>

    </form>

</div>

</body>
</html>
