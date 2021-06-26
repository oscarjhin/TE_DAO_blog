package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.emergentes.modelo.Posts;
import com.emergentes.modelo.Usuario;
import com.emergentes.dao.*;


public final class CambiarPas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <script>\r\n");
      out.write("            function validarPas() {\r\n");
      out.write("            var valor1 = document.getElementById(\"pas1\").value;\r\n");
      out.write("            var valor2 = document.getElementById(\"pas2\").value;\r\n");
      out.write("                \r\n");
      out.write("                if (valor1==valor2) {\r\n");
      out.write("                    //Si son iguales\r\n");
      out.write("                    alert(\"Las contraseñas son iguales \\n Se Actualizo la contraseñas\");\r\n");
      out.write("                } else if (valor1!=valor2) {\r\n");
      out.write("                    //Si no son iguales\r\n");
      out.write("                    alert(\"Las contraseñas no son iguales \\n No se Actualizo la contraseñas\");\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/menu.jsp", out, false);
      out.write("\r\n");
      out.write("        <h1>    \r\n");
      out.write("            Cambiar Password  \r\n");
      out.write("        </h1>\r\n");
      out.write("        <form name=\"CambiarPas\" action=\"ControladorUsuario\" method=\"post\" onsubmit=\"validarPas();\">\r\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"-1\">\r\n");
      out.write("            <table width=\"311\">       \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Nuevo Password</td>\r\n");
      out.write("                    <td ><input id=\"pas1\" name=\"pas1\" type=\"password\" required></td>                   \r\n");
      out.write("                </tr>\r\n");
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Repita Passwors</td>\r\n");
      out.write("\r\n");
      out.write("                    <td ><input id=\"pas2\" name=\"pas2\" type=\"password\" required></td>  \r\n");
      out.write("\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                    <td><input type=\"submit\" value=\"enviar\" ></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("        <p><a href=\"ControladorPosts\">Volver</a></p>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
