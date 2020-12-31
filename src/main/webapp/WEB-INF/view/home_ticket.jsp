<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Projects</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> Project's tickets</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
					
			<table>
				<tr>
					
					<th>Ticket Id</th>
                                        <th>Username</th> 
                                        <th>Project name</th> 
                                        <th>Bug</th> 
                                        <th>Status</th> 
                                                                              
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${tickets}">
                                    
                                        <tr>
						<td> ${tempUser.idticket} </td>
						<td> ${tempUser.user.name} </td>
						<td> ${tempUser.project.projectname} </td>
						<td> ${tempUser.bug.name} </td>
						<td> ${tempUser.bug.status} </td>
					</tr>
                                    
                                </c:forEach>
						
			</table>
				
		</div>
            <table>
                <!-- <c:forEach var="tempUser" items="${Ticket}">
                        <c:forEach items="${tempUser.tickets}" var="ticket" >
                        <tr><td>${tempUser}<td/> <tr/> 
                        </c:forEach> 
                     </c:forEach>     -->  
                 
            </table>
	</div>
	

</body>

</html>









