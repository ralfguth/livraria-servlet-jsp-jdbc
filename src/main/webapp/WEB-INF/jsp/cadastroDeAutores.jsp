<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Autores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/main.css" rel="stylesheet">
</head>
<body class="container">
	<section id="formularioDeRegistro" class="bg-primary border border-primary rounded mt-3">
	<h1 class="text-center text-white">Cadastro De Autor</h1>
	<div class="sub-section border-top rounded-bottom">
	<form action='<c:url value="/autores" />' method="post">
		<div class="form-group">
			<input id="nome" name="nome" class="mt-2 form-control" placeholder="Nome" required>
		</div>
		<div class="form-group">
			<input id="email" type="email" name="email" class="mt-2 form-control" placeholder="E-mail" required>
		</div>
		<div class="form-group">
			<input id="nascimento" type="date" name="nascimento" class="mt-2 form-control" placeholder="Data de Nascimento" required>
		</div>
		<div class="form-group">
			<textarea id="biografia" name="biografia" class="mt-2 form-control" rows="3" placeholder="Biografia Resumida"></textarea>
		</div>
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="mt-2 btn btn-outline-primary">
		</div>
	</form>
	</div>
	</section>
	
	<section id="listaDeAutoresCadastrados" class="bg-success border border-success rounded mt-3">
	<h1 class="text-center text-white">Lista de Autores</h1>
	<div class="sub-section border-top rounded-bottom">
	<table class="table table-hover table-bordered">
		<thead class="bg-light">
			<tr>
				<th scope="col">NOME</th>
				<th scope="col">E-MAIL</th>
				<th scope="col">DATA DE NASCIMENTO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${autores}" var="autor">
				<tr>
					<td>${autor.nome}</td>
					<td>${autor.email}</td>
					<td>${autor.nascimentoFormatado}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</section>

</body>
</html>