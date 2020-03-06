<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <h2 class="col text">
                    <c:choose>
                        <c:when test="${sessionScope.isAdmin}">
                            Information de #${ requestScope.num_adhesion } - <a class="_link" href="Enfants?num=${requestScope.num_adhesion}">Enfants</a>
                             - <a class="_link" href="Facture?num=${requestScope.num_adhesion}">Facture</a>
                        </c:when>
                        <c:otherwise>
                            Vos information
                        </c:otherwise>
                    </c:choose>
                </h2>
            </div>
            <div id="parent_${requestScope.tuteur.ID }" class="row jumbotron jumbotron-fluid my-4 shadow-sm">
                <div class="container px-5">
                    <div id="ds">
                        <div class="d-flex">
                            <h1 id="nom" class="display-4 flex-fill">${requestScope.tuteur.prenom } ${requestScope.tuteur.nom }</h1>
                            <div class="mx-3 icon-mute"><a title="Editer" onclick="editParent(${requestScope.tuteur.ID })"><span><i class="fas fa-pen"></i></span></a></div>
                        </div>
                        <div class="d-flex mt-4">
                            <p class="lead flex-fill">CIN : <span id="cin">${requestScope.tuteur.cin }</span><br>Profession : <span id="profession">${requestScope.tuteur.profession }</span></p>
                            <p class="lead flex-fill">Tel : <span id="tel">${requestScope.tuteur.tel }</span><br>E-mail : <span id="email">${requestScope.tuteur.email }</span></p>
                        </div>
                    </div>
                    <div id="edt" class="container px-0 hd">
                        <form onsubmit="return updateParent(${requestScope.tuteur.ID })">
                            <div class="row my-3">
                                <div class="col-md-5 pr-1">
                                    <input id="prenom" type="text" maxlength="125" class="form-control" placeholder="Prenom" value="${requestScope.tuteur.prenom }" required />
                                </div>
                                <div class="col-md-5 pr-4">
                                    <input id="nom" type="text" maxlength="125" class="form-control" placeholder="Nom" value="${requestScope.tuteur.nom }" required />
                                </div>
                                <div class="col-md-2">
                                    <input id="cin" type="text" maxlength="10" class="form-control" placeholder="CIN" value="${requestScope.tuteur.cin }" required />
                                </div>
                            </div>
                            <div class="row my-3">
                                <div class="col">
                                    <div class="my-3">
                                        <input id="tel" class="form-control" maxlength="10" type="tel" placeholder="Tel" value="${requestScope.tuteur.tel }" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="email" class="form-control" maxlength="125" type="email" placeholder="Address e-mail" value="${requestScope.tuteur.email }" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="profession" class="form-control" maxlength="125" type="text" placeholder="Profession" value="${requestScope.tuteur.profession }" required />
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
                        <div id="vide" class="col-12 text-muted text-center py-2 px-2 
                            <c:if test="${fn:length(requestScope.parents) != 0 }">
                                hd
                            </c:if>
                             ">
                            <h2 class="my-3" style="font-size: 3em"><i class="fas fa-book"></i></h2>
                            <h4 class="my-3">Aucun parent enregistré</h4>
                        </div>
                        <c:forEach var="parent" items="${requestScope.parents }">
                            <div id="parent_${parent.ID }" class="col-12 my-3">
                                <div class="pt-4 px-4">
                                    <div id="ds" class="d-flex">
                                        <div class="flex-grow-1 d-flex flex-column">
                                            <h4 id="nom" class="mb-4">${parent.prenom } ${parent.nom }</h4>
                                            <p class="text-muted">Tel : <span id="tel">${parent.tel }</span></p>
                                            <p class="text-muted">Address e-mail : <span id="email">${parent.email }</span></p>
                                            <p class="text-muted">Profession : <span id="profession">${parent.profession }</span></p>
                                        </div>
                                        <div class="d-flex pl-2 pr-5">
                                            <p>CIN : <span id="cin">${parent.cin }</span></p>
                                        </div>
                                        <div class="d-flex">
                                            <div class="mx-3 icon-mute"><a title="Editer" onclick="editParent(${parent.ID })"><span><i class="fas fa-pen"></i></span></a></div>
                                            <div class="mx-3 icon-r"><a title="Supprimer" onclick="deleteParent(${parent.ID })" role="button"><span><i class="fa fa-times"></i></span></a></div>
                                        </div>
                                    </div>
                                    <div id="edt" class="container px-0 hd">
                                        <form onsubmit="return updateParent(${parent.ID })">
                                            <div class="row my-3">
                                                <div class="col-md-5 pr-1">
                                                    <input id="prenom" type="text" maxlength="125" class="form-control" placeholder="Prenom" value="${parent.prenom }" required />
                                                </div>
                                                <div class="col-md-5 pr-4">
                                                    <input id="nom" type="text" maxlength="125" class="form-control" placeholder="Nom" value="${parent.nom }" required />
                                                </div>
                                                <div class="col-md-2">
                                                    <input id="cin" type="text" maxlength="10" class="form-control" placeholder="CIN" value="${parent.cin }" required />
                                                </div>
                                            </div>
                                            <div class="row my-3">
                                                <div class="col">
                                                    <div class="my-3">
                                                        <input id="tel" class="form-control" maxlength="10" type="tel" placeholder="Tel" value="${parent.tel }" required />
                                                    </div>
                                                    <div class="my-4">
                                                        <input id="email" class="form-control" maxlength="125" type="email" placeholder="Address e-mail" value="${parent.email }" required />
                                                    </div>
                                                    <div class="my-4">
                                                        <input id="profession" class="form-control" type="text" placeholder="Profession" value="${parent.profession }" required />
                                                    </div>
                                                    <div class="mt-4 d-flex justify-content-end">
                                                        <button type="submit" class="btn btn-primary px-5">Mise à jour</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <hr class="mt-3"/>
                                </div>
                            </div>
                        </c:forEach>
                    </dir>
                    <hr class="my-4"/>
                    <div id="new" class="p-4">
                        <h4 class="mb-4">Ajouter parent</h4>
                        <form onsubmit="return addParent()" class="container px-0">
                            <div class="row mt-3 mb-3">
                                <div class="col-md-5 pr-1">
                                    <input id="prenom" type="text" maxlength="125" class="form-control" placeholder="Prenom" required />
                                </div>
                                <div class="col-md-5 pr-4">
                                    <input id="nom" type="text" maxlength="125" class="form-control" placeholder="Nom" required />
                                </div>
                                <div class="col-md-2">
                                    <input id="cin" type="text" maxlength="10" class="form-control" placeholder="CIN" required />
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <div class="my-3">
                                        <input id="tel" class="form-control" type="tel" maxlength="10" placeholder="Numéro de téléphone" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="email" class="form-control" type="email" maxlength="125" placeholder="Address e-mail" required />
                                    </div>
                                    <div class="my-4">
                                        <input id="profession" class="form-control" type="text" maxlength="125" placeholder="Profession" required />
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

    <script>
        var num = ${ requestScope.num_adhesion };
        $( document ).ready(function() {
            count = ${fn:length(requestScope.parents)};
        });
    </script>
    <script src="js/functions.js"></script>
    <script src="js/tuteurs-list.js"></script>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>