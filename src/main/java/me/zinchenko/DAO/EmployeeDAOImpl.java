package me.zinchenko.DAO;

import me.zinchenko.DAO.EmployeeDAO;
import me.zinchenko.Employee;
import me.zinchenko.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    //добавление объекта
    @Override
    public void create(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    // получение объекта по id
    @Override
    public Employee readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    // получение списка всех объектов
    @Override
    public List<Employee> readAll() {
        List<Employee> employeeList = (List<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Employee").list();
        return employeeList;
    }

    // изменение объекта
    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    // удаление оюъекта
    @Override
    public void delete(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
