package me.zinchenko.DAO;

import me.zinchenko.City;
import me.zinchenko.Employee;
import me.zinchenko.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void create(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();){
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    // получение объекта по id
    @Override
    public City readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    // получение списка всех объектов
    @Override
    public List<City> readAll() {
        List<City> cityList = (List<City>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From City").list();
        return cityList;
    }

    // изменение объекта
    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    // удаление оюъекта
    @Override
    public void delete(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
