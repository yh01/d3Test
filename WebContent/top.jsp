<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-type" content="text/html;chrarset=UTF-8">
    <title></title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.css">
    <link rel="stylesheet" href=css/style.css>
    <link href="http://netdna.bootstrapcdn">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.css" rel="stylesheet">
    <link href="/css/lightbox.css" type="/text/css" rel="stylesheet" media="screen" />
    <link rel="stylesheet" type="text/css" href="lib/sweet-alert.css">
     <link rel="stylesheet" href=css/top.css>
    <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
    <script src="lib/sweet-alert.min.js"></script>
    <script src="js/prototype.js" type="text/javascript"></script>
    <script src="js/scriptaculous.js?load=effects,builder" type="text/javascript"></script>
    <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/D3Graph.js"></script>


  </head>
  <body>
    <div class="contents">
		<div id ="D3Graph"></div>
		<s:iterator value="">
		<table>
		<tr><td><s:property value=""/></td></tr>
		<tr><td><s:property value=""/></td></tr>
		</table>
		</s:iterator>
	</div>
  </body>
</html>
