<%--
  Created by IntelliJ IDEA.
  User: Mahadi
  Date: 30/10/2022
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Payable Tax</title>
</head>
<body>

<br><br>

<table align="center">
  <tr>
    <td>
      <label>Tax Payable Ammount:</label>
    </td>
    <td>
      <p>Taka, ${taxpayable}</p>
    </td>
  </tr>

  <tr>
    <td>
      <label>Tax Ammount:</label>
    </td>
    <td>
      <p>Taka, ${nettax}</p>
    </td>
  </tr>

  <tr>
    <td>
      <label>Monthly Payable Tax Ammount:</label>
    </td>
    <td>
      <p>Taka, ${mnettax}</p>
    </td>
  </tr>

</table>


<br><br>
<h3 align="center"><a href="http://localhost:8080/spring_webmvc_war_exploded/tax">Calculate Again</a></h3>
<br><br>

<h3>Taxable Income Calculation</h3>
<table>

  <tr>
    <th>Area</th>
    <th>Amount</th>
    <th>Max. Exemption</th>
    <th>Taxable</th>
  </tr>

  <tr>
    <td>Basic Salary</td>
    <td>${salary}</td>
    <td>0</td>
    <td>${salary}</td>
  </tr>

  <tr>
    <td>House Rent</td>
    <td>${hrent}</td>
    <td>${maxhta}</td>
    <td>${hta}</td>
  </tr>

  <tr>
    <td>Medical Allowance</td>
    <td>${med}</td>
    <td>${ten}</td>
    <td>${meda}</td>
  </tr>

  <tr>
    <td>Conveyance</td>
    <td>${con}</td>
    <td>30000</td>
    <td>${cont}</td>
  </tr>

  <tr>
    <td>Incentive/OT</td>
    <td>${ot}</td>
    <td>0</td>
    <td>${ot}</td>
  </tr>

  <tr>
    <td>Festival Bonus</td>
    <td>${fbonus}</td>
    <td>0</td>
    <td>${fbonus}</td>
  </tr>

  <tr>
    <td>Total</td>
    <td>${total}</td>
    <td>-</td>
    <td>${taxpayable}</td>
  </tr>
</table>


<br><br>

<h3>Gross Tax Liability</h3>
<table>
  <tr>
    <th>Slab</th>
    <th>Tax%</th>
    <th>Amount</th>
    <th>Tax</th>
  </tr>
  <tr>
    <td>${a}</td>
    <td>0%</td>
    <td>${avalue}</td>
    <td>0</td>
  </tr>
  <tr>
    <td>On the Next 100000 Taka</td>
    <td>5%</td>
    <td>${taxammfive}</td>
    <td>${taxfive}</td>
  </tr>
  <tr>
    <td>On the Next 300000 Taka</td>
    <td>10%</td>
    <td>${taxammten}</td>
    <td>${taxten}</td>
  </tr>
  <tr>
    <td>On the Next 400000 Taka</td>
    <td>15%</td>
    <td>${taxammfiften}</td>
    <td>${taxfiften}</td>
  </tr>
  <tr>
    <td>On the Next 500000 Taka</td>
    <td>20%</td>
    <td>${taxammtwenty}</td>
    <td>${taxtwenty}</td>
  </tr>
  <tr>
    <td>Above</td>
    <td>25%</td>
    <td>${taxammtwentyfive}</td>
    <td>${taxtwentyfive}</td>
  </tr>
  <tr>
    <td>Gross Tax Liability</td>
    <td>-</td>
    <td>-</td>
    <td>${tax}</td>
  </tr>
</table>

<br><br>

<h3>Rebate Calculation</h3>
<table>
  <tr>
    <th>Type</th>
    <th>Amount</th>
  </tr>
  <tr>
    <td>Your Investment</td>
    <td>${invest}</td>
  </tr>
  <tr>
    <td>Accepted Investment</td>
    <td>${maxinvest}</td>
  </tr>
  <tr>
    <td>Rebate</td>
    <td>${rebate}</td>
  </tr>
</table>

<br><br>


<h3>Net Tax Payable</h3>
<table>
  <tr>
    <th>Type</th>
    <th>Amount</th>
  </tr>
  <tr>
    <td>Gross Tax Liability(BDT)</td>
    <td>${tax}</td>
  </tr>
  <tr>
    <td>Tax after Rebate(BDT)</td>
    <td>${nettax}</td>
  </tr>
  <tr>
    <td>Net Tax Payble(BDT) Per year</td>
    <td>${nettax}</td>
  </tr>
  <tr>
    <th>Net Tax Payble(BDT) Per Month</th>
    <td>${mnettax}</td>
  </tr>
</table>





</body>
</html>
