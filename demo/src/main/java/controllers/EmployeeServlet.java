package controllers;

import dao.EmployeeDAOImpl;
import models.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {

    private EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

    // Handling POST requests for adding new employees
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form data
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String department = request.getParameter("department");
            String poste = request.getParameter("poste");

            // Validate form data
            if (isAnyFieldEmpty(name, email, phone, department, poste)) {
                throw new IllegalArgumentException("All fields must be filled out.");
            }

            // Create an Employee object
            Employee employee = new Employee(name, email, phone, department, poste);

            // Add employee using the service layer
            employeeService.addEmployee(employee);

            // Redirect to the employee list page after successful addition
            response.sendRedirect("listEmployees");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // Handling GET requests for listing employees
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if ("/listEmployees".equals(action)) {
            // Fetch all employees from the service
            List<Employee> employees = employeeService.getAllEmployees();

            // Set the employee list as a request attribute
            request.setAttribute("employees", employees);
            System.out.println(employees);
            // Forward to the employees.jsp page to display the list
            request.getRequestDispatcher("employees.jsp").forward(request, response);
        }
    }

    // Helper method to check if any form fields are empty
    private boolean isAnyFieldEmpty(String... fields) {
        for (String field : fields) {
            if (field == null || field.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
