package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controller.furamaServlet", value = "/furama_web")
public class furamaServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();
    private List<Customer> customerList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showCutomer":
                showFromCutomer(request, response);
                break;
            case "addCutomer":
                showFromAdd(request, response);
                break;
            case "editCustomer":
                showFromEdit(request, response);
                break;
            default:
                showFromFurama(request, response);
                break;
        }
    }

    private void showFromEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer=iCustomerService.findById(id);
        request.setAttribute("customer",customer);
        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFromAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFromCutomer(HttpServletRequest request, HttpServletResponse response) {
        customerList = iCustomerService.showList();
        try {
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFromFurama(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("furama_home.jsp").forward(request, response);
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
        switch (action) {
            case "addCutomer":
                addCustomer(request, response);
                break;
            case "editCustomer":
                editCustomer(request, response);
                break;
            case "deleteCustomer":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        String mess = "Xóa không thành công";
        if (iCustomerService.deleteCustomer(id)) {
            mess = "xóa thành công";
        }
        customerList = iCustomerService.showList();
        request.setAttribute("mess", mess);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("Name");
        String birthday = request.getParameter("Birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
        String idCard = request.getParameter("IdCard");
        String phoneNumber = request.getParameter("PhoneNumber");
        String email = request.getParameter("Email");
        String address = request.getParameter("Address");
        int customerType = Integer.parseInt(request.getParameter("CustomerType"));
        Customer customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, address, customerType);
        String mess = "Sửa không thành công";
        if (iCustomerService.editCustomer(customer)) {
            mess = "sửa thành công";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("Name");
        String birthday = request.getParameter("Birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
        String idCard = request.getParameter("IdCard");
        String phoneNumber = request.getParameter("PhoneNumber");
        String email = request.getParameter("Email");
        String address = request.getParameter("Address");
        int customerType = Integer.parseInt(request.getParameter("CustomerType"));
        Customer customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, address, customerType);
        String mess = "Thêm mới không thành công";
        if (iCustomerService.insertCustomer(customer)) {
            mess = "Thêm mới thành công";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
