<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simplon AirBnB - Recherche</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
		<div class="col-md-12 text-center">
				<h1>Recherche de Logements</h1>
		</div>
	<div class="col-md-12 text-center">	
		<form class="form-horizontal" method="post">
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Ville : </label>
				<div class="col-md-4">
					<input required class="form-control" type="text" name="inputVille">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2"> date de début : </label>
				<div class="col-md-4">
					<input required class="form-control" type="date" name="inputDateDebut">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2"> date de fin : </label>
				<div class="col-md-4">
					<input required class="form-control" type="date" name="inputDateFin">
				</div>
			</div>
			<button class="btn btn-default" type="submit" name="submitRecherche">Chercher</button>				
		</form>
	</div>
	<div class="col-md-12 text-center ${logementsDisplay}">
		<form class="form-horizontal" method="post">
			<div class="form-group">
				<label class="control-label col-md-offset-3 col-md-2">Logement(s) : </label>
				<div class="col-md-4">
					<select class="form-control" name="inputLogement">
						${logements}
					</select>
				</div>
			</div>
			<button class="btn btn-default" type="submit" name="submitLocation">Valider</button>
		</form>
	</div>
	<div class="col-md-12 text-center ${noLogementDisplay}">
		<p class="confirmation">Aucun logement disponible.</p>
	</div>	
	<%-- ${ logements } --%>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>