<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>S'inscrire</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style-login.css"/>
</head>
<body>
    <section id="login">
        <div class="container mw-100">
            <div class="row my-5">
                <div class="col-sm-4 offset-sm-4 p-5 bg-white shadow">
                    <form>
                        <h2 class="mb-5 pb-3">
                            S'inscrire
                        </h2>
                        <div class="form-groupe my-3">
                            <label class="control-label" for="nom">Entrez votre nom : </label>
                            <input id="nom" name="nom" value="${param.nom }" type="text" class="form-control" placeholder="Entrer votre prenom" required autofocus />
                        </div>
                        <div class="form-groupe my-3">
                            <label class="control-label" for="prenom">Entrez votre prenom : </label>
                            <input id="prenom" name="prenom" value="${param.prenom }" type="text" class="form-control" placeholder="Entrez votre prenom" required />
                        </div>
                        <div class="form-groupe my-3">
                            <label class="control-label" for="cin">Entrez votre CIN : </label>
                            <input id="cin" name="cin" type="text" value="${param.cin }" class="form-control" placeholder="Enrer vote CIN" required />
                        </div>
                        <div class="form-groupe my-3">
                            <label class="control-label" for="email">Entrez votre address e-mail : </label>
                            <input id="adresse" name="email" value="${param.email }" type="email" class="form-control" placeholder="Enrer vote email" required />
                        </div>
                        <div class="form-group  my-3">
                            <label for="password">Mot de passe : </label>
                            <input type="password" name="password" class="form-control" id="password" placeholder="Mot de passe" required />
                        </div>
                        <div class="form-group  my-3">
                            <label for="passwordConf">Veuillez confirmer votre mot de passe : </label>
                            <input type="password" name="passwordConf" class="form-control" id="passwordConf" placeholder="Confirmer le mot de passe" required />
                        </div>
                        <div class="form-groupe my-3">
                            <label class="control-label" for="tel">Entrez votre numéro de téléphone : </label>
                            <input id="tel" name="tel" type="tel" value="${param.tel }" class="form-control" placeholder="Enrer vote numéro de téléphone" required />
                        </div>
                        <div class="form-groupe my-3">
                            <label class="control-label" for="profession">Entrez votre profession : </label>
                            <input id="profession" name="profession" value="${param.profession }" type="text" class="form-control" placeholder="Enrer vote profession" required />
                        </div>
                        <div class="custom-control custom-checkbox my-3">
                            <input class="custom-control-input" type="checkbox" id="recevoir" value="${param.recevoir }" name="recevoir" checked>
                            <label class="custom-control-label" for="recevoir">
                                Je souhaite recevoir les informations concernant l’association
                            </label>
                        </div>
                        <div class="custom-control custom-checkbox my-3">
                            <input class="custom-control-input" type="checkbox" id="delegue" value="${param.delegue }" name="delegue">
                            <label class="custom-control-label" for="delegue">
                                Je souhaite être parents délégués au conseil d’école
                            </label>
                        </div>
                        <c:if test='${requestScope.err != null}'>
                        	<span class="lead errorMessage">Les informations données sont incorrectes</span>
                        </c:if>
                        <div class="form-groupe mt-5">
                            <button type="submit" class="btn btn-primary btn-lg form-control">S'inscrire</button>
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
                    <h5 class="text-secondary">Si vous possédez déjà un compte. <a href="login.html" class="_link">Se connecter</a></h5>
                </div>
            </div>
        </div>
    </section>
    
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>