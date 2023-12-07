package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDatabaseReadWriteLock implements PersonDatabaseInterface {
    private final Map<Integer, Person> personById = new HashMap<>();
    private final Map<String, List<Person>> personByName = new HashMap<>();
    private final Map<String, List<Person>> personByAddress = new HashMap<>();
    private final Map<String, List<Person>> personByPhoneNumber = new HashMap<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public PersonDatabaseReadWriteLock() {

    }

    public int getSize() {
        return personById.size();
    }

    @Override
    public void add(Person person) {
        readWriteLock.writeLock().lock();
        personById.put(person.id(), person);
        personByName.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
        personByAddress.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
        personByPhoneNumber.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
        readWriteLock.writeLock().unlock();
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        Person person = personById.remove(id);
        if (person != null) {
            personByName.remove(person.name());
            personByAddress.remove(person.address());
            personByPhoneNumber.remove(person.phoneNumber());
        }
        readWriteLock.writeLock().unlock();
    }

    @Override
    public List<Person> findByName(String name) {
        readWriteLock.writeLock().lock();
        if (personByName.containsKey(name)) {
            readWriteLock.writeLock().unlock();
            return personByName.get(name).stream().toList();
        } else {
            readWriteLock.writeLock().unlock();
            throw new IllegalArgumentException("The database doesn't have this name");
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        readWriteLock.writeLock().lock();
        if (personByAddress.containsKey(address)) {
            readWriteLock.writeLock().unlock();
            return personByAddress.get(address).stream().toList();
        } else {
            readWriteLock.writeLock().unlock();
            throw new IllegalArgumentException("The database doesn't have this address");
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        readWriteLock.writeLock().lock();
        if (personByPhoneNumber.containsKey(phone)) {
            readWriteLock.writeLock().unlock();
            return personByPhoneNumber.get(phone).stream().toList();
        } else {
            readWriteLock.writeLock().unlock();
            throw new IllegalArgumentException("The database doesn't have this phoneNumber");
        }
    }
}

