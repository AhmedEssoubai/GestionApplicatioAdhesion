<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Familles</title>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
    <section class="py-5 text-left bg-light">
        <div class="container">
            <div class="row">
                <div class="container px-0">
                    <div class="row">
                        <h2 class="col text">Les familles</h2>
                    </div>
                    <div id="list" class="row">
                        <div id="vide" class="col-12 text-muted text-center py-2 px-2 
                            <c:if test="${fn:length(requestScope.familles) != 0 }">
                                hd
                            </c:if>">
                            <h2 class="my-3" style="font-size: 3em"><i class="fas fa-book"></i></h2>
                            <h4 class="my-3">Aucune famille</h4>
                        </div>
                        <c:forEach var="famille" items="${requestScope.familles }">
                        <div id="famille_${famille.NUM_adhesion }" class="col-12 my-3">
                            <div class="bg-white shadow-sm p-4">
                                <div id="ds" class="d-flex">
                                    <div class="flex-grow-1 d-flex flex-column">
                                        <h4 id="nom" class="mb-4"><a class="_link" href="Parents?num=${famille.NUM_adhesion}">${famille.tuteur.prenom } ${famille.tuteur.nom }</a></h4>
                                        <p class="text-muted">Email : <span id="email">${famille.tuteur.email }</span></p>
                                        <p class="text-muted">Nombre d'enfants : <span id="classe">${famille.nbEnfants }</span></p>
                                    </div>
                                    <c:if test="${famille.RECEVOIR_OPT}">
                                    <div class="d-flex pl-2 pr-5">
                                        <span class="icon-mute" title="Notifications activées"><i class="fas fa-bell"></i></span>
                                    </div>
                                    </c:if>
                                    <c:if test="${famille.DELEGUE_OPT}">
                                    <div class="d-flex pl-2 pr-5">
                                        <span class="icon-mute" title="Delegue candidat"><i class="fas fa-user"></i></span>
                                    </div>
                                    </c:if>
                                    <div>
                                        <div class="mx-3 icon-r"><a title="Supprimer" onclick="deleteEnfant(${famille.NUM_adhesion })" role="button"><span><i class="fa fa-times"></i></span></a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script>
        $( document ).ready(function() {
            count = ${fn:length(requestScope.familles)};
        });
    </script>
    <script src="js/functions.js"></script>
    <script src="js/familles-list-admin.js"></script>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>