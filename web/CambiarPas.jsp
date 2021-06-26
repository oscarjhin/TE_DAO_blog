<%@page import="com.emergentes.modelo.*"%>
<%@page import="com.emergentes.dao.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%

    HttpSession ses = request.getSession();
    String usuario = "";
    String id = "";
    int id_cat_usuario = 0;

    if (ses.getAttribute("usuario") != null && ses != null && ses.getAttribute("id") != null) {
        usuario = ses.getAttribute("usuario").toString();
        id = ses.getAttribute("id").toString();
        id_cat_usuario = Integer.parseInt(ses.getAttribute("id_cat_usuario").toString());

        /*
    if(!usuario.equals("admin")){
        response.sendRedirect("login.jsp");
    } 
         */
    } else {
        response.sendRedirect("login.jsp");
    }


%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <title>JSP Page</title>
        <script>
            function validarPas() {
                var valor1 = document.getElementById("pas1").value;
                var valor2 = document.getElementById("pas2").value;

                if (valor1 == valor2) {
                    //Si son iguales
                    alert("Las contraseñas son iguales \n Se Actualizo la contraseñas");
                } else if (valor1 != valor2) {
                    //Si no son iguales
                    alert("Las contraseñas no son iguales \n No se Actualizo la contraseñas");
                }
            }

        </script>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp" />
        <h1>    
            Cambiar Password  
        </h1>
        <form name="CambiarPas" action="CambiarPasControlador" method="post" onsubmit="validarPas();">
            <input type="hidden" name="id" value="${sessionScope.id}">
            <div class="datagrid">
                <table width="311">       
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Campo</th>
                        </tr>
                    </thead>
                    <tr class="alt">
                        <td>Nuevo Password</td>
                        <td ><input id="pas1" name="pas1" type="password" required></td>                   
                    </tr>

                    <tr>
                        <td>Repita Passwors</td>

                        <td ><input id="pas2" name="pas2" type="password" required></td>  

                    </tr>
                    <tr class="alt">
                        <td></td>
                        <td><input type="submit" value="enviar" class="btn" ></td>
                    </tr>

                </table>
            </div>
        </form>
        <p><a href="ControladorAviso" class="btn">Volver</a></p>
    </body>
</html>
