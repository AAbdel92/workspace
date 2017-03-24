<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création Proprio</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
		<div class="col-md-12 text-center">
			<h1>Création de propriétaire</h1>
		</div>
		<div class="col-md-12 text-center">			
				<form class="form-horizontal" method="post">
					<div class="form-group">
						<label class="control-label col-md-offset-3 col-md-2">Nom : </label> 
						<div class="col-md-4">
							<input required class="form-control" type="text" name="inputNom" pattern="^[A-Z][a-z]+(-[A-Z][a-z]*|\s[A-Z][a-z]*|)[a-z]*">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-offset-3 col-md-2">Prénom : </label>
						<div class="col-md-4"> 
							<input required class="form-control" type="text" name="inputPrenom" pattern="^[A-Z][a-z]+(-[A-Z]|)[a-z]*">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-offset-3 col-md-2">Téléphone : </label>
						<div class="col-md-4"> 
							<input required class="form-control" type="tel" name="inputTel" 
							pattern="^(?:0|\(?\+33\)?\s?|0033\s?)[1-79](?:[\.\-\s]?\d\d){4}$">
						</div>
					</div>
					<button class="btn btn-default" type="submit">Créer</button>								
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