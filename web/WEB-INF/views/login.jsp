<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="/guestbook/resources/bootstrap.css">
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1><b>Welcome to our page! Please login below.</b></h1>
            <h2 class="flash">${flash}</h2>
        </div>
        <div class="container">
            <form class="form-inline"action="login" method="POST">
                <label for="test">User Name:</label>
                <input type="text" class="form-control"name="username"/><br/>
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password"/><br/>
                <input type="submit" class="brn btn-secondary"value="Login"/>
            </form>
        </div>

        <br>

        <!-- Footer -->
        <footer class="gb-container gb-dark-grey gb-padding-32 gb-margin-top">
            <center><p>Registered&trade; Lino De la Cruz 2018</p></center>
        </footer>
    </body>
</html>
