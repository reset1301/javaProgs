<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 22.06.2018
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Привет от Амиго</title>
</head>
<body>
<%--это еще HTML--%>
<%
  //А тут можно писать Java-код

  String s = "Вся власть роботам!";
  for(int i=0; i<10; i++)
  {
    out.println(s);
    out.println("<br>");
  }

%>
<%--а это уже опять HTML--%>
</body>
</html>