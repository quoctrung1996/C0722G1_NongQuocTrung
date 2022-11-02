import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "display_discount", value = "/display")
public class display_discount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float listPrice = Float.parseFloat(request.getParameter("list_price"));
        float discountPercent = Float.parseFloat(request.getParameter("discount_percent"));
        double discountAmount=listPrice*discountPercent*0.01;
        float discountPrice=listPrice-discountPercent;
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.println("<h3>Discount Amount: "+discountAmount+"<h3>");
        writer.println("<h3>Discount Price: "+discountPrice+"<h3>");
    }
}
