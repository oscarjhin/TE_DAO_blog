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
        <style>
            textarea {
                resize: none;
            }

        </style>
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
        function validateFileType() {
            var fileName = document.getElementById("btn_file").value;
            var idxDot = fileName.lastIndexOf(".") + 1;
            var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
            if (extFile == "jpg" || extFile == "jpeg" || extFile == "png") {
                //TO DO
            } else {
                alert("¡Solo se permiten archivos jpg / jpeg y png!");
                document.getElementById("btn_file").value = "";
            }
        }
    </script>

    <body>
        <jsp:include page="WEB-INF/menu.jsp" />

        <h1>
            <c:if test="${post.id == 0}">Nuevo </c:if>
            <c:if test="${post.id > 0}">Editar </c:if>
                Aviso    
            </h1>
            <form action="ControladorAviso" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${post.id}">
            <div class="datagrid"> 
                <table >
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Campo</th>
                        </tr>
                    </thead>
                    <tr class="alt">
                        <td>Fecha</td>
                        <td ><input name="fecha" type="date" value="${post.fecha}" required></td>                   
                    </tr>
                    <tr>
                        <td>Titutlo</td>
                        <td ><input name="titulo" type="text" required value="${post.titulo}" size="80" required></td>                   
                    </tr>

                    <tr class="alt">
                        <td>Descripcion</td>
                        <td>
                            <textarea name="descripcion" rows="10" cols="80" >${post.descripcion}</textarea>
                        </td>   
                    </tr>

                    <tr>
                        <td>Precio</td>
                        <td ><input name="precio" type="text" required value="${post.precio}" size="80" required>  Bs.</td>                   
                    </tr>

                    <tr class="alt">
                        <td>Nro. Celular</td>
                        <td ><input name="nro_celular" type="text" required value="${post.nro_celular}" size="80" required></td>                   
                    </tr>                


                    <tr>
                        <td>
                            Imagen <br>
                            <c:if test="${post.id > 0}"><a href="VerImagenControlador?id=${post.id}" target="_blank"> Ver Imagen</a></c:if>
                            </td>
                            <td>
                                <input name="archivoimg" type="file" id="btn_file" onchange="validateFileType()" class="btn">
                            </td>   
                        </tr>

                        <tr class="alt">

                            <td>Cod. Usuario</td>


                            <td>
                            <c:if test="${sessionScope.id_cat_usuario!= 1}">
                                <input name="id_usuario" type="text" required value="${sessionScope.id}" required readonly>
                            </c:if>

                            <c:if test="${sessionScope.id_cat_usuario == 1}">

                                <select name="id_usuario" class="btn">
                                    <c:forEach var="item" items="${lista_us}"> 
                                        <option value= ${item.ci}    
                                                <c:if test="${post.id_usuario == item.ci}">
                                                    selected
                                                </c:if>
                                                >${"Usuario: "}${item.usuario}${" Nombre: "}${item.apellidos}${" "}${item.nombres}</option>
                                    </c:forEach>
                                </select>        

                            </c:if>

                        </td> 
                    </tr>


                    <tr>
                        <td>Cat. Aviso</td>
                        <td>
                            <select name="id_cat_aviso" class="btn">
                                <c:forEach var="item" items="${lista_cat_avi}"> 
                                    <option value= ${item.id}    
                                            <c:if test="${post.id_cat_aviso == item.id}">
                                                selected
                                            </c:if>
                                            >${item.descripcion}</option>
                                </c:forEach>
                            </select>        

                        </td>


                    </tr>


                    <tr class="alt">
                        <td></td>
                        <td><input type="submit" value="enviar" class="btn"></td>
                    </tr>

                </table>
            </div>
        </form>
        <p><a href="ControladorAviso" class="btn">Volver</a></p>
    </body>
</html>
