<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="fr-fr">

    <head>
        <title>Login</title>
        <meta charset="UTF-8" />
        <link href="user.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <link href="css/main.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="js/myScript.js"></script>
    </head>
    <body>
        <div class="py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="">Create / Edit User page</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <form action="saveuser.do" method="POST">
                                <table class="table table-striped">
                                    <tbody>
                                        <tr>
                                            <th scope="col">user #</th>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty user}">NEW<input type="hidden" name="id" value="-1" /></c:when>
                                                    <c:otherwise>${user.personId}<input type="hidden" name="id" value="${user.personId}" /></c:otherwise>
                                                </c:choose> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="col">FirstName</th>
                                            <td><input type="text" class="form-control" name="FirstName" value="${user.personFirstname}" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col">LastName</th>
                                            <td><input type="text" class="form-control" name="LastName" value="${user.personLastname}" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Birthdate</th>
                                            <td><input type="date" class="form-control" name="Birthdate" value="<fmt:formatDate value="${user.personBirthdate}" pattern="yyyy-MM-dd"/>" /> </td>
                                        </tr>
                                    <tbody>
                                    <tfoot>
                                        <tr>
                                            <td scope="col" colspan="2" class="text-center"><button type="submit" class="btn btn-block btn-primary">Save</button></td>

                                        </tr>
                                    </tfoot>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${! empty user}">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 form-group">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">Date</th>
                                            <th scope="col">Title</th>
                                            <th scope="col">Return</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${user.borrowCollection}">
                                            <tr>
                                                <td scope="col" class="text-center">
                                                    <fmt:formatDate value="${item.borrowDate}" pattern="yyyy-MM-dd" />
                                                </td>
                                                <td>${item.bookId.bookTitle}</td>
                                                <td class="text-center">
                                                    <c:choose>
                                                        <c:when test="${! empty item.borrowReturn}">
                                                            <fmt:formatDate value="${item.borrowReturn}" pattern="yyyy-MM-dd" />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button class="btn" name="return" onclick="returnBorrow(this, ${ item.borrowId }); return false;">
                                                                <img src="img/return.png" alt="return" class="icon" />
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                    <tfoot>
                                    <form action="addborrow.do" method="POST">
                                        <tr>
                                            <td colspan="2">
                                                <input type="hidden" name="userID" value="${user.personId}" />
                                                <select name="bookID" class="form-control form-select form-select-lg mb-3">
                                                    <option value="-1" selected="selected">-</option>
                                                    <c:forEach var="book" items="${booksList}">
                                                        <option value="${book.bookId}"> ${book.bookTitle}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td class="text-center">
                                                <button class="btn"><img src="img/plus.png" alt="add" class="icon" /></button>
                                            </td>
                                        </tr>
                                    </form>
                                    </tfoot>
                                </table>

                            </div>
                    </div>
                </div>
            </div>
        </c:if>

    </div>

</body>

</html>