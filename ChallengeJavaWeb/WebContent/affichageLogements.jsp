<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout Dispo</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
		<div class="col-md-12 text-center">
				<h1>Ajout de disponibilités</h1>
		</div>
		<div class="col-md-12 text-center">
		<form class="form-horizontal" method="post">
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Propriétaire : </label>
				<div class="col-md-4">
					<select  class="form-control" name="inputProprio">						
						<c:forEach items="${resultat}" var="proprio">
						<option value="${proprio.id}">${proprio.nom} ${proprio.prenom}</option>
					</c:forEach>
					</select>	
				</div>		
			</div>
			<button class="btn btn-default" type="submit" name="submitProprio">Afficher</button>
		</form>
	</div>
	<div class="col-md-12 text-center ${proprioDisplay}">
		<p class="confirmation">${nomProprio}</p>
	</div>
	<div class="col-md-12 text-center ${logementDisplay}">
		<form class="form-horizontal" method="post">
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Logement(s) : </label>
				<div class="col-md-4">
					<select class="form-control" name="inputLogement">
						<c:forEach items="${logements}" var="appart">
							<option value="${appart.id}">${appart.adresse.toString()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Date de début : </label>
				<div class="col-md-4">
					<input required class="form-control" type="date" name="inputDateDebut">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Date de fin : </label>
				<div class="col-md-4">
					<input required class="form-control" type="date" name="inputDateFin">
				</div>
			</div>
			<button class="btn btn-default" type="submit" name="submitDispo">Ajouter</button>
		</form>	
	</div>
	<div class="col-md-12 text-center ${noLogementDisplay}">
		<p class="confirmation">Aucun Logement.</p>
	</div>	
			<%-- ${ logements }	 --%>
	<div class="col-md-12 text-center ${confirmationDisplay}">
		<p class="confirmation">					
			Dispo crée !							
		</p>
	</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>