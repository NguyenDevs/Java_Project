import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GreetServlet")
public class GreetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GreetServlet() {
        super();
    }

    public void init() throws ServletException {
        // Phương thức init() được gọi khi Servlet được khởi tạo
        System.out.println("Servlet initialized");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Phương thức doGet() được gọi khi có yêu cầu HTTP GET
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>GreetServlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hi Everyone!</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
        // Phương thức destroy() được gọi khi Servlet sắp bị hủy bỏ
        System.out.println("Servlet destroyed");
    }
}