<%@ page language="java" contentType="text/html;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tuteur</title>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %><section class="py-5 text-left bg-light">
        <div class="container">
            <div class="row">
                <h2 class="col text">Vos information</h2>
            </div>
            <div id="parent_0" class="row jumbotron jumbotron-fluid my-4 shadow-sm">
                <div class="container px-5">
                    <div id="ds">
                        <div class="d-flex">
                            <h1 id="nom" class="display-4 flex-fill">Ahmed Essoubai</h1>
                            <div class="mx-3 icon-g"><a title="Editer" onclick="editParent(0)"><span><i class="fas fa-pen"></i></span></a></div>
                        </div>
                        <div class="d-flex mt-4">
                            <p class="lead flex-fill">CIN : <span id="cin">HH18457</span><br>Profession : <span id="profession">Game Dev</span></p>
                            <p class="lead flex-fill">Tel : <span id="tel">0674154228</span><br>E-mail : <span id="email">ahmedessoubai@gmail.com</span></p>
                        </div>
                    </div>
                    <div id="edt" class="container px-0 hd">
                        <input id="id" type="text" hidden value="0" />
                        <form onsubmit="return updateParent(0)">
                            <div class="row my-3">
                                <div class="col-md-5 pr-1">
                                    <input id="prenom" type="text" class="form-control" placeholder="Prenom" value="Ahmed" required />
                                </div>
                                <div class="col-md-5 pr-4">
                                    <input id="nom" type="text" class="form-control" placeholder="Nom" value="Essoubai" required />
                                </div>
                                <div class="col-md-2">
                                    <input id="cin" type="text" class="form-control" placeholder="CIN" value="HH18457" required />
                                </div>
                            </div>
                            <div class="row my-3">
                                <div class="col">
                                    <div class="my-3">
                                        <input id="tel" class="form-control" type="tel" placeholder="Numéro de téléphone" value="0674154228" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="email" class="form-control" type="email" placeholder="Address e-mail" value="ahmedessoubai@gmail.com" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="profession" class="form-control" type="text" placeholder="Profession" value="Game Dev" required />
                                    </div>
                                    <div class="mt-4 d-flex justify-content-end">
                                        <button type="submit" class="btn btn-primary px-5">Mise à jour</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row bg-white shadow-sm p-3">
                <div class="col-12">
                    <a class="_link lead" data-toggle="collapse" href="#autre" role="button" aria-expanded="false" aria-controls="collapseExample">
                        Autre parent
                    </a>
                </div>
                <div id="autre" class="col-12 collapse">
                    <hr class="my-4"/>
                    <dir id="list">
                        <div id="vide" class="col-12 text-muted text-center py-2 px-2">
                            <h2 class="my-3" style="font-size: 3em"><i class="fas fa-book"></i></h2>
                            <h4 class="my-3">Aucun parent enregistré</h4>
                        </div>
                    </dir>
                    <hr class="my-4"/>
                    <div id="new" class="p-4">
                        <h4 class="mb-4">Ajouter parent</h4>
                        <form onsubmit="return addParent()" class="container px-0">
                            <div class="row mt-3 mb-3">
                                <div class="col-md-5 pr-1">
                                    <input id="prenom" type="text" class="form-control" placeholder="Prenom" required />
                                </div>
                                <div class="col-md-5 pr-4">
                                    <input id="nom" type="text" class="form-control" placeholder="Nom" required />
                                </div>
                                <div class="col-md-2">
                                    <input id="cin" type="text" class="form-control" placeholder="CIN" required />
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <div class="my-3">
                                        <input id="tel" class="form-control" type="tel" placeholder="Numéro de téléphone" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="email" class="form-control" type="email" placeholder="Address e-mail" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="profession" class="form-control" type="text" placeholder="Profession" required />
                                    </div>
                                    <div class="mt-4 d-flex justify-content-end">
                                        <button type="submit" class="btn btn-primary px-5">Ajouter</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
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
    <script src="js/tuteurs-list.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>