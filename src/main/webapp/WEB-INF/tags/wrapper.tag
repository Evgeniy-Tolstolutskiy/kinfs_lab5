<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ attribute name="homePage" required="true" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Main page</title>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
        <link href="${bootstrapCss}" rel="stylesheet" />
    </head>
<body>
<div class="jumbotron">
<nav class="navbar navbar-inverse navbar-fixed-top">
        	<div class="container">
        		<div class="navbar-header">
        			<a class="navbar-brand" href="${homePage}">Web client for oracle db</a>
        		</div>
        	</div>
        </nav>
        </div>
<div class="container">
	<div class="row">
        <jsp:doBody/>
	</div>
    	</div>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
    <script src="${bootstrapJs}"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    </body>
    </html>