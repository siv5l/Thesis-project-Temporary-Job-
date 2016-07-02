<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 5/14/16
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>asdsadsa</title>
     <link href="/resources/css/loginDoi.css" rel="stylesheet"/>
      <script src="/resources/js/login.js" ></script>
</head>
<body>
<div class="login-page">
  <div class="form">
                                                                                          <%--value="j_spring_security_check" fara slash--%>
    <form class="login-form" id="formSignIn" <%--action="/signin"--%> action="<c:url value='j_spring_security_check' />" method="post">
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password" />
      <button> Logare</button>

      <p class="message">
        <a href="/registration">Inregistrare</a> </p>
    </form>
  </div>
</div>
</body>
</html>
