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
					
					<th>Name</th>
                                        <th>id</th> 
                                        
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${tickets}">
				
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="customerId" value="${tempUser.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="ticketId" value="${tempUser.id}" />
					</c:url>
					<tr>
						
						<td> ${tempUser.project.projectname} </td>
                                                <td> ${tempUser.user} </td>
						
											
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
            <table>
                <!-- <c:forEach var="tempUser" items="${Ticket}">
                    <tr><td>${tempUser}<td/> <tr/> 
                </c:forEach>     -->  
                 
            </table>
	</div>
	

</body>

</html>









