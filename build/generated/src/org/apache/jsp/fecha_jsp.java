package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class fecha_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html> \n");
      out.write("<html dir=\"ltr\" lang=\"en-US\"> \n");
      out.write("    <head> \n");
      out.write("        <meta charset=\"UTF-8\" /> \n");
      out.write("        <title>jsp with the current date</title> \n");
      out.write("    </head> \n");
      out.write("\n");
      out.write("    \n");
      out.write("    <body> ");
java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
      out.write(" \n");
      out.write("        <h1>Current Date: ");
      out.print( df.format(new java.util.Date()));
      out.write(" \n");
      out.write("            \n");
      out.write("\n");
      out.write("        </h1> \n");
      out.write("        \n");
      out.write("        \n");
      out.write("            \n");
      out.write("            ");

            Date td = new Date(116, 5,3); 
            String b = new String(""); 
            SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd"); 
            b = format.format(td); 
            out.println(b);
            


            String fecha="2005-05-21";
            SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/dd");
            java.util.Date d=sdf.parse(fecha);
            out.println(d);
            
      out.write("\n");
      out.write("    </body> \n");
      out.write("</html>\n");
      out.write("\n");
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
