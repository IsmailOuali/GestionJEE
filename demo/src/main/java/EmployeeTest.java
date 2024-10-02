import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

public class EmployeeTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
        employee.setPhone("1234567890");
        employee.setDepartment("HR");
        employee.setPoste("Manager");

        session.save(employee);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
        }
    }