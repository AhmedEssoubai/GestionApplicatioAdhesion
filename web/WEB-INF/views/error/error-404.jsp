<%@ page isErrorPage="true" language="java" contentType="text/html;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error-500</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
	
    <div class="container text-center">
        <div class="row my-3">
            <div class="col my-5">
                <div class="my-5 py-5">
                    <h1>Oops!</h1>
                    <h2>404 Pas trouvé</h2>
                    <div>
                        Désolé, une erreur s'est produite, page demandée introuvable!
                    </div>
                    <div class="text-white my-3">
                        <a href="Accueil" class="btn btn-primary btn-lg">
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