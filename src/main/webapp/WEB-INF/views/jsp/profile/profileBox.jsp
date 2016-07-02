<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/13/16
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="/resources/css/profileBoxStyle.css" rel="stylesheet">
</head>
<body>
  <div>
    <div>
      <h1>Profilul meu</h1>
    </div>
    <div class="textSize">
      <a href="/messages">Mesaje</a>
    </div>
    <div class="textSize">
      <a  href="/${userAccount.username}/announcements">Anunturile mele</a>
    </div>
    <div class="textSize">
      <a href="/${userAccount.username}/notifications">Notificarile mele</a>
    </div>

  </div>
</body>
</html>
