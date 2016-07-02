<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/25/16
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes.jsp"%>
<html>
<head>
    <link href="/resources/css/myAnnouncements.css" rel="stylesheet" />
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
    <div id="anunturi">
        <h2 >
            Anunturile mele
        </h2>
    </div>
    <table class="table">
        <thead>
            <tr id="headTable">
                <th style="font-size: 125%; color:red;">Subiect</th>
                <th>Descriere</th>
                <th>Data postarii</th>
                <th>Localitati</th>
                <th>Categorii</th>
                <th>Asignat</th>
                <th>Cine a acceptat?</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach items="${anunturi}" var="anunt">
               <tr>
                   <form:form action="/${userAccount.username}/announcements/${anunt.announcementId}" method="post">
                   <td style="color:red; font-size:125%;" class="borderRow">
                       <c:out value="${anunt.subject}" />
                   </td>
                   <td class="borderRow">
                       <c:out value="${anunt.description}" />
                   </td>
                   <td class="borderRow">
                       <c:out value="${anunt.date}" />
                   </td>

                   <td class="borderRow">
                       <c:forEach var="locatii" items="${anunt.locationList}" >
                           <div>
                         <c:out value="${locatii.name}" />
                           </div>
                       </c:forEach>
                   </td>
                   <td class="borderRow">
                       <c:forEach var="categorii" items="${anunt.categoryList}" >
                           <div>
                               <c:out value="${categorii.name}" />
                           </div>
                       </c:forEach>
                   </td>

                   <td class="borderRow">
                      <c:forEach items="${asiggnedUsers}" var="entry">
                         <c:if test = "${ entry.key == anunt.announcementId}">

                             <c:forEach items="${fullNameUser}" var="userFullName">
                                 <c:if test = "${userFullName.key == entry.value}">
                                     <a href="profiles/${entry.value}/">${userFullName.value}</a>
                                 </c:if>
                             </c:forEach>

                             <%--<a href="profiles/${entry.value}/">${entry.value}</a>--%>

                         </c:if>
                       </c:forEach>
                   </td>
                   <td class="borderRow">
                       <input type="submit" name="action" value="verifica"/>
                   </td>
                   </form:form>
               </tr>
           </c:forEach>
        </tbody>
    </table>
</body>
</html>
