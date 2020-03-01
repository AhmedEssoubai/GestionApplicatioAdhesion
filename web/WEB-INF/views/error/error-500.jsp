<%@ page isErrorPage="true" language="java" contentType="text/html;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Articles</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
	
    <div class="container text-center">
        <div class="row my-3">
            <div class="col my-5">
                <div class="my-5 py-5">
                    <h1>Oops!</h1>
                    <h2>500 Erreur d'exception</h2>
                    <div>
                        Il y a une erreur d'erreur s'est produite, peut-être parce que la base de données
                    </div>
                    <div class="text-white my-3">
                        <a href="/" class="btn btn-primary btn-lg">
                            Accueil 
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>