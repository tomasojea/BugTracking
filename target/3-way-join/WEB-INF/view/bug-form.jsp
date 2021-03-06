<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>

<head>
	
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
        
</head>

<body>
	
	<nav class="navbar navbar-light bg-light border rounded">
            <span class="navbar-brand text-muted">CRM - Customer Relationship Manager</span>
        </nav>

	<div class="navbar navbar-light bg-light border rounded">
		<span class="navbar-text ">Assign Users</span>
	
		<form:form action="saveBug" modelAttribute="wrapper" method="POST">
                    <div class="form-group border rounded w-25">
                        <label class="navbar-text">Bug status:</label>
                        <form:select  path="bug" cssClass="form-control form-control-sm">
                            <form:option value="NONE"> --SELECT--</form:option>
                            <form:options items="${bug}" itemValue="idbug" itemLabel="status" ></form:options>
                        </form:select>  
                    </div>
                    <div class="form-group border rounded w-25">
                        <label class="navbar-text" >Users:</label>
                        <form:select multiple="true" path="users" cssClass="form-control form-control-sm">
                            <form:option value="NONE"> --SELECT--</form:option>
                            <form:options items="${users}" itemValue="idUser" itemLabel="name" ></form:options>
                        </form:select>    
		    </div>
		 <input type="submit" value="Save" class="btn btn-primary" />
		</form:form>
                  
	        
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/bug/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>




















