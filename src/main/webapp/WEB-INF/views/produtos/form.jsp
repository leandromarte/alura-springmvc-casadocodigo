<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST" commandName="produto">
		<label>T&iacute;tulo</label>
		<form:input path="titulo" />
		<form:errors path="titulo" />
		<br/>
		<label>Descri&ccedil;&atilde;o</label>
		<form:textarea path="descricao" />
		<form:errors path="descricao" />
		<br/>
		<label>P&aacute;ginas</label>
		<form:input path="paginas" />
		<form:errors path="paginas" />
		<br/>
		<label>Data de lan&ccedil;amento</label>
		<form:input path="dataLancamento" />
		<form:errors path="dataLancamento" />
		<br/>
				
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
	        <div>
	            <label>${tipoPreco}</label>
	            <form:input path="precos[${status.index}].valor" />
	            <form:input type="hidden" path="precos[${status.index}].tipoPreco" value="${tipoPreco}" />
	        </div>
		</c:forEach>		
		
		<input type="submit" value="Salvar">
	</form:form>
</body>
</html>