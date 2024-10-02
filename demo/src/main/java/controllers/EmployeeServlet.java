package controllers;

import dao.EmployeeDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Employee;
import service.EmployeeService;

import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {

    private EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    private EmployeeService employeeService = new service.impl.EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String department = request.getParameter("department");
            String poste = request.getParameter("poste");

            if (isAnyFieldEmpty(name, email, phone, department, poste)) {
                throw new IllegalArgumentException("All fields must be filled out.");
            }

            Employee employee = new Employee(name, email, phone, department, poste);

            employeeService.addEmployee(employee);

            response.sendRedirect("addEmployee");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private boolean isAnyFieldEmpty(String... fields) {
        for (String field : fields) {
            if (field == null || field.isEmpty()) {
                return true;
            }
        }
        return false;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if ("/listEmployees".equals(action)) {
            List<Employee> employees = employeeService.getAllEmployees();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("employees.jsp").forward(request, response);
        }
    }
}