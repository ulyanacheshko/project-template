package edu.hw7.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.ArrayList;

class PersonDatabaseTest {
    private PersonDatabase personDatabase;

    @BeforeEach
    void setUp() {
        personDatabase = new PersonDatabase();
    }

    @Test
    void testAddDelete() throws InterruptedException {
        var thread1 = new Thread(() -> {
            Person person1 = new Person(1, "Ivan", "address1", "+375441112233");
            Person person2 = new Person(2, "Ivan", "address2", "+375292224446");
            Person person3 = new Person(3, "Olga", "address1", "+375295555112");
            personDatabase.add(person1);
            personDatabase.add(person2);
            personDatabase.add(person3);
        });
        var thread2 = new Thread(() -> {
            Person person4 = new Person(4, "Tanya", "address4", "+375446771231");
            Person person5 = new Person(5, "Ivan", "address2", "+375295642388");
            Person person6 = new Person(6, "Elena", "address6", "+375291234567");
            personDatabase.add(person4);
            personDatabase.add(person5);
            personDatabase.add(person6);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(personDatabase.getSize()).isEqualTo(6);

        thread1 = new Thread(() -> {
            for (int i = 1; i < 4; i++) {
                personDatabase.delete(i);
            }
        });
        thread2 = new Thread(() -> {
            for (int i = 4; i < 7; i++) {
                personDatabase.delete(i);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(personDatabase.getSize()).isEqualTo(0);

    }

    @Test
    void testFind() throws InterruptedException {
        var thread1 = new Thread(() -> {
            Person person1 = new Person(1, "Ivan", "address1", "+375441112233");
            Person person2 = new Person(2, "Ivan", "address2", "+375292224446");
            Person person3 = new Person(3, "Olga", "address1", "+375295555112");
            personDatabase.add(person1);
            personDatabase.add(person2);
            personDatabase.add(person3);
        });
        var thread2 = new Thread(() -> {
            Person person4 = new Person(4, "Tanya", "address4", "+375446771231");
            Person person5 = new Person(5, "Ivan", "address2", "+375295642388");
            Person person6 = new Person(6, "Elena", "address6", "+375291234567");
            personDatabase.add(person4);
            personDatabase.add(person5);
            personDatabase.add(person6);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        List<Person> person = personDatabase.findByName("Ivan");
        Person person1 = new Person(1, "Ivan", "address1", "+375441112233");
        Person person2 = new Person(2, "Ivan", "address2", "+375292224446");
        Person person5 = new Person(5, "Ivan", "address2", "+375295642388");
        assertThat(person).contains(person1, person2, person5);

    }

}

