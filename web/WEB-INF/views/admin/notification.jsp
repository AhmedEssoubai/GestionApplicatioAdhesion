<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notification</title>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
    <section class="py-5 text-left bg-light">
        <div class="container">
            <div class="row">
                <div class="container px-0">
                    <div class="row">
                        <h2 class="col text">Envoyer un message aux membres du club</h2>
                    </div>
                    <div class="row mt-4">
                        <form class="col" action="Notification" method="POST">
                            <div class="form-group my-3">
                                <input class="form-control" type="text" name="sujet" placeholder="Sujet"/>
                            </div>
                            <div class="form-group my-3">
                                <textarea class="form-control" name="message" rows="5" placeholder="Message"></textarea>
                            </div>
                            <button type="submit mt-4" class="btn btn-primary">Envoyer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>