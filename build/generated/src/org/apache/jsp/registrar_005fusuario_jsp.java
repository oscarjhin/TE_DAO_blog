package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.emergentes.modelo.*;
import com.emergentes.dao.*;

public final class registrar_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"screen\"/>\r\n");
      out.write("        <title>Registrar Usuario</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function texto()\r\n");
      out.write("        {\r\n");
      out.write("            var texto = document.getElementById(\"ci\").value;\r\n");
      out.write("            document.getElementById(\"usuario\").value = \"usu_\" + texto;\r\n");
      out.write("            document.getElementById(\"contrasena\").value = texto + \"_aviso\";\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/menu.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h1> Registrar Usuario</h1>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"ControladorUsuario\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"ci_ant\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objeto.ci}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("            <div class=\"datagrid\">\r\n");
      out.write("                <table>\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>Nombre</th>\r\n");
      out.write("                            <th>Campo</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tr class=\"alt\">\r\n");
      out.write("                        <td>CI</td>\r\n");
      out.write("                        <td ><input id=\"ci\" name=\"ci\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objeto.ci}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required onchange=\"texto()\"></td>                   \r\n");
      out.write("                    </tr>                \r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Apellidos</td>\r\n");
      out.write("                        <td ><input name=\"apellidos\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objeto.apellidos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required></td>                   \r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr class=\"alt\">\r\n");
      out.write("                        <td>Nombre</td>\r\n");
      out.write("                        <td ><input name=\"nombres\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objeto.nombres}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required></td>                   \r\n");
      out.write("                    </tr> \r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Email</td>\r\n");
      out.write("                        <td ><input name=\"email\" type=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objeto.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required></td>                   \r\n");
      out.write("                    </tr> \r\n");
      out.write("\r\n");
      out.write("                    <tr class=\"alt\">\r\n");
      out.write("                        <td>Usuario</td>\r\n");
      out.write("                        <td ><input id=\"usuario\" name=\"usuario\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objeto.usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required readonly=\"readonly\"></td>                   \r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Contrasena</td>\r\n");
      out.write("\r\n");
      out.write("                        <td ><input id=\"contrasena\" name=\"contrasena\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objeto.contrasena}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required></td>  \r\n");
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td><input type=\"submit\" value=\"enviar\" class=\"btn\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("                <input type=\"hidden\" name=\"id_cat_usuario\" value=\"2\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <p><a href=\"login.jsp\" class=\"btn\">Volver</a></p>\r\n");
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
