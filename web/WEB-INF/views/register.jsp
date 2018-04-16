<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="/guestbook/resources/bootstrap.css">
    </head>
    <body>
         <div class="jumbotron text-center">
            <h1><b>Welcome to our fun page! Please register below.</b></h1>
        </div>
        <div class="container">
            <h2>New user:</h2>
            <form action="register" method="POST">
                <div class="form-group">
                    <label for="text">User Name:</label>
                    <input type="text" class="form-control" placeholder="Enter your user name" name="username" required="true">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" placeholder="Enter password" name="password" required="true">
                </div>
                <div class="form-group">
                    <label for="password1">Retype Password:</label>
                    <input type="password" class="form-control" placeholder="Retype password" name="password1"required="true">
                </div>
                <button type="submit" class="btn btn-primary">Register</button>
            </form>
        </div>

<br>

<!-- Footer -->
<footer class="gb-container gb-dark-grey gb-padding-32 gb-margin-top">
    <center><p>Registered&trade; Lino De la Cruz 2018</p></center>
</footer>
    </body>
</html>
