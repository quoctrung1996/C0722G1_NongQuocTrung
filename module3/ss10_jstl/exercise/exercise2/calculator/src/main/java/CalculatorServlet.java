import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double numberFirst = Double.parseDouble(request.getParameter("numberFirst"));
        double numberSecond = Double.parseDouble(request.getParameter("numberSecond"));
        char calculator = request.getParameter("operator").charAt(0);
        try {
            request.setAttribute("result",String.format("%s + %s = %s",numberFirst,numberSecond, Calculator.calculate(numberFirst, numberSecond, calculator) ) );
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("result", e.getMessage());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
