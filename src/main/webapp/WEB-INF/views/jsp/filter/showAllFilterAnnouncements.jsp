<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/29/16
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="color:green; text-align: center;">
  <h1>
    Anunturile
  </h1>
</div>
<table class="table">
  <thead>
  <tr>
    <th>Subject</th>
    <th>Description</th>
    <th>Posted Date</th>
    <th>Posted By</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${anunturi}" var="anunt">
    <tr>
      <td>
        <c:out value="${anunt.subject}" />
      </td>
      <td>
        <c:out value="${anunt.description}" />
      </td>
     <td>
        <c:out value="${anunt.date}" />
      </td>
      <td>
        <a href="/profiles/${anunt.user.username}/">
          <c:out value="${anunt.user.username}" />
        </a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
