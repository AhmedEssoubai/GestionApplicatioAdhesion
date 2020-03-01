<%@ page language="java" contentType="text/html;"%>
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
            <div class="row bg-white shadow p-5">
                <form class="col" action="#" method="POST" onsubmit="return checkForm()">
                    <h2 class="mb-3">
                        Modifiez vos informations
                    </h2>
                    <div class="form-groupe my-3">
                        <label class="control-label" for="email">E-mail</label>
                        <input type="email" name="email" class="form-control" id="email" value="${param.email }" placeholder="Votre email" required>
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