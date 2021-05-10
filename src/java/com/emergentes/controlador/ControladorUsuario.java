
package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
            int id;
            Usuarios avi = new Usuarios();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/ControladorUsuario");
                    break;
                case "view":
                    List<Usuarios> lista = dao.getAll();
                    request.setAttribute("avisos", lista);
                    request.getRequestDispatcher("InicioUsuario.jsp").forward(request, response);
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        String usuario2 = "";
        int id_usuario = 0;

        if (ses.getAttribute("usuario") != null && ses != null && ses.getAttribute("id_usuario") != null) {
            usuario2 = ses.getAttribute("usuario").toString();
            id_usuario = Integer.parseInt(ses.getAttribute("id_usuario").toString());

        }
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        Usuarios avi = new Usuarios();

        avi.setId(id);
        avi.setUsuario(usuario);
        avi.setPassword(password);
        if (id == -1) {
            String pas1 = request.getParameter("pas1");
            String pas2 = request.getParameter("pas2");
            if(pas1.equals(pas2))
            {
                try {
                    UsuarioDAO dao = new UsuarioDAOimpl();
                    dao.update_pas(id_usuario, pas2);
                    response.sendRedirect(request.getContextPath() + "/CambiarPas.jsp");

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }        
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/CambiarPas.jsp");
            }

        }

        if (id == 0) {
            try {
                UsuarioDAO dao = new UsuarioDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath() + "/ControladorUsuario");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                UsuarioDAO dao = new UsuarioDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath() + "/ControladorUsuario");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }       
    }



}
