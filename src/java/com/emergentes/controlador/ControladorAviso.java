package com.emergentes.controlador;

import com.emergentes.dao.*;
import com.emergentes.modelo.*;
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
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@WebServlet(name = "ControladorAviso", urlPatterns = {"/ControladorAviso"})
@MultipartConfig(maxFileSize = 16177215)  // upload file's size up to 16MB
public class ControladorAviso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            

            HttpSession ses = request.getSession();
            String usuario = "";
            int id_cat_usuario = 0;
            String id_us = "";

            if (ses.getAttribute("usuario") != null && ses != null && ses.getAttribute("id_cat_usuario") != null) {
                usuario = ses.getAttribute("usuario").toString();
                id_cat_usuario = Integer.parseInt(ses.getAttribute("id_cat_usuario").toString());
                id_us = ses.getAttribute("id").toString();

            }
             

            PostsDAO dao = new PostsDAOimpl();
            CatAvisoDAO dao_cat_avi = new CatAvisoDAOimpl();
            UsuarioDAO dao_us = new UsuarioDAOimpl();

            int id;
            Posts post = new Posts();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            List<Usuario> lista_us;
            List<CatAviso> lista_cat_avi;
            switch (action) {
                case "add":

                    lista_cat_avi = dao_cat_avi.getAll();
                    lista_us = dao_us.getAll();
                    request.setAttribute("lista_cat_avi", lista_cat_avi);
                    request.setAttribute("lista_us", lista_us);
                    request.setAttribute("post", post);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);

                    break;
                case "edit":
                    lista_cat_avi = dao_cat_avi.getAll();
                    lista_us = dao_us.getAll();
                    request.setAttribute("lista_cat_avi", lista_cat_avi);
                    request.setAttribute("lista_us", lista_us);

                    id = Integer.parseInt(request.getParameter("id"));
                    post = dao.getById(id);

                    request.setAttribute("post", post);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/ControladorAviso");
                    break;
                case "view_misavisos":
                    lista_cat_avi = dao_cat_avi.getAll();
                    lista_us = dao_us.getAll();
                    request.setAttribute("lista_cat_avi", lista_cat_avi);
                    request.setAttribute("lista_us", lista_us);
                    
                    List<Posts> lista;

                    if (id_cat_usuario == 1) {
                    lista = dao.getAll();
                    } else {
                        lista = dao.getAll_IdUsuario(id_us);
                    }

                    request.setAttribute("post", lista);
                    request.getRequestDispatcher("MisPosts.jsp").forward(request, response);
                    break;

                case "view":
                    lista_cat_avi = dao_cat_avi.getAll();
                    lista_us = dao_us.getAll();
                    request.setAttribute("lista_cat_avi", lista_cat_avi);
                    request.setAttribute("lista_us", lista_us);

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
        String descripcion = request.getParameter("descripcion");
        Double precio = Double.parseDouble(request.getParameter("precio"));
        int nro_celular = Integer.parseInt(request.getParameter("nro_celular"));

        InputStream inputStream = null;
        Part filePart = request.getPart("archivoimg");
        if (filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();
        }

        int id_cat_aviso = Integer.parseInt(request.getParameter("id_cat_aviso"));
        String id_usuario =request.getParameter("id_usuario");

        Posts post = new Posts();

        post.setId(id);
        post.setFecha(fecha);
        post.setTitulo(titulo);
        post.setDescripcion(descripcion);
        post.setPrecio(precio);
        post.setNro_celular(nro_celular);
        post.setArchivoimg(inputStream);
        post.setId_cat_aviso(id_cat_aviso);
        post.setId_usuario(id_usuario);

        if (id == 0) {
            try {
                PostsDAO dao = new PostsDAOimpl();
                dao.insert(post);
                response.sendRedirect(request.getContextPath() + "/ControladorAviso");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                PostsDAO dao = new PostsDAOimpl();
                if (inputStream != null) {
                    dao.update(post);
                } else {
                    dao.update2(post);
                }
                response.sendRedirect(request.getContextPath() + "/ControladorAviso");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }

}
