<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Type de Logement</title>
		</head>
		<body>
			<jsp:include page="header.jsp"></jsp:include>
			<main class="container">
				<div class="col-md-12 text-center">
					<h1>Gestion des types de logement</h1>
				</div>
				<div class="col-md-12 text-center">			
						<form class="form-horizontal" method="post" action="CreationTypeLogement">
							<div class="form-group">
								<label class="control-label col-md-offset-3 col-md-2">Nom : </label> 
								<div class="col-md-4">
									<input required class="form-control" type="text" name="inputNom">
								</div>
							</div>							
							<button class="btn btn-default" type="submit" name="submitCreer">Créer</button>								
						</form>
						<form class="form-horizontal" method="post" action="SuppressionTypeLogement">
							<div class="form-group">
								<label class="control-label col-md-offset-3 col-md-2">Nom : </label> 
								<div class="col-md-4">
									<input required class="form-control" type="text" name="inputNom">
								</div>
							</div>							
							<button class="btn btn-default" type="submit" name="submitSupprimer">Supprimer</button>								
						</form>
					</div>
					<div class="col-md-12 text-center ${display}">
						<p class="confirmation">					
							${confirmation}							
						</p>
					</div>		
			</main>
			<jsp:include page="footer.jsp"></jsp:include>
		
		</body>
	</html>