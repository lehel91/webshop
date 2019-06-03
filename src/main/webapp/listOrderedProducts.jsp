<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%-- <%@ page import="java.util.ArrayList" %> --%>
<%-- <%@ page import="com.bh08.model.Product" %> --%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Megrendelt termékek</title>

</head>

<body>
		<table>
	
		    <thead>
		        <tr>
		            <th>Termék neve</th>
		            <th>Termék ára (/db)</th>
		            <th>Megrendelt Darabszám</th>
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
		                        <c:out value="${numberOfProductsOrdered[count.index]}"/>
		                    </td>               
		                </tr>	                
		        </c:forEach>
		    </tbody>
	    </table>
	    
	    <h3>A megrendelt termékek eredeti ára: <c:out value="${originalPrice}"/></h3>
	    <h3>A megrendelt termékek kedvezményes ára: <c:out value="${priceWithPromotions}"/></h3>
	    <h3>Kedvezmény típusa: <c:out value="${promotion}"/></h3> 
	    
</body>
</html>