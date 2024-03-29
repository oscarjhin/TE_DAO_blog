package com.emergentes.controlador;

import com.emergentes.dao.CatAvisoDAO;
import com.emergentes.dao.CatAvisoDAOimpl;
import com.emergentes.modelo.CatAviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorCatAviso", urlPatterns = {"/ControladorCatAviso"})
public class ControladorCatAviso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            CatAvisoDAO dao = new CatAvisoDAOimpl();
            int id;
            CatAviso obj = new CatAviso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {

                case "add":
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("frmcataviso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    obj = dao.getById(id);
                    System.out.println(obj);
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("frmcataviso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/ControladorCatAviso");
                    break;

                case "view":
                    List<CatAviso> lista = dao.getAll();
                    request.setAttribute("list_obj", lista);
                    request.getRequestDispatcher("CatAviso.jsp").forward(request, response);
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");

        CatAviso obj = new CatAviso();

        obj.setId(id);
        obj.setDescripcion(descripcion);

        if (id == 0) {
            try {
                CatAvisoDAO dao = new CatAvisoDAOimpl();
                dao.insert(obj);
                response.sendRedirect(request.getContextPath() + "/ControladorCatAviso");

            } catch (Exception e) {
                System.out.println("Error al insertar " + e.getMessage());
            }
        } else {
            try {
                CatAvisoDAO dao = new CatAvisoDAOimpl();
                dao.update(obj);
                response.sendRedirect(request.getContextPath() + "/ControladorCatAviso");

            } catch (Exception e) {
                System.out.println("Error actualizar" + e.getMessage());
            }
        }
    }

}
