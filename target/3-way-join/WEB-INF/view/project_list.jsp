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
			<h2> Project</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
					
			<table>
				<tr>
					
					<th>Name</th>
                                        <th>Action</th> 
                                        
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProject" items="${projects}">
				
					<c:url var="updateLink" value="/project/updateForm">
						<c:param name="projectId" value="${tempProject.idproject}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/project/delete">
						<c:param name="projectId" value="${tempProject.idproject}" />
					</c:url>
                                        
                                        <c:url var="list" value="/project/ticketList">
						<c:param name="projectId" value="${tempProject.idproject}" />
					</c:url>

					<tr>
						
						<td> ${tempProject.projectname} </td>
                                                
						
                                                <td>
                                                        <!-- display the update link -->
                                                        <a href="${updateLink}">Update</a>
                                                        |
                                                        <a href="${deleteLink}"
                                                           onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                                                        |
                                                        <a href="${list}">List</a>
                                                </td>
                                               			
					</tr>
                                        
                                                
                                       
				         
				</c:forEach>
						
			</table>
				
		</div>
            <table>
                 <c:forEach var="tempUser" items="${projects.users}">
                    <tr><td>${tempUser}<td/> <tr/> 
                </c:forEach>     
                 
            </table>
	</div>
	

</body>

</html>









