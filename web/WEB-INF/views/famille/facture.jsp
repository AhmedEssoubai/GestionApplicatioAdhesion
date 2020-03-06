<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Facture</title>
</head>
<body>
    <%@ include file="/WEB-INF/fragments/navbar.jspf" %>
    <section class="py-5 text-left bg-light">
        <div class="container">
            <div class="row">
                <div class="container px-0">
                    <div class="row d-flex justify-content-between">
                        <h2 class="col text">Facture</h2>
                        <a href="Export?num=${requestScope.num_adhesion}" class="btn btn-primary">PDF</a>
                    </div>
                    <div class="row bg-white shadow-sm p-4 mt-4">
                        <table class="col-12 table table-hover ">
                            <thead>
                              <tr>
                                <th scope="col">Label</th>
                                <th scope="col">Prix</th>
                              </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${requestScope.items }">
                                <tr>
                                  <td>${item.label}</td>
                                  <th scope="row">${item.prix}DH</th>
                                </tr>
                            </c:forEach>
                                <tr>
                                  <td>Total</td>
                                  <th scope="row">${requestScope.total}DH</th>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>