<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création Logement</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
		<div class="col-md-12 text-center">
				<h1>Création de logement</h1>
		</div>
		<div class="col-md-12 text-center">
		<form class="form-horizontal" method="post">
		
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Propriétaire : </label>
				<div class="col-md-4">
					<select  class="form-control" name="inputProprio">
						${ resultat }
					</select>	
				</div>		
			</div>
			<div class="form-group">										
				<label class="control-label col-md-offset-3 col-md-2">Numéro de voie : </label>
				<div class="col-md-4"> 
				<input required class="form-control" type="text" name="inputVoie">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Rue : </label>
				<div class="col-md-4"> 
					<input required class="form-control" type="text" name="inputRue">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Code postal : </label>
				<div class="col-md-4"> 
					<input required class="form-control" type="text" name="inputCodePostal" pattern="[0-9]{5}" title="5 chiffres">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Ville : </label>
				<div class="col-md-4"> 
					<input required class="form-control" type="text" name="inputVille">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Complément d'adresse : </label>
				<div class="col-md-4"> 
					<input class="form-control" type="text" name="inputCompAdresse">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Description : </label>
				<div class="col-md-4"> 
					<textarea class="form-control" name="inputDescription"></textarea>
				</div>
			</div>
			<button class="btn btn-default" type="submit">Créer</button>	
		</form>
		</div>
		<div class="col-md-12 text-center ${display}">
			<p class="confirmation">					
				Logement crée !							
			</p>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>