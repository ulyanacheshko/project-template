package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDatabase implements PersonDatabaseInterface {
    private final Map<Integer, Person> personById = new HashMap<>();
    private final Map<String, List<Person>> personByName = new HashMap<>();
    private final Map<String, List<Person>> personByAddress = new HashMap<>();
    private final Map<String, List<Person>> personByPhoneNumber = new HashMap<>();

    public PersonDatabase() {
    }

    public int getSize() {
        return personById.size();
    }

    @Override
    public void add(Person person) {
        synchronized (this) {
            personById.put(person.id(), person);
            personByName.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
            personByAddress.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
            personByPhoneNumber.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
        }

    }

    @Override
    public void delete(int id) {
        synchronized (this) {
            Person person = personById.remove(id);
            if (person != null) {
                personByName.remove(person.name());
                personByAddress.remove(person.address());
                personByPhoneNumber.remove(person.phoneNumber());
            }
        }
    }

    @Override
    public List<Person> findByName(String name) {
        synchronized (this) {
            if (personByName.containsKey(name)) {
                return personByName.get(name).stream().toList();
            } else {
                throw new IllegalArgumentException("The database doesn't have this name");
            }
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        synchronized (this) {
            if (personByAddress.containsKey(address)) {
                return personByAddress.get(address).stream().toList();
            } else {
                throw new IllegalArgumentException("The database doesn't have this address");
            }
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        synchronized (this) {
            if (personByPhoneNumber.containsKey(phone)) {
                return personByPhoneNumber.get(phone).stream().toList();
            } else {
                throw new IllegalArgumentException("The database doesn't have this phoneNumber");
            }
        }
    }
}
