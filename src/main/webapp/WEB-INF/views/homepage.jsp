<%--
  Created by IntelliJ IDEA.
  User: Mahadi
  Date: 30/10/2022
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>You are Warmly Welcome to Calculator your income Tax</h1>

<br><br>

<form method="post" action="tax/calculate">
    <label for="category">Choose Tax Payer Category</label><br>
    <select name="category" id="category">
        <option>General</option>
        <option>Female/Senior Citizen</option>
        <option>Disabled</option>
        <option>Gazetted Freedom Fighters</option>
    </select>
    <br><br>


    <label for="zone">Choose Zone</label><br>
    <select name="zone" id="zone">
        <option>Dhaka/Chattagram City</option>
        <option>Other City</option>
        <option>Rest of the Country</option>
    </select>
    <br><br><br>


    <label>Salary Breakdown</label><br>
    <table>
        <tr>
            <th>Area</th>
            <th>Amount</th>
        </tr>

        <tr>
            <td><label for="salary">Basic Salary</label></td>
            <td> <input type="number" name="salary" id="salary" value="0"> </td>
        </tr>

        <tr>
            <td><label for="hrent">House Rent</label></td>
            <td> <input type="number" name="hrent" id="hrent" value="0"> </td>
        </tr>

        <tr>
            <td><label for="med">Medical Allowance</label></td>
            <td> <input type="number" name="med" id="med" value="0"> </td>
        </tr>

        <tr>
            <td><label for="con">Conveyance</label></td>
            <td> <input type="number" name="con" id="con" value="0"> </td>
        </tr>

        <tr>
            <td><label for="ot">Incentive/OT</label></td>
            <td> <input type="number" name="ot" id="ot" value="0"> </td>
        </tr>

        <tr>
            <td><label for="fbonus">Festival Bonous</label></td>
            <td> <input type="number" name="fbonus" id="fbonus" value="0"> </td>
        </tr>
    </table>

    <br>
    <h3>Investment</h3>
    <table>
        <tr>
            <th><label for="invest">Investment Ammount</label></th>
            <td><input type="number" name="invest" id="invest" value="0"></td>
        </tr>
    </table>
    <br>

    <input type="submit" name="submit" value="Calculate tax">


    <br><br><br>






</form>
</body>
</html>
