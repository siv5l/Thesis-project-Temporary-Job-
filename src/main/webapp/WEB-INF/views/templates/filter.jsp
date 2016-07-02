<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/26/16
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/resources/css/filterStyle.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
  <div id="filterContent">
    <form action="/submitfilter" method="post" role="form">
      <div id="radioBtns">
        <div class="radio">
          <label><input type="radio" name="option" value="unnemployed" checked="checked">Someri</label>
        </div>
        <div class="radio">
          <label><input type="radio" name="option" value="announcement">Anunturi</label>
        </div>
      </div>

      <div class="form-group">
        <label class="labelText" for="categories">Selecteaza categoria</label>
        <select class="form-control" id="categories" name="category" size="4" >
          <option class="bold" value="Electronica">Electronica</option>
          <option class="bold" value="Constructie">Constructie</option>
          <option class="bold" value="Soferie">Soferie</option>
          <option class="bold" value="Bucatar">Bucatar</option>
          <option class="bold" value="Dadac">Dadac</option>
          <option class="bold" value="Contabilitate">Contabilitate</option>
          <option class="bold" value="Livrare">Livrare</option>
          <option class="bold" value="Domiciliu">Domiciliu</option>
          <option class="bold" value="Ceremonii">Ceremonii</option>
          <option class="bold" value="Fotograf">Fotograf</option>
        </select>
      </div>

      <div class="form-group">
        <label class="labelText" for="locations">Selecteaza localitatea</label>
        <select class="form-control" id="locations" name="location" size="4">
          <option class="bold" value="Chisinau">Chisinau</option>
          <option class="bold" value="Balti">Balti</option>
          <option class="bold" value="Cahul">Cahul</option>
          <option class="bold" value="Hincesti">Hincesti</option>
          <option class="bold" value="Ialoveni">Ialoveni</option>
          <option class="bold" value="Orhei">Orhei</option>
          <option class="bold" value="Tiraspol">Tiraspol</option>
          <option class="bold" value="Tighina">Tighina</option>
          <option class="bold" value="Rabnita">Rabnita</option>
          <option class="bold" value="Ungheni">Ungheni</option>
          <option class="bold" value="Soroca">Soroca</option>
          <option class="bold" value="Dubasari">Dubasari</option>
          <option class="bold" value="Straseni">Straseni</option>
          <option class="bold" value="Causeni">Causeni</option>
          <option class="bold" value="Drochia">Drochia</option>
          <option class="bold" value="Edinet">Edinet</option>
          <option class="bold" value="Falesti">Falesti</option>
          <option class="bold" value="Calarasi">Calarasi</option>
          <option class="bold" value="Floresti">Floresti</option>
          <option class="bold" value="Cimislia">Cimislia</option>
          <option class="bold" value="Cimislia">Cimislia</option>
          <option class="bold" value="Nisporeni">Nisporeni</option>
          <option class="bold" value="Glodeni">Glodeni</option>
          <option class="bold" value="Rezina">Rezina</option>
          <option class="bold" value="Leova">Leova</option>
          <option class="bold" value="Ocnita">Ocnita</option>
          <option class="bold" value="Briceni">Briceni</option>
          <option class="bold" value="Telenesti">Telenesti</option>
          <option class="bold" value="Lipcani">Lipcani</option>
          <option class="bold" value="Cantemir">Cantemir</option>
          <option class="bold" value="Maiac">Maiac</option>
        </select>
      </div>
      <div>
        <input type="submit" class="btn btn-info" value="Cauta">
      </div>
    </form>
  </div>
</body>
</html>
