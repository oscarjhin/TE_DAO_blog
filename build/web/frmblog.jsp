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
    
    /*
    if(!usuario.equals("admin")){
        response.sendRedirect("login.jsp");
    } 
    */
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
            <c:if test="${post.id == 0}">Nuevo </c:if>
            <c:if test="${post.id > 0}">Editar </c:if>
            Posts    
        </h1>
        <form action="ControladorPosts" method="post">
            <input type="hidden" name="id" value="${post.id}">
            <table width="311">
                <tr>
                    <td>Fecha</td>
                    <td ><input name="fecha" type="date" value="${post.fecha}" required></td>                   
                </tr>
                <tr>
                    <td>Titutlo</td>
                    <td ><input name="titulo" type="text" required value="${post.titulo}" size="80" required></td>                   
                </tr>

                <tr>
                    <td>Contenido</td>
                    <td>
                        <textarea name="contenido" rows="10" cols="60" required>${post.contenido}</textarea>
                    </td>   
                </tr>
                
                <tr>
                    <td>Usuario</td>
                    <td>
                    <c:if test="${sessionScope.id_usuario!=1}">
                    <input type="hidden" name="id_usuario" value="${sessionScope.id_usuario}">
                    </c:if>    
                        
                    <select name="id_usuario" 
                               <c:if test="${sessionScope.id_usuario!=1}">
                                   disabled
                                </c:if>
                    >
                        <c:forEach var="item" items="${usu}"> 
                            <option value= ${item.id}
                            <c:if test="${post.id == 0}">        
                                <c:if test="${item.id == sessionScope.id_usuario}">
                                    selected
                                </c:if>
                            </c:if>
                                    
                            <c:if test="${post.id > 0}">        
                                <c:if test="${post.id_usuario == item.id}">
                                    selected
                                </c:if>
                            </c:if>
                            >${item.usuario}</option>
                        </c:forEach>    
         
                        
                    </td>        
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>
        </form>
        <p><a href="ControladorPosts">Volver</a></p>
    </body>
</html>
