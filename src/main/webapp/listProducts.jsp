<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%-- <%@ page import="java.util.ArrayList" %> --%>
<%-- <%@ page import="com.bh08.model.Product" %> --%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Termékek</title>

</head>

<body>
	<form action="WebshopServlet" method="post">
		<table>
	
		    <thead>
		        <tr>
		            <th>Termék neve</th>
		            <th>Termék ára (/db)</th>
		            <th>Darabszám</th>
		        </tr>
		    </thead>
	
		    <tbody>
		
		        <c:forEach var="product" items="${products}" varStatus="count">
		
		
		                <tr>
		                    <td>
		                        <c:out value="${product.name}"/>
		                    </td>
		                    <td>
								<c:out value="${product.price}"/>
		                    </td>    
		                    <td>
		                        <input type="number" name="${count.index}" min="0" max="99" value="0">
		                    </td>               
		                </tr>
		                
		        </c:forEach>
		    </tbody>
	    </table>
	    
	    <input type="submit" value="Termékek megrendelése">
	    
    </form>
</body>
</html>