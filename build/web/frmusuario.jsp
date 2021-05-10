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
        <h1>
            <c:if test="${aviso.id == 0}">Nuevo </c:if>
            <c:if test="${aviso.id > 0}">Editar </c:if>
            Usuario    
        </h1>
        <form action="ControladorUsuario" method="post">
            <input type="hidden" name="id" value="${aviso.id}">
            <table width="311">       
                <tr>
                    <td>Usuario</td>
                    <td ><input name="usuario" type="text" value="${aviso.usuario}" required></td>                   
                </tr>

                <tr>
                    <td>Password</td>

                    <td ><input name="password" type="password" value="${aviso.password}" required></td>  
 
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>
        </form>
        <p><a href="ControladorUsuario">Volver</a></p>
    </body>
</html>
