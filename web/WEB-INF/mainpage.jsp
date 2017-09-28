<%-- 
    Document   : mainpage
    Created on : Sep 25, 2017, 12:56:09 PM
    Author     : 685442
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:import url="/includes/header.html" />
    <h1>Main Page</h1>
    Hello, ${userN}<br>
    <a href="MainPage?LoggedOut">Log Out</a>
<c:import url="/includes/footer.html" />
