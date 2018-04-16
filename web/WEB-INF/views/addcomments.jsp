<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="stylesheet" type="text/css" href="/guestbook/resources/bootstrap.css">
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1><b>Hey ${user.username}!  Post your comments here!</b></h1>
            <p>Please do not exceed 500 words.</p> 
            <h2 class="flash">${flash}</h2>
        </div>
        <div class="container">
            <h2>Stacked form</h2>
            <form action="addcomments" method="POST">
                <div class="form-group">
                    <label for="text">What is your comment about?</label>
                    <input type="text" class="form-control" name="title" placeholder="Enter the title of your comment">
                </div>
                <div class="form-group">
                    <label>Enter your comment:</label><br/>
                    <textarea cols="50" rows="4" name="content"></textarea>
                </div>

                <button type="submit" class="btn btn-secondary">Share your comments</button>
            </form>
        </div>

        <div><br>

            <!-- END of comments post -->
        </div>

        <!-- Footer -->
        <footer class="gb-container gb-dark-grey gb-padding-32 gb-margin-top">
            <center><p>Registered&trade; Lino De la Cruz 2018</p></center>
        </footer>
    </body>
</html>