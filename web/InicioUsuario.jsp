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
String usuario="";
int id_usuario=0;

if(ses.getAttribute("usuario")!=null && ses !=null && ses.getAttribute("id_usuario")!=null){
    usuario = ses.getAttribute("usuario").toString();
    id_usuario = Integer.parseInt(ses.getAttribute("id_usuario").toString()); 
    
    
    if(id_usuario!=1){
        response.sendRedirect("ControladorPosts");
    } 
    
}else{
    response.sendRedirect("login.jsp");
}


%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        
        <h1>LISTADO DE USUARIO</h1>
        <p><a href="ControladorUsuario?action=add">Nuevo</a></p>
        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Usuario</th>
                <th>Password</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${avisos}">        
            <tr>
                <td>${item.id}</td>
                <td>${item.usuario}</td>
                <td>${item.password}</td>
                <th><a href="ControladorUsuario?action=edit&id=${item.id}">Editar</a></th>
                <td><a href="ControladorUsuario?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
