<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="fr-fr">

    <head>
        <title>book</title>
        <meta charset="UTF-8" />
        <link href="book.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>Edit / Create Book page</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <form action="savebook.do" method="POST">
                                <table class="table table-striped">
                                    <tbody>
                                        <tr>
                                            <th scope="col">book #</th>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty book}">NEW<input type="hidden" name="id" value="-1" /></c:when>
                                                    <c:otherwise>${book.bookId}<input type="hidden" name="id" value="${book.bookId}" /></c:otherwise>
                                                </c:choose> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Title</th>
                                            <td><input type="text" name="title" value="${book.bookTitle}" placeholder="Title" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Authors</th>
                                            <td><input type="text" name="authors" value="${book.bookAuthors}" placeholder="Authors" /></td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td scope="col" colspan="2" class="text-center"><button type="submit"
                                                                                                    class="btn btn-block btn-primary">Save</button></td>

                                        </tr>
                                    </tfoot>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>