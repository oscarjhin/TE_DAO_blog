<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" REL=StyleSheet >

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }

            html,
            body {
                height: 100%;
            }

            body {
                display: flex;
                align-items: center;
                padding-top: 40px;
                padding-bottom: 40px;
                background-color: #f5f5f5;
            }

            .form-signin {
                width: 100%;
                max-width: 330px;
                padding: 15px;
                margin: auto;
            }

            .form-signin .checkbox {
                font-weight: 400;
            }

            .form-signin .form-floating:focus-within {
                z-index: 2;
            }

            .form-signin input[type="email"] {
                margin-bottom: -1px;
                border-bottom-right-radius: 0;
                border-bottom-left-radius: 0;
            }

            .form-signin input[type="password"] {
                margin-bottom: 10px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
        </style>


        <!-- Custom styles for this template -->

    </head>
    <body class="text-center">

        <main class="form-signin">
            <form action="ControladorLogin" method="post">
                <img src="Imagenes/LogoIS2.png"  alt="" width="91" height="98" class="mb-4">
                <h1 class="h3 mb-3 fw-normal">SIBLOVE Login</h1>

                <div class="form-floating">
                    <input type="text" name="usuario" class="form-control" id="floatingInput" placeholder="usu_654321" required="">
                    <label for="floatingInput">Usuario</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="contrasena" class="form-control" id="floatingPassword" placeholder="Password" required="">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Recuerdame
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit"name="btnIniciar">Ingresar</button>
                <div >
                    <h2><a href="registrar_usuario.jsp" >Registrese</a></h2>
                </div>
                <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
            </form>
        </main>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>





        <%
            HttpSession sesion = request.getSession();

            List<Usuario> datos = new ArrayList<Usuario>();
            if (request.getAttribute("fail") != null) {
                out.print("<script>alert('Ususario o Password erroneos!!!');</script>   ");
            }
            if (request.getAttribute("datos") != null) {
                datos = (List<Usuario>) request.getAttribute("datos");
                String id = "";
                String usuario = "";
                String password = "";
                int id_cat_usuario = 0;

                for (Usuario u : datos) {
                    id = u.getCi();
                    usuario = u.getUsuario();
                    password = u.getContrasena();
                    id_cat_usuario = u.getId_cat_usuario();
                }
                sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("id", id);
                sesion.setAttribute("id_cat_usuario", id_cat_usuario);
                response.sendRedirect("ControladorAviso");
            }
            if (request.getParameter("cerrar") != null) {
                sesion.invalidate();
                response.sendRedirect("login.jsp");
            }

        %>

    </body>
</html>
