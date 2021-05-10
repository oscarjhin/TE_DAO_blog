<%@page import="com.emergentes.modelo.Posts"%>
<%@page import="com.emergentes.modelo.Usuarios"%>
<%@page import="com.emergentes.dao.UsuarioDAO"%>
<%@page import="com.emergentes.dao.UsuarioDAOimpl"%>
<%@page import="com.emergentes.dao.PostsDAO"%>
<%@page import="com.emergentes.dao.PostsDAOimpl"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%

    HttpSession ses = request.getSession();
    String usuario = "";
    int id_usuario = 0;

    if (ses.getAttribute("usuario") != null && ses != null && ses.getAttribute("id_usuario") != null) {
        usuario = ses.getAttribute("usuario").toString();
        id_usuario = Integer.parseInt(ses.getAttribute("id_usuario").toString());

        /*
    if(id_usuario!=1){
        response.sendRedirect("ControladorPosts");
    } 
         */
    } else {
        response.sendRedirect("login.jsp");
    }


%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validarPas() {
            var valor1 = document.getElementById("pas1").value;
            var valor2 = document.getElementById("pas2").value;
                
                if (valor1==valor2) {
                    //Si son iguales
                    alert("Las contraseñas son iguales \n Se Actualizo la contraseñas");
                } else if (valor1!=valor2) {
                    //Si no son iguales
                    alert("Las contraseñas no son iguales \n No se Actualizo la contraseñas");
                }
            }

        </script>
    </head>
    <body>
        <p align="right"><a href="ControladorPosts">INICIO</a> 
            <c:if test="${sessionScope.id_usuario == 1}">| 
                <a href="ControladorUsuario">Usuarios</a> </c:if> | 
                <a href="CambiarPas.jsp">Cambiar Password</a> | 
                <a href="ControladorPosts?action=view_misposts">Mis Posts</a> |
                &nbsp&nbsp<img src="Imagenes/usuario.png" width="30" height="30"> Usuario: <%= usuario%> |
            &nbsp&nbsp<img src="Imagenes/salir.png" width="30" height="30"><a href="login.jsp?cerrar=true"> Salir</a>
        </p>
        <hr>
        <h1>
            Cambiar Password  
        </h1>
        <form name="CambiarPas" action="ControladorUsuario" method="post" onsubmit="validarPas();">
            <input type="hidden" name="id" value="-1">
            <table width="311">       
                <tr>
                    <td>Nuevo Password</td>
                    <td ><input id="pas1" name="pas1" type="password" required></td>                   
                </tr>

                <tr>
                    <td>Repita Passwors</td>

                    <td ><input id="pas2" name="pas2" type="password" required></td>  

                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar" ></td>
                </tr>

            </table>
        </form>
        <p><a href="ControladorPosts">Volver</a></p>
    </body>
</html>
