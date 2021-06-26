<%@page import="com.emergentes.modelo.*"%>
<%@page import="com.emergentes.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <title>Registrar Usuario</title>
    </head>

    <script>
        function texto()
        {
            var texto = document.getElementById("ci").value;
            document.getElementById("usuario").value = "usu_" + texto;
            document.getElementById("contrasena").value = texto + "_aviso";

        }
    </script>
    <body>
  
        <h1> Registrar Usuario</h1>

        <form action="ControladorUsuario" method="post">
            <input type="hidden" name="ci_ant" value="${objeto.ci}">
            <div class="datagrid">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Campo</th>
                        </tr>
                    </thead>
                    <tr class="alt">
                        <td>CI</td>
                        <td ><input id="ci" name="ci" type="text" value="" required onchange="texto()"></td>                   
                    </tr>                

                    <tr>
                        <td>Apellidos</td>
                        <td ><input name="apellidos" type="text" value="" required></td>                   
                    </tr>

                    <tr class="alt">
                        <td>Nombre</td>
                        <td ><input name="nombres" type="text" value="" required></td>                   
                    </tr> 

                    <tr>
                        <td>Email</td>
                        <td ><input name="email" type="email" value="" required></td>                   
                    </tr> 

                    <tr class="alt">
                        <td>Usuario</td>
                        <td ><input id="usuario" name="usuario" type="text" value="" required readonly="readonly"></td>                   
                    </tr>

                    <tr>
                        <td>Contrasena</td>

                        <td ><input id="contrasena" name="contrasena" type="text" value="" required></td>  

                    </tr>

                    <tr>
                        <td></td>
                        <td><input type="submit" value="enviar" class="btn"></td>
                    </tr>

                </table>
                <input type="hidden" name="id_cat_usuario" value="2">
            </div>
        </form>
        <p><a href="login.jsp" class="btn">Volver</a></p>
    </body>
</html>
