<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: MAHADI
  Date: 10/12/2022
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>

<% List<String> cityList = new ArrayList<>();
    cityList.add("Dhaka");
    cityList.add("Sylhet");
    cityList.add("Barishal");

    pageContext.setAttribute("cities", cityList);
%>

<%@ include file="header.jsp"%>

<h1>Welcome, <% out.println(request.getAttribute("firstname")); %>
    <% out.println(request.getAttribute("lastname")); %>
</h1>

</body>
</html>
