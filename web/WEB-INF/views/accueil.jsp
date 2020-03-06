<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
    <link rel="stylesheet" href="css/style-accueil.css">
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>

    <section id="welcome" class="py-5">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center text-white pt-md-5">
                    <h1 class="display-4 mt-5 pt-5">
                        “Children are likely to live up to what you believe of them.”
                    </h1>
                    <p class="lead">
                        Lady Bird Johnson Former <i>First Lady of the United States</i>
                    </p>
                    <c:if test="${sessionScope.utilisateur == null }">
                    <div class="mt-5">
                        <a href="Inscrire" class="btn btn-sec btn-lg px-5 rounded-pill">
                            S'inscrire
                        </a>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </section>

    <section class="py-5 text-center bg-white">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="mb-5">
                        <h1 class="text-primary pb-3">
                            Club d'adhésion
                        </h1>
                        <p class="lead pb-3">
                            Club d'adhésion est un mini-projet de JEE créé par Ahmed Essoubai et Moubarak Najih
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>