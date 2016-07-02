<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 6/5/16
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../includes.jsp"%>
<html>

<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
        integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
        integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
          integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
<div style="text-align: center; color:green; ">
  <h1>Utilizatorii care au acceptat</h1>
</div>
<table class="table">
  <thead>
  <tr style="background-color: #ffbb99;">
    <th>Numele</th>
    <th>Nr. telefon</th>
    <th>Data nasterii</th>
    <th>Asigneaza</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${assignedUsers}" var="user">
    <tr>
    <form:form action="/${userAccount.username}/announcements/${anuntIdAsignat}/assignUser/${user.username}" method="post">

      <td>
        <a href="profiles/${user.username}/">${user.firstName} ${user.lastName}</a>
      </td>

      <td>
        <c:out value="${user.phone}" />
      </td>

      <td>
        <c:out value="${user.birthday}" />
      </td>
      <td>
        <input type="submit" name="action" value="Asigneaza">
      </td>
      </form:form>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
