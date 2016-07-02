<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/4/16
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../includes.jsp"%>
<link href="/resources/css/registrationStyle.css" rel="stylesheet" />
<div id="registrationBox">
<form:form action="/submitregistration" method="post" commandName="user">
  <table>
      <tr>
        <td>First name</td>
        <td><form:input path="firstName" /></td>
      </tr>
      <tr>
        <td>Last name</td>
        <td><form:input path="lastName" /></td>
      </tr>
      <tr>
        <td>Username</td>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><form:input path="password" /></td>
      </tr>
      <tr>
          <td>Date of birth</td>
          <td><form:input path="birthday" /></td>
      </tr>
      <tr>
          <td>Cell phone</td>
          <td><form:input path="phone" /></td>
      </tr>
      <tr>
          <td>Email</td>
          <td><form:input path="email" /></td>
      </tr>
      <tr>
        <td>Location</td>
        <td>
            <form:select path="locations" multiple="true" size="3">
                <option value="Chisinau">Chisinau</option>
                <option value="Balti">Balti</option>
                <option value="Cahul">Cahul</option>
                <option value="Hincesti">Hincesti</option>
                <option value="Ialoveni">Ialoveni</option>
                <option value="Orhei">Orhei</option>
                <option value="Tiraspol">Tiraspol</option>
                <option value="Tighina">Tighina</option>
                <option value="Rabnita">Rabnita</option>
                <option value="Ungheni">Ungheni</option>
                <option value="Soroca">Soroca</option>
                <option value="Dubasari">Dubasari</option>
                <option value="Straseni">Straseni</option>
                <option value="Causeni">Causeni</option>
                <option value="Drochia">Drochia</option>
                <option value="Edinet">Edinet</option>
                <option value="Falesti">Falesti</option>
                <option value="Calarasi">Calarasi</option>
                <option value="Floresti">Floresti</option>
                <option value="Cimislia">Cimislia</option>
                <option value="Nisporeni">Nisporeni</option>
                <option value="Glodeni">Glodeni</option>
                <option value="Rezina">Rezina</option>
                <option value="Leova">Leova</option>
                <option value="Ocnita">Ocnita</option>
                <option value="Briceni">Briceni</option>
                <option value="Telenesti">Telenesti</option>
                <option value="Lipcani">Lipcani</option>
                <option value="Cantemir">Cantemir</option>
                <option value="Maiac">Maiac</option>
            </form:select>
        </td>
      </tr>
      <tr>
          <td>Category</td>
          <td>
              <form:select path="categories" multiple="true" size="3">
                  <option value="Electronica">Electronica</option>
                  <option value="Constructie">Constructie</option>
                  <option value="Soferie">Soferie</option>
                  <option value="Bucatar">Bucatar</option>
                  <option value="Dadac">Dadac</option>
                  <option value="Contabilitate">Contabilitate</option>
                  <option value="Livrare">Livrare</option>
                  <option value="Domiciliu">Domiciliu</option>
                  <option value="Ceremonii">Ceremonii</option>
                  <option value="Fotograf">Fotograf</option>
                  <option value="Calculatoare">Calculatoare</option>
              </form:select>

          </td>
      </tr>
      <tr>
        <td>
        <input type="submit" name="action" value="Add" />
      </td>
      </tr>
  </table>
  </form:form>
</div>