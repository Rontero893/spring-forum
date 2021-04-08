package cat.itb.servlettest.config;

import cat.itb.servlettest.methods.DataManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet
{
    private static final String PAGE_TITLE = "My first Servlet";

    //El post necesita el get para funcionar y el get no necesita el post. El get se ve en la url y el post no
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter())
        {
            String dni = req.getParameter("dni"), isbn = req.getParameter("isbn");

            out.println("<html><head>" + getAsTag(PAGE_TITLE, "title") + "</head><body>");

            out.println(getHeaderText("Hola que tal " + req.getParameter("nom") + "?", 1));

            out.println(getHeaderText(dni.length() == DataManager.DNI_DIGIT_SIZE?
                            "Es tu NIF " + DataManager.getDNILetter(Integer.parseInt(dni)) + "?" : "El dni tiene que tener 9 caracteres! ahora mismo tiene " + dni.length(), 2));

            out.println(getHeaderText(isbn.length() == DataManager.ISBN_DIGIT_SIZE?
                    "Es el valor de control de tu isbn " + DataManager.getISBNControlNumber(Long.parseLong(isbn)) + "?" :
                    "El isbn debe tener 12 elementos para calcular el 13 avo ahora mismo tiene " + isbn.length(), 3));

            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) { out.println("<html><head><title>Salutació Servlet</title></head><body><h1>Hola " + req.getParameter("nom") + "! </h1></body></html>"); }
    }

    private String getHeaderText(String text, int size) { return "<h" + size + ">" + text + "</h" + size + ">";}

    private String getAsTag(String text, String tag) { return "<" + tag + ">" + text + "</" + tag + ">";}
}
