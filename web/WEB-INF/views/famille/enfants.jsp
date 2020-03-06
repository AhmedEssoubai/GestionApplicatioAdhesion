<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enfants</title>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
    <section class="py-5 text-left bg-light">
        <div class="container">
            <div class="row">
                <div class="container px-0">
                    <div class="row">
                        <h2 class="col text">Les enfants de <a class="_link" href="Parents?num=${requestScope.num_adhesion}">#${ requestScope.num_adhesion }</a></h2>
                    </div>
                    <div id="list" class="row">
                        <div id="vide" class="col-12 text-muted text-center py-2 px-2 
                            <c:if test="${fn:length(requestScope.enfants) != 0 }">
                                hd
                            </c:if>">
                            <h2 class="my-3" style="font-size: 3em"><i class="fas fa-book"></i></h2>
                            <h4 class="my-3">Ajoutez des enfants</h4>
                        </div>
                        <c:forEach var="enfant" items="${requestScope.enfants }">
                        <div id="enfant_${enfant.ID }" class="col-12 my-3">
                            <div class="bg-white shadow-sm p-4">
                                <div id="ds" class="d-flex">
                                    <div class="flex-grow-1 d-flex flex-column">
                                        <h4 id="nom" class="mb-4">${enfant.prenom } ${enfant.nom }</h4>
                                        <p class="text-muted">Date de naissance : <span id="date">${enfant.date_naissence }</span></p>
                                        <p class="text-muted">Classe : <span id="classe">${enfant.grade }</span></p>
                                        <p class="text-muted">Assurance : <span id="assurance">${enfant.assurance }</span></p>
                                    </div>
                                    <div class="d-flex pl-2 pr-5">
                                        <p>CNE : <span id="cne">${enfant.cne }</span></p>
                                    </div>
                                    <c:if test="${sessionScope.isAdmin}">
                                    <div>
                                        <div class="mx-3 icon-r"><a title="Supprimer" onclick="deleteEnfant(${enfant.ID })" role="button"><span><i class="fa fa-times"></i></span></a></div>
                                    </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <c:if test="${sessionScope.isAdmin}">
            <div class="row">
                <div class="col my-3">
                    <div id="new" class="bg-white shadow-sm p-4">
                        <h4 class="mb-4">Ajouter un enfant</h4>
                        <form onsubmit="return addEnfant()" class="container px-0">
                            <div class="row my-3">
                                <div class="col-md-5 pr-1">
                                    <input id="prenom" type="text" maxlength="125" class="form-control" placeholder="Prenom" required />
                                </div>
                                <div class="col-md-5 pr-4">
                                    <input id="nom" type="text" maxlength="125" class="form-control" placeholder="Nom" required />
                                </div>
                                <div class="col-md-2">
                                    <input id="cne" type="text" maxlength="10" class="form-control" placeholder="CNE" required />
                                </div>
                            </div>
                            <div class="row my-3">
                                <div class="col">
                                    <input id="date_naissance" class="form-control my-3" type="date" placeholder="Date de naissance" required />
                                    <select id="classe" class="custom-select my-3" placeholder="Classe" required>
                                        <option value="Primaire">Primaire</option>
                                        <option value="College">Collège</option>
                                        <option value="Lycee">Lycée</option>
                                    </select>
                                    <select id="assurance" class="custom-select my-3" placeholder="Assurance" required >
                                        <option value="Assurance Hospitalisation">Assurance Hospitalisation</option>
                                        <option value="Assurance Individuelle Accident">Assurance Individuelle Accident</option>
                                    </select>
                                    <div class="mt-4 d-flex justify-content-end">
                                        <button id="btn_add" type="submit" class="btn btn-primary px-5">Ajouter</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            </c:if>
        </div>
    </section>

    <c:if test="${sessionScope.isAdmin}">
        <script>
            var num = ${ requestScope.num_adhesion };
            $( document ).ready(function() {
                count = ${fn:length(requestScope.enfants)};
            });
        </script>
        <script src="js/functions.js"></script>
        <script src="js/enfants-list-admin.js"></script>
    </c:if>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>