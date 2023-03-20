<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="fr-fr">

<head>
    <title>Login page</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script type = "text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body>
    <div class="py-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="">Library Login</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="c_form-h" action="login.do" method="post">
                        <div class="form-group row">
                            <div class="col-2">
                                 <label for="inputlogin" class="form-label">login</label>
                                </div>
                            <div class="col-10">
                                <input type="text" class="form-control" id="inputlogin" name="myLogin" value=""
                                    placeholder="login" required="required" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-2">
                            <label for="inputpassword" class="form-label">password</label>
                        </div>
                            <div class="col-10">
                                <p>
                                    <input type="password" class="form-control" id="inputpassword" name="myPasswd" value="" placeholder="password" required="required"/>
                                </p>
                                <p><button type="submit" class = "btn btn-success">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
