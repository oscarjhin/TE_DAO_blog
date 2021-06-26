<%@page import="com.emergentes.modelo.*"%>
<%@page import="com.emergentes.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
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
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <style type="text/css">
            .tamletra {
                border: 0;
                font-size: 36px;
                font-family: "Times New Roman", Times, serif;
                color: #000000;
            }
            .lateral {
                border: 0;
                font-size: 26px;
                font-family: "Times New Roman", Times, serif;
                color: #000000;
                background-color: #ffffcc;
                width: 15em; 
                height: 5em;
                resize: none;
            }
        </style>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp" />


    <center><FONT SIZE=25><strong>Blog de Ventas</strong></FONT></center>
    <h1><a href="ControladorAviso?action=add" class="btn"><img src="Imagenes/nuevo.png" title="Nuevo registro"/>Nuevo Aviso</a></h1>

    <c:forEach var="item" items="${post}">  
        <div class="datagrid"> 
            <table border="0" ALIGN="center">
                <thead>
                    <tr>
                        <th>Imagen</th>
                        <th>Datos del Aviso</th>
                    </tr>
                </thead>
                <tr>
                    <th>

                        <div>

                            <c:if test="${item.archivoimg2 != null}" >
                                <img src="VerImagenControlador?id=${item.id}" width="400" height="400" title="imagen"/>
                            </c:if>

                            <c:if test="${item.archivoimg2 == null}" >
                                No Disponible
                            </c:if>   
                        </div>           
                    </th>
                    <th>

                        <div >

                            <h1><p style="color:red;">${item.titulo}</p></h1>
                            <input name="fecha" type="date" required class="tamletra" value="${item.fecha}" readonly><br>

                            <div >
                                <h2><label style="color:blue;">Descripcion: </label></h2>
                                <table >

                                    <tr>
                                        <td><textarea disabled class="lateral">${item.descripcion}</textarea><br></td>
                                    </tr>

                                </table>
                            </div>

                            <h2><p style="color:black;"><label style="color:blue;">Precio: </label>${item.precio} Bs.</p></h2>
                            <h2><p style="color:black;"><label style="color:blue;">Nro. de Contacto: </label> ${item.nro_celular}</p></h2>

                            <h2><label style="color:blue;">Cat Aviso: </label>   
                                <c:forEach var="item2" items="${lista_cat_avi}">
                                    <c:if test="${item.id_cat_aviso == item2.id}">
                                        ${item2.descripcion} 
                                    </c:if>
                                </c:forEach>
                            </h2> 

                            <h2><label style="color:blue;">Autor: </label>   
                                <c:forEach var="item2" items="${lista_us}">
                                    <c:if test="${item.id_usuario == item2.ci}">
                                        ${item2.apellidos}${" "}${item2.nombres} 
                                    </c:if>
                                </c:forEach>
                            </h2>
                            <!--
                        <p align="right"><a  href="ControladorAviso?action=edit&id=${item.id}" ><FONT SIZE=5><img src="Imagenes/editar.png" title="Modificar"/>MODIFICAR </FONT></a> | 
                            <a href="ControladorAviso?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar??'))"><FONT SIZE=5><img src="Imagenes/delete.png" title="Eliminar"/> ELIMINAR</FONT></a> </p>  
                            -->
                        </div>

                    </th>
                </tr>
            </table>

        </div>

        <hr>
    </c:forEach>

</body>
</html>
