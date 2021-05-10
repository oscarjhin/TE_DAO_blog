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
        <title>JSP Page</title>
        <style type="text/css">
            .tamletra {
                border: 0;
                font-size: 36px;
                font-family: "Times New Roman", Times, serif;
                color: #000000;
            }
        </style>
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
    <center><FONT SIZE=25><strong>Blog de Salud</strong> </font></center>
    <h2><a href="ControladorPosts?action=add">Nueva Entrada</a></h2>
    <c:forEach var="item" items="${post}">  
        <div>
            <input name="fecha" type="date" required class="tamletra" value="${item.fecha}" readonly><br>
            <h1><p style="color:blue;">${item.titulo}</p></h1>
            <h2>${item.contenido}</h2><br>

            <h2><label style="color:blue;">Autor: </label>  
                <c:forEach var="item2" items="${usu}">
                    <c:if test="${item.id_usuario == item2.id}">
                        ${item2.usuario} 
                    </c:if>
                </c:forEach>
            </h2> 
            <p align="right"><a  href="ControladorPosts?action=edit&id=${item.id}" ><FONT SIZE=5>Editar</FONT></a> | <a href="ControladorPosts?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar??'))"><FONT SIZE=5>Eliminar</FONT></a> </p>          
        </div>
        <hr>
    </c:forEach>

</body>
</html>
