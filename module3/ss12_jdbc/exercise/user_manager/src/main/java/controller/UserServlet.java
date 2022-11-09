package controller;

import model.User;
import service.IServiceUser;
import service.impl.ServiceUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
   private IServiceUser iServiceUser = new ServiceUser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "sort":
                showFormSort(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showFormSort(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = iServiceUser.sort();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        User user=iServiceUser.selectUser(id);
        request.setAttribute("user",user);
        try {
            request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            if (iServiceUser.deleteUser(id)) {
                List<User> userList=iServiceUser.selectAllUsers();
                request.setAttribute("userList",userList);
                request.getRequestDispatcher("/view/list.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = iServiceUser.selectAllUsers();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                addUser(request, response);
                break;
            case "edit":
                updateUse(request,response);
                break;
            case "search":
                searchUser(request,response);
                break;
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) {
        String country=request.getParameter("country");
        List<User> userList=iServiceUser.selectUser(country);
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("/view/search.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUse(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user=new User(id,name,email,country);
        try {
            if(iServiceUser.updateUser(user)){
                request.setAttribute("mess","sửa thành công");
                request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        String mess = "Thêm mới không thành công";
        try {
            boolean check = iServiceUser.insertUser(user);
            if (check) {
                mess = "Thêm mới thành công";
            }
            request.setAttribute("mess", mess);
            try {
                request.getRequestDispatcher("/view/create.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
