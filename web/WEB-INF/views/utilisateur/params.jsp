<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifiez vos informations</title>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
    
    <section class="py-5 text-left bg-light">
        <div class="container">
            <c:set var="status">${requestScope.status}</c:set>
            <c:if test='${status != null && status != ""}'>
            <c:choose>
    		<c:when test="${status == 0 }">
                    <div class="alert row alert-danger alert-dismissible fade show" role="alert">
                        <strong>Quelque chose a mal tourné!</strong> Peut-être que les informations fournies sont erronées ou non valides
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
    		</c:when>
                <c:otherwise>
                    <div class="alert row alert-success alert-dismissible fade show" role="alert">
                        La mise à jour a bien été enregistrée
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:otherwise>
            </c:choose>
            </c:if>
            <div class="row bg-white shadow-sm p-5">
                <form class="col" action="Compte" method="POST" onsubmit="return checkForm()">
                    <h2 class="mb-3">
                        Modifiez vos informations
                    </h2>
                    <div class="form-groupe my-3">
                        <label class="control-label" for="email">E-mail</label>
                        <input type="email" name="email-c" class="form-control" id="email" value="${requestScope.email }" placeholder="Votre email" required>
                    </div>
                    <div class="form-groupe my-3">
                        <label class="control-label" for="old_pwd">Mot de passe actuel</label>
                        <input type="password" name="old_password" placeholder="Entrez le mot de passe actuel" class="form-control" id="old_pwd" required>
                    </div>
                    <div class="form-groupe my-3">
                        <label class="control-label" for="new_pwd">Nouveau mot de passe</label>
                        <input type="password" name="new_password" placeholder="Entrez un nouveau mot de passe" class="form-control" id="new_pwd">
                    </div>
                    <div class="form-groupe my-3">
                        <label class="control-label" for="conf_pwd">Veuillez retapez le nouvel mot de passe</label>
                        <input type="password" name="conf_password" placeholder="Confirmer le nouveau mot de passe" class="form-control" id="conf_pwd">
                    </div>
                    <c:if test="${!sessionScope.isAdmin}">
                    <div class="custom-control custom-checkbox my-3">
                        <input class="custom-control-input" type="checkbox" id="recevoir" 
                        <c:if test="${requestScope.recevoir}">
                               checked
                        </c:if>
                               name="recevoir" >
                        <label class="custom-control-label" for="recevoir">
                            Je souhaite recevoir les informations concernant l’association
                        </label>
                    </div>
                    <div class="custom-control custom-checkbox my-3">
                        <input class="custom-control-input" type="checkbox" id="delegue" 
                        <c:if test="${requestScope.delegue}">
                               checked
                        </c:if>
                               name="delegue">
                        <label class="custom-control-label" for="delegue">
                            Je souhaite être parents délégués au conseil d’école
                        </label>
                    </div>
                    </c:if>
                    <p class="text-danger" id="msg_err"></p>
                    <div class="form-groupe mt-5">
                        <button type="submit" class="btn btn-primary btn-lg form-control">Mettre à jour</button>
                    </div>
                </form>
            </div>
        </div>
    </section>

    <script src="js/functions.js"></script>
    <script src="js/params.js"></script>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>