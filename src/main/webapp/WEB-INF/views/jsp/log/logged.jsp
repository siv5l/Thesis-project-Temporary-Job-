<%@ page import="com.endava.siv5l.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/4/16
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../includes.jsp"%>
<head>
  <link href="/resources/css/loggedStyle.css" rel="stylesheet" />

  <script type="text/javascript"
          src="http://code.jquery.com/jquery-2.2.2.min.js">
  </script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

 <%-- <script src="/resources/js/jquery-1.12.4.js" type="text/javascript" ></script>
  <script src="/resources/js/bootstrap.js"></script>--%>


 <script type="text/javascript">
    function scoateAnunturiCurente() {
      $.ajax({
        type: "GET",
        url : '/retrieveannouncementbycurrentdate',
        dataType : 'json',
        success : function(data) {
          var output = "";
           for (var b in data) {

               /*  output += "<table class=\"";
                output += "table\">";
                output += "<thead>";
                output += "<tr style=";
                output += "\"background-color: #ffbb99\";>";
                output += "<th>Subiect</th>";
                output += "<th>Descriere</th>";
                output += "<th>Postat de</th>";
                output += "</tr>";
                output += "</thead>";
                output += "<tbody>";*/

               output += "<tr><td style=\"";
               output += "color:red;\">";
               output += data[b].subject ;
               output += "</td>";
               output += "<td>";
               output += data[b].description;
               output += "</td>";
               output += "<td>";
               output += "<a href=\"profiles/";
               output += data[b].username;
               output += "\">";
               output += data[b].postedBy;
               output += "</a>";
               output += "</td>";
               output += "</tr>";


            /*   output += "</tbody>";
               output += "</table>";*/




          }
          $('#commingAnunturi').html(output);
          console.log(output);
        }
      })
    }
  </script>

  <script type="text/javascript">
    var intervalId = 0;
    intervalId = setInterval(scoateAnunturiCurente, 2000);
  </script>

</head>
<body>
    <div>
        <h1 id="anunturiRecente">Anunturile recente</h1>
    </div>
    <div>
        <h3 id="demo">

        </h3>
    </div>

    <div id="vineJsonAnunturi">
      <table class="table">
          <thead >
          <tr style="background-color: #ffbb99;">
              <th style="color:red;">Subiect</th>
              <th>Descriere</th>
              <th>Postat de</th>
          </tr>
          </thead>
      <tbody id="commingAnunturi">
        <%--// OVER HERE IS COMING;--%>
      </tbody>
      </table>
    </div>

    <script>
        var d = new Date();
        document.getElementById("demo").innerHTML = d.toDateString();
    </script>
</body>



