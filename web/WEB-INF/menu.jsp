<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>



        <p align="right"><FONT SIZE=7><strong>SIBLOVE&nbsp&nbsp&nbsp&nbsp</strong></FONT>
            <FONT SIZE=5><a href="ControladorAviso">INICIO</a> 
            <c:if test="${sessionScope.id_cat_usuario== 1}">| 
                <a href="ControladorUsuario">Usuarios</a> |
                <a href="ControladorCatUsuario">Cat. Usuarios</a> |
                <a href="ControladorCatAviso">Cat. Aviso</a> </c:if> | 
                <a href="CambiarPas.jsp">Cambiar Password</a> | 
                <a href="ControladorAviso?action=view_misavisos">Mis Avisos</a> |
                &nbsp&nbsp<img src="Imagenes/usuario.png" width="30" height="30"> Usuario: <%=usuario%> |
            &nbsp&nbsp<img src="Imagenes/salir.png" width="30" height="30"><a href="login.jsp?cerrar=true"> Salir</a>
            </FONT>
        </p>
     <hr>
     <!--
     <label>Usuario: <%=usuario%></label><br>
     <label>Id Us: <%=id%></label><br>
     <label>Id Cat Usu: <%=id_cat_usuario%></label><br>
     -->