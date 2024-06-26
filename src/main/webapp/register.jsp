<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Cadastrar Usu�rio - Gerenciador de Projetos</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
</head>

<body class="bg-gradient-primary">
    <div class="container">
        <div class="card shadow-lg o-hidden border-0 my-5">
            <div class="card-body p-0">
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-flex">
                        <div class="flex-grow-1 bg-register-image" style="background-image: url(&quot;assets/img/background/image2.jpeg&quot;);"></div>
                    </div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h4 class="text-dark mb-4">Criar nova conta!</h4>
                            </div>
                            <form action="CadastrarUsuarioServlet" method="post">
                                <div class="row mb-3">
                                    <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" id="nome" placeholder="Nome" name="nome"></div>
                                    <div class="col-sm-6"><input class="form-control form-control-user" type="text" id="sobrenome" placeholder="Sobrenome" name="sobrenome"></div>
                                </div>
                                <div class="mb-3"><input class="form-control form-control-user" type="email" id="email" aria-describedby="email" placeholder="Email" name="email"></div>
                                <div class="row mb-3">
                                    <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="password" id="senha" placeholder="Senha" name="senha"></div>
                                    <div class="col-sm-6"><input class="form-control form-control-user" type="password" id="confirmar-senha" placeholder="Confirmar Senha" name="confirmar-senha"></div>
                                </div><button class="btn btn-primary d-block btn-user w-100" type="submit">Criar conta</button>
                                <hr>
                            </form>
                            <div class="text-center"><a class="small" href="forgot-password.jsp">Esqueceu a senha?</a></div>
                            <div class="text-center"><a class="small" href="login.jsp">J� � cadastrado? Entre com sua conta!</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>