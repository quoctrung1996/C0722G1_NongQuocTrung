package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Currency;
import java.util.List;

@WebServlet(name = "controller.FuramaServlet", value = "/furama")
public class FuramaServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showCustomer":
                showCustomer(request, response);
                break;
            case "addCustomer":
                addCustomer(request,response);
                break;
            default:
                showFurama(request, response);
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.showList();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFurama(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/furama_home.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "addCustomer":
                createCustomer(request,response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("Name");
        String birthday=request.getParameter("Birthday");
        boolean gender= Boolean.parseBoolean(request.getParameter("Gender"));
        String identityCard=request.getParameter("IdCard");
        String phoneNumber=request.getParameter("PhoneNumber");
        String email=request.getParameter("Email");
        String address=request.getParameter("Address");
        int customerType= Integer.parseInt(request.getParameter("CustomerType"));
        Customer customer=new Customer(id,name,birthday,gender,identityCard,phoneNumber,email,address,customerType);
        String mess="thêm mới không thành công";
        if (iCustomerService.add(customer)){
            mess="thêm mới thành công";
        }
        request.setAttribute("mess",mess);
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request,response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
