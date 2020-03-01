<%@ page language="java"%>
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
                    <h1 class="display-2 mt-5 pt-5">
                        Partager avec nous! 
                    </h1>
                    <p class="lead">
                        avec Bisd Community vous pouvez partager tous ce que vous voulez avec les autres.
                    </p>
                    <div class="mt-5">
                        <a href="Inscrire" class="btn btn-sec btn-lg px-5 rounded-pill">
                            S'inscrire
                        </a>
                    </div>
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
                            Bisd Community
                        </h1>
                        <p class="lead pb-3">
                            Bisd Community est un site de partage pour les étudiants afin de partager des cours, des exercices, poser des questions ; pour partager les connaissences.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>