<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/nv.d3.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/jPages.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.2/d3.min.js"
	charset="utf-8"></script>
<script src="js/d3.js"></script>
<script src="js/nv.d3.js"></script>
<script src="js/stream_layers.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="js/jPages.js"></script>
<style>
text {
	font: 12px sans-serif;
}
html, body {
	margin: 0px;
	padding: 0px;
	height: 100%;
	width: 100%;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<s:form action="D3Action">
	<s:textfield name="d3test"></s:textfield>
	<s:submit value="set" type="button"/>
	</s:form>
	<div class="text-center">
		<svg class="chart1" id="chart1"></svg>
		<svg class="chart2" id="chart2"></svg>
	</div>
	<div class="text-center">
		<h4>test1:<span id="test1"><s:property value="test1" /></span></h4>
		<h4>test2:<span id="test2"><s:property value="test2" /></span></h4>
		<h4>test3:<span id="test3"><s:property value="test3" /></span></h4>
	</div>
	<script src="js/donutCircle.js"></script>
	<script src="js/graph.js"></script>
</body>
</html>