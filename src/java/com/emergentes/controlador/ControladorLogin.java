package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAOimpl;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import com.emergentes.dao.UsuarioDAO;

@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String usuario = "";
            String contra = "";
            UsuarioDAO dao = new UsuarioDAOimpl();
            List<Usuarios> datos = new ArrayList<Usuarios>();

            if (request.getParameter("btnIniciar") != null) {
                try {
                    usuario = request.getParameter("usuario");
                    contra = request.getParameter("password");
                    datos = dao.verifica_usuario2(usuario, contra);
                    if (datos.size() > 0) {
                        request.setAttribute("datos", datos);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        request.setAttribute("fail", "No hay acceso!");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        

    }

}
