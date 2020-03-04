<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Se connecter</title>
    <link rel="stylesheet" href="css/style-login.css" />
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
    <section id="login">
        <div class="container mw-100">
            <div class="row my-5">
                <div class="col-sm-4 offset-sm-4 p-5 my-5 bg-white shadow">
                    <form class="py-5" method="POST" action="Connect">
                        <h2 class="mb-5 pb-3">
                            Se connecter
                        </h2>
                        <div class="form-groupe my-4">
                            <label class="control-label" for="email">Email:</label>
                            <input id="email" type="email" name="email" value="${param.email }" class="form-control" placeholder="Entrer votre email" />
                        </div>
                        <div class="form-groupe my-4">
                            <label class="control-label" for="motdepass">Mot de passe:</label>
                            <input id="motdepass" name="password" type="password" class="form-control" placeholder="Entrer votre mot de passe" />
                        </div>
                        <c:if test='${requestScope.err != null}'>
                        	<span class="lead text-danger">Mot de passe ou e-mail incorrect</span>
                        </c:if>
                        <div class="form-groupe mt-5">
                            <button type="submit" class="btn btn-primary btn-lg form-control">
                                Se connecter
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section class="py-5">
        <div class="container">
            <div class="row">
                <div class="col">
                    <h5 class="text-secondary">Vous n'avez pas de compte ? veuillez s'inscrire ici : <a href="Inscrire" class="_link">S'inscrire</a></h5>
                </div>
            </div>
        </div>
    </section>
    
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>