<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/25/16
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/resources/css/addingAnnouncement.css" rel="stylesheet">
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
    <div id="adaugareAnunt">
        <h2>Plasarea anuntului</h2>
    </div>
   <form:form action="/addannouncement" method="post" commandName="announcement" id="formAnunt">
    <div class="form-group">
        <label for="subjectLabel">Subiectul anuntului</label>
        <form:input path="subject" class="form-control" id="subjectLabel"/>
    </div>
    <div class="form-group">
        <label for="descriptionLabel">Descrierea anuntului</label>
        <form:textarea path="description" class="form-control" id="descriptionLabel" rows="3" />
    </div>
    <div class="form-group">
            <label for="locationsLabel">Alege localitatea</label>
            <form:select path="locations" class="form-control" id="locationsLabel"  multiple="true" >
                <form:option value="Chisinau" >Chisinau</form:option>
                <form:option value="Balti" >Balti</form:option>
                <form:option value="Cahul" >Cahul</form:option>
                <form:option value="Hincesti" >Hincesti</form:option>
                <form:option value="Ialoveni" >Ialoveni</form:option>
                <form:option value="Orhei" >Orhei</form:option>
                <form:option value="Tiraspol" >Tiraspol</form:option>
                <form:option value="Tighina" >Tighina</form:option>
                <form:option value="Rabnita" >Rabnita</form:option>
                <form:option value="Ungheni" >Ungheni</form:option>
                <form:option value="Soroca" >Soroca</form:option>
                <form:option value="Dubasari" >Dubasari</form:option>
                <form:option value="Straseni" >Straseni</form:option>
                <form:option value="Causeni" >Causeni</form:option>
                <form:option value="Drochia" >Drochia</form:option>
                <form:option value="Edinet" >Edinet</form:option>
                <form:option value="Falesti" >Falesti</form:option>
                <form:option value="Calarasi" >Calarasi</form:option>
                <form:option value="Floresti" >Floresti</form:option>
                <form:option value="Cimislia" >Cimislia</form:option>
                <form:option value="Nisporeni" >Nisporeni</form:option>
                <form:option value="Glodeni" >Glodeni</form:option>
                <form:option value="Rezina" >Rezina</form:option>
                <form:option value="Leova" >Leova</form:option>
                <form:option value="Ocnita" >Ocnita</form:option>
                <form:option value="Briceni" >Briceni</form:option>
                <form:option value="Telenesti" >Telenesti</form:option>
                <form:option value="Lipcani" >Lipcani</form:option>
                <form:option value="Cantemir" >Cantemir</form:option>
                <form:option value="Maiac" >Maiac</form:option>
            </form:select>
    </div>
    <div class="form-group">
        <label for="categoryLabel">Alege categoria</label>
        <form:select path="categories" class="form-control" id="categoryLabel" multiple="true" >
            <form:option value="Electronica">Electronica</form:option>
            <form:option value="Constructie">Constructie</form:option>
            <form:option value="Soferie">Soferie</form:option>
            <form:option value="Bucatar">Bucatar</form:option>
            <form:option value="Dadac">Dadac</form:option>
            <form:option value="Contabilitate">Contabilitate</form:option>
            <form:option value="Livrare">Livrare</form:option>
            <form:option value="Domiciliu">Domiciliu</form:option>
            <form:option value="Ceremonii">Ceremonii</form:option>
            <form:option value="Fotograf">Fotograf</form:option>
            <form:option value="Calculatoare">Calculatoare</form:option>
        </form:select>
    </div>
       <div>
           <input type="submit" class="btn btn-default" value="Trimite" />
       </div>

    </form:form>



  <%--<form:form action="/addannouncement" method="post" commandName="announcement">
      <div>
        Subiect
        <form:input path="subject"/>
      </div>
      <div>
        Description
        <form:input path="description" />
      </div>
      <div>
          Localitate
          <form:select path="locations" multiple="true" size="3">
              <form:option value="Chisinau" >Chisinau</form:option>
              <form:option value="Balti" >Balti</form:option>
              <form:option value="Cahul" >Cahul</form:option>
              <form:option value="Hincesti" >Hincesti</form:option>
              <form:option value="Ialoveni" >Ialoveni</form:option>
              <form:option value="Orhei" >Orhei</form:option>
              <form:option value="Tiraspol" >Tiraspol</form:option>
              <form:option value="Tighina" >Tighina</form:option>
              <form:option value="Rabnita" >Rabnita</form:option>
              <form:option value="Ungheni" >Ungheni</form:option>
              <form:option value="Soroca" >Soroca</form:option>
              <form:option value="Dubasari" >Dubasari</form:option>
              <form:option value="Straseni" >Straseni</form:option>
              <form:option value="Causeni" >Causeni</form:option>
              <form:option value="Drochia" >Drochia</form:option>
              <form:option value="Edinet" >Edinet</form:option>
              <form:option value="Falesti" >Falesti</form:option>
              <form:option value="Calarasi" >Calarasi</form:option>
              <form:option value="Floresti" >Floresti</form:option>
              <form:option value="Cimislia" >Cimislia</form:option>
              <form:option value="Nisporeni" >Nisporeni</form:option>
              <form:option value="Glodeni" >Glodeni</form:option>
              <form:option value="Rezina" >Rezina</form:option>
              <form:option value="Leova" >Leova</form:option>
              <form:option value="Ocnita" >Ocnita</form:option>
              <form:option value="Briceni" >Briceni</form:option>
              <form:option value="Telenesti" >Telenesti</form:option>
              <form:option value="Lipcani" >Lipcani</form:option>
              <form:option value="Cantemir" >Cantemir</form:option>
              <form:option value="Maiac" >Maiac</form:option>
          </form:select>
      </div>
     <div>
          Categorie
          <form:select path="categories" multiple="true" size="3">
              <form:option value="Electronica">Electronica</form:option>
              <form:option value="Constructie">Constructie</form:option>
              <form:option value="Soferie">Soferie</form:option>
              <form:option value="Bucatar">Bucatar</form:option>
              <form:option value="Dadac">Dadac</form:option>
              <form:option value="Contabilitate">Contabilitate</form:option>
              <form:option value="Livrare">Livrare</form:option>
              <form:option value="Domiciliu">Domiciliu</form:option>
              <form:option value="Ceremonii">Ceremonii</form:option>
              <form:option value="Fotograf">Fotograf</form:option>
              <form:option value="Calculatoare">Calculatoare</form:option>
          </form:select>
      </div>
      <div>
          <input type="submit" value="Add" />
      </div>
    </form:form>--%>
</body>
</html>
