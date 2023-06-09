<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="fr-fr">

    <head>
        <title>books</title>
        <meta charset="UTF-8" />
        <link href="books.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <link href="css/main.css" type="text/css" rel="stylesheet" />

    </head>

    <body>
        <%@ include file="navbar.jspf" %>
        <div class="py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="">List of books</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col" class="text-center">book #</th>
                                        <th scope="col" class="text-center">Title</th>
                                        <th scope="col" class="text-center">Authors</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${booksList}">
                                        <tr>
                                            <td scope="col">${item.bookId}</td>
                                            <td>${item.bookTitle}</td>
                                            <td>${item.bookAuthors}</td>

                                            <td class="text-center">
                                                <form action="editUser" method="POST">
                                                    <input type="hidden" name="id" value="${item.bookId}">
                                                    <button name="edit" class="btn btn-sm " formaction="editbook.do"><img src="img/edit.png" alt="edit"
                                                                                                                          class="icon" /></button>
                                                    <button name="delete" class="btn btn-sm " formaction="deletebook.do"><img src="img/delete.png" alt="delete"
                                                                                                                              class="icon" /></button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                                <tfoot>
                                    <tr id="addNew">
                                        <td scope="col" colspan="3"></td>
                                        <td class="text-center">
                                            <form action="createbook.do" method="POST">
                                                <button class="btn"><img src="img/plus.png" alt="add"
                                                                         class="icon" /></button>
                                            </form></td>
                                    </tr>
                                </tfoot>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>