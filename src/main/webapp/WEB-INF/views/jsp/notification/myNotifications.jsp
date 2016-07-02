<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 5/27/16
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes.jsp"%>
<html>
<head>
  <link href="/resources/css/notification.css" rel="stylesheet" />
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
  <div>
    <h2 id="notificari">
        Notificarile mele
    </h2>
  </div>
<table  style=" border-top: 1px solid black;"class="table">
  <thead>
    <tr style="background-color: #ffbb99;">
      <th class="titleSize" style="color: red;">Subiect</th>
      <th class="titleSize">Descriere</th>
      <th class="titleSize">Data postarii</th>
      <th class="titleSize">Creat de</th>
      <th class="titleSize">Accepta</th>
      <th class="titleSize">Ignora</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach items="${notifications}" var="notification">
        <tr>
          <form:form action="/submitnotification/${notification.announcementId}" method="post">
            <td style="color:red; ">
              <c:out value="${notification.subject}"/>
            </td>
            <td>
              <c:out value="${notification.description}"/>
            </td>
            <td>
              <c:out value="${notification.date}"/>
            </td>
            <td>

              <c:forEach items="${fullNameUser}" var="userFullName">
                <c:if test = "${userFullName.key == notification.user.username}">
                  <a href="profiles/${userFullName.key}/">${userFullName.value}</a>
                </c:if>
              </c:forEach>


             <%-- <a href="profiles/${notification.user.username}/">${notification.user.username}</a>--%>


            </td>

            <td>
              <input type="submit" name="action" value="accepta">
            </td>
            <td>
              <input type="submit" name="action" value="ignora">
            </td>
          </form:form>
        </tr>
      </c:forEach>
     </tr>
  </tbody>
</table>
</body>
</html>
