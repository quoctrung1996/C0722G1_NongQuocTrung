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
        double number1 = Double.parseDouble(request.getParameter("number1"));
        double number2 = Double.parseDouble(request.getParameter("number2"));
        char calculator = request.getParameter("operator").charAt(0);
        try {
            request.setAttribute("result",String.format("%s + %s = %s",number1,number2, Calculator.calculate(number1, number2, calculator) ) );
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("result", e.getMessage());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
