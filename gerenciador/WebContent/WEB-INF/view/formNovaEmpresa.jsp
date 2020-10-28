<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>
	<form action="${linkEntradaServlet}" method="post">

		Nome: <input type="text" name="nome" />
		<br>
		<br>
		Data Abertura: <input type="text" name="dataAbertura" />
		 <input type="hidden" name=acao value="NovaEmpresa" />
		
		<input type="submit"/>
	
	</form>
</body>
</html>