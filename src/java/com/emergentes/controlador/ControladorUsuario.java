package com.emergentes.controlador;

import com.emergentes.dao.*;
import com.emergentes.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            UsuarioDAO dao = new UsuarioDAOimpl();
            CatUsuarioDAO dao_catus = new CatUsuarioDAOimpl();

            String id;
            Usuario obj = new Usuario();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            List<CatUsuario> lista_catus;
            switch (action) {
                case "add":
                    lista_catus = dao_catus.getAll();
                    request.setAttribute("catus", lista_catus);

                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "edit":

                    lista_catus = dao_catus.getAll();
                    request.setAttribute("catus", lista_catus);

                    id = request.getParameter("id");
                    obj = dao.getById(id);
                    System.out.println(obj);
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = request.getParameter("id");
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/ControladorUsuario");
                    break;
                case "view":

                    lista_catus = dao_catus.getAll();
                    request.setAttribute("catus", lista_catus);

                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("lista_obj", lista);
                    request.getRequestDispatcher("Usuario.jsp").forward(request, response);
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error Get " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
            HttpSession ses = request.getSession();
            String usuario2 = "";
            String id_usuario = "0";
            
            if (ses.getAttribute("usuario") != null && ses != null && ses.getAttribute("id_usuario") != null) {
            usuario2 = ses.getAttribute("usuario").toString();
            id_usuario =ses.getAttribute("id_usuario").toString();
            
            }
         */
        String id = request.getParameter("ci");
        String id_ant = request.getParameter("ci_ant");
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String email = request.getParameter("email");
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        int id_cat_usuario = Integer.parseInt(request.getParameter("id_cat_usuario"));

        Usuario obj = new Usuario();
        obj.setCi(id);
        obj.setCi_ant(id_ant);
        obj.setApellidos(apellidos);
        obj.setNombres(nombres);
        obj.setEmail(email);
        obj.setUsuario(usuario);
        obj.setContrasena(contrasena);
        obj.setId_cat_usuario(id_cat_usuario);

        obj.toString();
        /*
        if (id.equals("-1")) {
            String pas1 = request.getParameter("pas1");
            String pas2 = request.getParameter("pas2");
            if (pas1.equals(pas2)) {
                try {
                    UsuarioDAO dao3 = new UsuarioDAOimpl();
                    dao3.update_pas(id, pas2);
                    response.sendRedirect(request.getContextPath() + "/CambiarPas.jsp");

                } catch (Exception e) {
                    System.out.println("Error cambiar Password" + e.getMessage());
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/CambiarPas.jsp");
            }

        }
         */

        UsuarioDAO dao1 = new UsuarioDAOimpl();

        try {
            if (dao1.getByIdExist(id_ant) == false) {
                try {
                    UsuarioDAO dao = new UsuarioDAOimpl();
                    dao.insert(obj);
                    response.sendRedirect(request.getContextPath() + "/ControladorUsuario");

                } catch (Exception e) {
                    System.out.println("Error insertar " + e.getMessage());
                }
            } else {
                try {
                    UsuarioDAO dao = new UsuarioDAOimpl();
                    dao.update(obj);
                    response.sendRedirect(request.getContextPath() + "/ControladorUsuario");

                } catch (Exception e) {
                    System.out.println("Error actualizar " + e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar existente " + ex.getMessage());
        }

    }

}
