import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FacilityServlet", value = "/facility-servlet")
public class FacilityServlet extends HttpServlet {
    private static List<Facility> facilityList = new ArrayList<>();

    static {
        facilityList.add(new Facility(1, "Villa Beach Front", 25000, 1000000, 10, "vip", "Có hồ bơi", 500.0, 4, "null", 3, 1));
        facilityList.add(new Facility(2, "House Princess 01", 14000, 5000000, 7, "vip", "Có thêm bếp nướng", null, 4, "null", 3, 1));
        facilityList.add(new Facility(3, "Room Twin 01", 5000, 1000000, 2, "normal", "Có tivi", null, 0, "1 Xe máy, 1 Xe đạp", 4, 3));
        facilityList.add(new Facility(4, "Villa No Beach Front", 22000, 9000000, 8, "normal", "Có hồ bơi", 300.0, 3, "null", 3, 1));
        facilityList.add(new Facility(5, "House Princess 02", 10000, 4000000, 5, "normal", "Có thêm bếp nướng", null, '2', null, '3', '2'));
        facilityList.add(new Facility(6, "Room Twin 02", 3000, 900000, 2, "normal", "Có tivi", null, 0, "1 Xe máy", '4', '3'));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("facilityList", facilityList);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
