<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Usuarios"%>
<%@page import="com.emergentes.modelo.Usuarios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><br><br><br><br><br><br><br>
        <table border="3">
            <thead>
                <tr>
                    <th>

                        <h1>
                            LOGIN   
                        </h1>
                        <form action="ControladorLogin" method="post">
                            <table>
                                <tr>
                                    <td>Usuario</td>
                                    <td ><input name="usuario" type="text" placeholder="Usuario.." required autofocus></td>                   
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td ><input name="password" type="password" placeholder="Password.." required></td>                   
                                </tr>


                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Iniciar Sesion" name="btnIniciar"></td>
                                </tr>

                            </table>
                        </form>                           


                    </th>
                </tr>
            </thead>
        </table>




        <%
            HttpSession sesion = request.getSession();

            List<Usuarios> datos = new ArrayList<Usuarios>();
            if (request.getAttribute("fail") != null) {
                out.print("<script>alert('Ususario o Passwrod erroneos!!!');</script>   ");
            }
            if (request.getAttribute("datos") != null) {
                datos = (List<Usuarios>) request.getAttribute("datos");
                int id = 0;
                String usuario = "";
                String password = "";

                for (Usuarios u : datos) {
                    id = u.getId();
                    usuario = u.getUsuario();
                    password = u.getPassword();
                }
                sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("id_usuario", id);
                response.sendRedirect("ControladorPosts");
            }
            if (request.getParameter("cerrar") != null) {
                sesion.invalidate();
                response.sendRedirect("login.jsp");
            }

        %>
    </center>
</body>
</html>
