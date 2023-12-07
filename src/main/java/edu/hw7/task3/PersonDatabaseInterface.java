package edu.hw7.task3;

import java.util.List;

interface PersonDatabaseInterface {
    void add(Person person);

    void delete(int id);

    List<Person> findByName(String name);

    List<Person> findByAddress(String address);

    List<Person> findByPhone(String phone);
}
