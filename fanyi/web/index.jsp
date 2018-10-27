<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: zhangyi
  Date: 2018/10/23
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    fanyi f = new fanyi();
    String a = f.getMess("red").html();
  %>

  <%=a %>
  </body>
</html>
