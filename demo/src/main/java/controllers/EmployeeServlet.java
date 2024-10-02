package controllers;

import dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Employee;

import java.io.IOException;

public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

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

            employeeDAO.saveEmployee(employee);

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
        response.setContentType("text/html");
        response.getWriter().println("<form action='addEmployee' method='POST'>");
        response.getWriter().println("Name: <input type='text' name='name'/><br/>");
        response.getWriter().println("Email: <input type='text' name='email'/><br/>");
        response.getWriter().println("Phone: <input type='text' name='phone'/><br/>");
        response.getWriter().println("Department: <input type='text' name='department'/><br/>");
        response.getWriter().println("Position: <input type='text' name='position'/><br/>");
        response.getWriter().println("<input type='submit' value='Add Employee'/>");
        response.getWriter().println("</form>");
    }
}