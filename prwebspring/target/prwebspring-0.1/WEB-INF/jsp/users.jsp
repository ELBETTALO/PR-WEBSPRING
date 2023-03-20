<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="fr-fr">

    <head>
        <title>users</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link href="css/users.css" type="text/css" rel="stylesheet" />
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
                        <h2 class="">List of users</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped ">
                                <thead>
                                    <tr>
                                        <th scope="col" class="text-center">user #</th>
                                        <th scope="col" class="text-center">FirstName</th>
                                        <th scope="col" class="text-center">LastName</th>
                                        <th scope="col" class="text-center">Birthdate</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${usersList}">
                                        <tr>
                                            <td scope="col">${item.personId}</td>
                                            <td>${item.personFirstname}</td>
                                            <td>${item.personLastname}</td>
                                            <td><fmt:formatDate value="${item.personBirthdate}" pattern="yyyy-MM-dd" /></td>

                                            <td class="text-center">
                                                <form action="editUser" method="POST">
                                                    <input type="hidden" name="id" value="${item.personId}">
                                                    <button name="edit" class="btn btn-sm " formaction="edituser.do"><img src="img/edit.png" alt="edit"
                                                                                                                          class="icon" /></button>
                                                    <button name="delete" class="btn btn-sm " formaction="deleteuser.do"><img src="img/delete.png" alt="delete"
                                                                                                                              class="icon" /></button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr id="addNew">
                                        <td scope="col" colspan="4"></td>
                                        <td class="text-center">
                                            <form action="createuser.do" method="POST">
                                                <button class="btn"><img src="img/plus.png" alt="add" class="icon" /></button>
                                            </form>
                                        </td>
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