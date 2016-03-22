<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My Game</title>
  </head>
  <body>

  <form method="post" action="/play.jsp">
    <input name="userName"/><br>
    <input type="submit" value="new game" name="begin"/><br><br>
  </form>


  <form method="post" action="/play.jsp">
    <input value="countinue" type="submit"/>
  </form>
  </body>
</html>
