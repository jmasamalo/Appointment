<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>Appointment App</title>
 	
 	<script type="text/javascript" src="<spring:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
 	
	<script type="text/javascript" src="<spring:url value="/resources/js/ajax.js"/>"></script>
	
	<style type="text/css">@import url(resources/css/main.css);</style>
</head>
<body>
	<div id="global">
	    <h1>WELCOME TO APPOINTMENT SYSTEM</h1>
		
		<div id="errors" style="display:none" > </div><br>
		
		<div id="newButton"><input type="button" value="NEW" onclick="newSelected();" /></div>
		
		<div id="cancelButton"  style="display:none"> 
		<input type="button" value="CANCEL"  onclick="cancelSelected();"  /></div>
		
		
		<div id="addForm" style="display:none">
			
			<form:form modelAttribute="appointment"  action="" method="POST">
			<fieldset>
				<legend>Add an appointment</legend>
				<p>
					<form:errors path="*" cssStyle="color : red;" />
				</p>
				
				<p>
					<label for="dateTime">Date and Time (YYYY-MM-DD HH:MM:SS): </label>
					<form:input path="dateTime" size="20" maxlength="19"/>
				</p>
				
				<p>
					<label for="description">Description: </label>
					<form:input path="description" size="50" />
				</p>
				
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4" value="RESET"> 
					<input id="submit" type="submit" tabindex="5" value="ADD">
				</p>
			</fieldset>
		</form:form>
			
		</div>
		
		<div id="searchSection">
		 
			<br>
			<form id="searchForm" method="post" >
			<input type="text" name="search" placeholder="type here to search" size="50" />
			&nbsp;&nbsp;
			<input type="button" value="SEARCH" onclick="getAppointments();" />
			</form>
		 
		 </div>
		<h3>APPOINTMENTS</h3>
		
		<div  id="appointmentsTable" style="display:none" ></div> 
		
		</div>
		
	
</html>