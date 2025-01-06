<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p>
        <%= request.getParameter("error") != null ? request.getParameter("error") : "Something went wrong!" %>
    </p>
    <a href="<%= request.getContextPath() %>/registration.jsp">Back to Registration</a>
</body>
</html>
