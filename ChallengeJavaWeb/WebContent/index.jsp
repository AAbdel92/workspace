<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>		
		<title>Simplon's AirBnB</title>
	</head>
	<body>			
		<jsp:include page="header.jsp"></jsp:include>		
		<main class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6 text-center">
					<h1>Bienvenue !</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-offset-4 col-md-4 col-xs-6">
					<p>
						Bon ya des boutons en dessous, ou à droite si vous êtes sur un petit écran (et oé, responsive et tout), 
						j'ai pas besoin de vous dire quoi faire ! GL & HF	
					</p>
				</div>	
				<div class="col-md-12 text-center col-xs-4">
					<a class="btn btn-danger" href="CreationProprio">Créer un propriétaire</a>
					<a class="btn btn-danger" href="CreationLogement">Créer un logement</a>
					<a class="btn btn-danger" href="AffichageLogements">Ajouter une disponibilités</a>
					<a class="btn btn-danger" href="Recherche">Rechercher un logement</a>
					<a class="btn btn-danger" href="TypeLogement">Type de Logements</a>		
				</div>				
			</div>
			<div class="col-md-12 text-center ${display}">
				<p class="confirmation">
					T'as plus qu'à appeler ${proprio.toString()} au ${proprio.tel} et de négocier !
				</p>			
			</div>
			<%-- ${ resultat }	 --%>	
		</main>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>