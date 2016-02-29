<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><s:text name="capacitySalesManagement" /></title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script src="js/globalize.js"></script>
<script src="js/d3.js" charset="utf-8"></script>
</head>
<body class="bodyBack">
	<div class="container" style="width:1170px;">
		<div class="adminBody">
			<h2>
				<s:text name="capacitySalesManagement" />
			</h2>
			<br>
			<div class="text-center">
				<h4><s:text name="capacityBrowsed" /></h4>
				<form name="search">
					<select name="year" id="startYear">
						<option value=""><s:text name="capacityYearBrow"/></option>
						<option value="2016">2016<s:text name="capacityYear"/></option>
						<option value="2017">2017<s:text name="capacityYear"/></option>
						<option value="2018">2018<s:text name="capacityYear"/></option>
						<option value="2019">2019<s:text name="capacityYear"/></option>
						<option value="2020">2020<s:text name="capacityYear"/></option>
						<option value="2021">2021<s:text name="capacityYear"/></option>
						<option value="2022">2022<s:text name="capacityYear"/></option>
						<option value="2023">2023<s:text name="capacityYear"/></option>
						<option value="2024">2024<s:text name="capacityYear"/></option>
						<option value="2025">2025<s:text name="capacityYear"/></option>
						<option value="2026">2026<s:text name="capacityYear"/></option>
						<option value="2027">2027<s:text name="capacityYear"/></option>
					</select>
					<select name="month" id="startMonth">
						<option value="00"><s:text name="capacityMonthBrow"/></option>
						<option value="01">1<s:text name="capacityMonth"/></option>
						<option value="02">2<s:text name="capacityMonth"/></option>
						<option value="03">3<s:text name="capacityMonth"/></option>
						<option value="04">4<s:text name="capacityMonth"/></option>
						<option value="05">5<s:text name="capacityMonth"/></option>
						<option value="06">6<s:text name="capacityMonth"/></option>
						<option value="07">7<s:text name="capacityMonth"/></option>
						<option value="08">8<s:text name="capacityMonth"/></option>
						<option value="09">9<s:text name="capacityMonth"/></option>
						<option value="10">10<s:text name="capacityMonth"/></option>
						<option value="11">11<s:text name="capacityMonth"/></option>
						<option value="12">12<s:text name="capacityMonth"/></option>
					</select>
						～
					<select name="lastYear" id="endYear">
						<option value=""><s:text name="capacityYearBrow"/></option>
						<option value="2016">2016<s:text name="capacityYear"/></option>
						<option value="2017">2017<s:text name="capacityYear"/></option>
						<option value="2018">2018<s:text name="capacityYear"/></option>
						<option value="2019">2019<s:text name="capacityYear"/></option>
						<option value="2020">2020<s:text name="capacityYear"/></option>
						<option value="2021">2021<s:text name="capacityYear"/></option>
						<option value="2022">2022<s:text name="capacityYear"/></option>
						<option value="2023">2023<s:text name="capacityYear"/></option>
						<option value="2024">2024<s:text name="capacityYear"/></option>
						<option value="2025">2025<s:text name="capacityYear"/></option>
						<option value="2026">2026<s:text name="capacityYear"/></option>
						<option value="2027">2027<s:text name="capacityYear"/></option>
					</select>
					<select name="lastMonth" id="endMonth">
						<option value="99"><s:text name="capacityMonthBrow"/></option>
						<option value="01">1<s:text name="capacityMonth"/></option>
						<option value="02">2<s:text name="capacityMonth"/></option>
						<option value="03">3<s:text name="capacityMonth"/></option>
						<option value="04">4<s:text name="capacityMonth"/></option>
						<option value="05">5<s:text name="capacityMonth"/></option>
						<option value="06">6<s:text name="capacityMonth"/></option>
						<option value="07">7<s:text name="capacityMonth"/></option>
						<option value="08">8<s:text name="capacityMonth"/></option>
						<option value="09">9<s:text name="capacityMonth"/></option>
						<option value="10">10<s:text name="capacityMonth"/></option>
						<option value="11">11<s:text name="capacityMonth"/></option>
						<option value="12">12<s:text name="capacityMonth"/></option>
					</select>
					<input type="button" class="btn btn-primary" id="searchButton"
						value="<s:text name="capacitySearch"/>">
					<div id="errorMessage"></div>
				</form>
			</div>
			<br>
			<div class="graph">
				<div id="myGraph"></div>
			</div>
			<br>
		</div>
		<div class="adminFooter"></div>
	</div>
</body>
</html>