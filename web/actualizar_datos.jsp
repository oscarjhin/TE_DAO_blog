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
        <jsp:include page="WEB-INF/menu.jsp" />

        <h1>Actualizar Datos</h1>

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
                        <td ><input id="ci" name="ci" type="text" value="${objeto.ci}" required onchange="texto()"></td>                   
                    </tr>                

                    <tr>
                        <td>Apellidos</td>
                        <td ><input name="apellidos" type="text" value="${objeto.apellidos}" required></td>                   
                    </tr>

                    <tr class="alt">
                        <td>Nombre</td>
                        <td ><input name="nombres" type="text" value="${objeto.nombres}" required></td>                   
                    </tr> 

                    <tr>
                        <td>Email</td>
                        <td ><input name="email" type="email" value="${objeto.email}" required></td>                   
                    </tr> 

                    <tr class="alt">
                        <td>Usuario</td>
                        <td ><input id="usuario" name="usuario" type="text" value="${objeto.usuario}" required readonly="readonly"></td>                   
                    </tr>

                    <tr>
                        <td>Contrasena</td>

                        <td ><input id="contrasena" name="contrasena" type="text" value="${objeto.contrasena}" required></td>  

                    </tr>

                    <tr class="alt">

                        <td>Cat Usuario</td>
                        <td ><input name="id_cat_usuario" type="text" value="${sessionScope.id_cat_usuario}" required></td>



                    </tr>

                    <tr>
                        <td></td>
                        <td><input type="submit" value="enviar" class="btn"></td>
                    </tr>

                </table>
            </div>
        </form>
        <p><a href="ControladorUsuario" class="btn">Volver</a></p>
    </body>
</html>
