package me.zinchenko.DAO;

import me.zinchenko.City;
import me.zinchenko.Employee;

import java.util.List;

public interface CityDAO {
    // добавление объекта
    void create(City city);

    // получение объекта по id
    City readById(int id);

    // получение списка всех объектов
    List<City> readAll();

    // изменение объекта
    void updateCity(City city);

    // удаление оюъекта
    void delete(City city);
}