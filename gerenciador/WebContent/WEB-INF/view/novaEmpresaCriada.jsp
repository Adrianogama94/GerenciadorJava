<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<body>
<c:import url="logout-parcial.jsp"/>
	<c:if test="${not empty empresa}">

		Cadastro da empresa: ${empresa}


	</c:if>
	<c:if test="${empty empresa}">

		Sem empresa cadastrada


	</c:if>

</body>
</html>