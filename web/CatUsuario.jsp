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
    <body>

        <jsp:include page="WEB-INF/menu.jsp" />

        <h1>LISTADO DE CATEGORIA USUARIOS</h1>
        <p><a href="ControladorCatUsuario?action=add" class="btn"><img src="Imagenes/nuevo.png" title="Nuevo registro"/>Nuevo</a></p>
        <div class="datagrid"> 
            <table border="1">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Descripcion</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${list_obj}">        
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.descripcion}</td>
                        <th><a href="ControladorCatUsuario?action=edit&id=${item.id}"><img src="Imagenes/editar.png" title="Modificar"/></a></th>
                        <td><a href="ControladorCatUsuario?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar??'))"><img src="Imagenes/delete.png" title="Eliminar"/></a></td>
                    </tr>
                </c:forEach>
            </table>
            </div>
    </body>
</html>
