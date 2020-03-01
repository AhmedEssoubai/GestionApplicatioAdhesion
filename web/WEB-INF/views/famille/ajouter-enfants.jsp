<%@ page language="java" contentType="text/html;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajoutez vos enfants</title>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
    <section class="py-5 text-left bg-light">
        <div class="container">
            <div class="row">
                <form action="#" method="POST" class="container" onsubmit="return canSubmit()">
                    <div class="row">
                        <h2 class="col text">Les enfants</h2>
                    </div>
                    <div id="list" class="row">
                        <div id="vide" class="col-12 text-muted text-center py-2 px-2">
                            <h2 class="my-3" style="font-size: 3em"><i class="fas fa-book"></i></h2>
                            <h4 class="my-3">Ajoutez vos enfants</h4>
                        </div>
                    </div>
                    <div class="my-3 d-flex justify-content-end">
                        <button id="envoyer" type="submit" class="btn btn-sec px-5 mx-3" disabled>Envoyer</button>
                    </div>
                </form>
            </div>
            <div class="row">
                <div class="col my-3">
                    <div id="new" class="bg-white shadow-sm p-4">
                        <h4 class="mb-4">Ajouter un enfant</h4>
                        <form onsubmit="return addEnfant()" class="container px-0">
                            <div class="row my-3">
                                <div class="col-md-5 pr-1">
                                    <input id="prenom" type="text" class="form-control" placeholder="Prenom" required />
                                </div>
                                <div class="col-md-5 pr-4">
                                    <input id="nom" type="text" class="form-control" placeholder="Nom" required />
                                </div>
                                <div class="col-md-2">
                                    <input id="cne" type="text" class="form-control" placeholder="CNE" required />
                                </div>
                            </div>
                            <div class="row my-3">
                                <div class="col">
                                    <input id="date_naissance" class="form-control my-3" type="date" placeholder="Date de naissance" required />
                                    <select id="classe" class="custom-select my-3" placeholder="Classe" required>
                                        <option value="Primaire">Primaire</option>
                                        <option value="Collège">Collège</option>
                                        <option value="Lycée">Lycée</option>
                                    </select>
                                    <select id="assurance" class="custom-select my-3" placeholder="Assurance" onchange="onAssuranceChanged(-1)" required >
                                        <option value="Assurance Hospitalisation/Soins de santé">Assurance Hospitalisation/Soins de santé</option>
                                        <option value="Assurance Individuelle Accident">Assurance Individuelle Accident</option>
                                    </select>
                                    <div class="custom-control custom-checkbox my-3">
                                        <input class="custom-control-input" type="checkbox" id="accepter" onchange="onAccepterChanged(-1)">
                                        <label class="custom-control-label" for="accepter">
                                            J'ai lu et j'accepte les conditions de l'assurance
                                        </label>
                                    </div>
                                    <div class="mt-4 d-flex justify-content-end">
                                        <button id="btn_add" type="submit" class="btn btn-primary px-5" disabled>Ajouter</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="js/functions.js"></script>
    <script src="js/enfants-list.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>