<html>
<meta charset="utf-8">
<link href="css/style.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="navbar-header">
            <img id="brand-image" alt="Logo Website" src="images/icons/Logo.png" />

        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="#">Contact</a></li></p>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span>Welcome <%=request.getAttribute("user")%></a></li>
            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>
</body>
</html>