<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="/guestbook/resources/bootstrap.css">
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1><b>Welcome  <c:if test="${not empty user}">, ${user.username}</c:if> to our Guest Book</b></h1>
            <p>You can post your comments below!</p> 
        </div>
                <c:choose>
                    <c:when test="${not empty user}">
                        <a href="/guestbook/logout">Log Out</a>
                    </c:when>
                        <c:otherwise>
                        
                                <form action="/guestbook/login" method="GET">
                                    <button class="btn btn-secondary" value="login">Sign In</button>
                                </form>
                                <hr>
                                <form action="/guestbook/register" method="GET">
                                    <button class="btn btn brn-secondary" value="register">Register</button>
                                </form>
                        </c:otherwise>
                </c:choose>
        <div class="gb-col l8 s12">
         <!-- latest entry -->
         <div class="gb-card-4 gb-margin gb-white">
            <img src="images/comment1.jpg" alt="Comment" style="width:153%">
            <div class="gb-container">
                <h3><b>Latest Post</b></h3>
                <h5>Entry by:${posts[0].author.username}<span class="gb-opacity">  About: ${posts[0].title}</span></h5>
            </div>
         </div>
         <div class="gb-container">
             <p>${posts[0].content}</p>
             <div class="gb-row">
                 <div class="gb-col m8 s12">
                     <c:choose>
                         <c:when test="${not empty user}">
                             <form action="/guestbook/addcomments" method="GET">
                                 <p><button class="gb-button gb-padding-large gb-white gb-border"><b>Post your comment!</b></button></p>
                             </form>
                         </c:when>
                     </c:choose>        
                 </div>
             </div>
         </div>
        </div>
          
        <hr>

        <!-- history post entry -->

        <c:forEach var="post" items="${posts}">    
            <div class="gb-card-4 gb-margin gb-white">
                <img src="images/comment2.gif" alt="Comment history" style="width:10%">
                <div class="gb-container">
                    <H3><b>Comment by:  <c:out value="${post.author.username}"></c:out></b></h3>
                    <p>Subject:  <c:out value="${post.title}"></c:out>  <span class="gb-opacity">Posted:  ${post.posted}</span></p>
                    </div>

                    <div class="gb-container">
                        <p><c:out value="${post.content}"></c:out></p>
                    </div>
                </div>
        </c:forEach>
        <!-- END BLOG ENTRIES -->
            </div>
            <!-- END GRID -->

            <div><br>

                <!-- END gb-content -->
            </div>

            <!-- Footer -->
            <footer class="gb-container gb-dark-grey gb-padding-32 gb-margin-top">
                <center><p>Registered&trade; Lino De la Cruz 2018</p></center>
            </footer>
    </body>
</html>
