package com.emergentes.controlador;

import com.emergentes.dao.PostsDAOimpl;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Posts;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.PostsDAO;

@WebServlet(name = "ControladorPosts", urlPatterns = {"/ControladorPosts"})
public class ControladorPosts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession ses = request.getSession();
            String usuario = "";
            int id_usuario = 0;

            if (ses.getAttribute("usuario") != null && ses != null && ses.getAttribute("id_usuario") != null) {
                usuario = ses.getAttribute("usuario").toString();
                id_usuario = Integer.parseInt(ses.getAttribute("id_usuario").toString());

            }

            PostsDAO dao = new PostsDAOimpl();
            UsuarioDAO dao_us = new UsuarioDAOimpl();

            int id;
            Posts post = new Posts();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            List<Usuarios> lista_us;
            switch (action) {
                case "add":
                    
                    lista_us= dao_us.getAll();
                    request.setAttribute("usu", lista_us);
                    request.setAttribute("post", post);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);

                    break;
                case "edit":
                    
                    lista_us= dao_us.getAll();
                    request.setAttribute("usu", lista_us);
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    post = dao.getById(id);
                    
                    request.setAttribute("post", post);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/ControladorPosts");
                    break;
                case "view_misposts":                    
                    lista_us= dao_us.getAll();
                    request.setAttribute("usu", lista_us);
                    
                    List<Posts> lista;

                    if (id_usuario == 1) {
                        lista = dao.getAll();
                    } else {
                        lista = dao.getAll_IdUsuario(id_usuario);
                    }

                    request.setAttribute("post", lista);
                    request.getRequestDispatcher("MisPosts.jsp").forward(request, response);
                    break;
                    
                 case "view":                    
                    lista_us= dao_us.getAll();
                    request.setAttribute("usu", lista_us);
                    
                    List<Posts> lista2;

                    lista2 = dao.getAll();
                    
                    request.setAttribute("post", lista2);
                    request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                    break;                   

            }

        } catch (Exception e) {
            System.out.println("Error en : " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

        Posts post = new Posts();

        post.setId(id);
        post.setFecha(fecha);
        post.setTitulo(titulo);
        post.setContenido(contenido);
        post.setId_usuario(id_usuario);

        if (id == 0) {
            try {
                PostsDAO dao = new PostsDAOimpl();
                dao.insert(post);
                response.sendRedirect(request.getContextPath() + "/ControladorPosts");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                PostsDAO dao = new PostsDAOimpl();
                dao.update(post);
                response.sendRedirect(request.getContextPath() + "/ControladorPosts");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }

}
