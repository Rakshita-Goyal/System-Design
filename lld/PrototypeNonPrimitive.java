package lld;

import java.util.*;

interface PersonPrototype {
    PersonPrototype clone();
    void showDetails();
}

class Address {
    String city;
    String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
    public Address(Address other) {
        this.city = other.city;
        this.state = other.state;
    }
}

class Person implements PersonPrototype {
    private String name;     
    private int age;         
    private Address address; 

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.address = new Address(other.address); 
    }




    @Override
    public PersonPrototype clone() {
        return new Person(this);
    }

    public void setCity(String city) {
        this.address.city = city;
    }

    public void showDetails() {
        System.out.println("Name: " + name + 
                           ", Age: " + age + 
                           ", City: " + address.city + 
                           ", State: " + address.state);
    }

}

class PersonRegistry {
    private Map<String, PersonPrototype> map = new HashMap<>();

    public void addPrototype(String key, PersonPrototype p) {
        map.put(key, p);
    }

    public PersonPrototype getClone(String key) {
        return map.get(key).clone();
    }
}

public class PrototypeNonPrimitive{
    public static void main(String args[]){


        PersonRegistry registry = new PersonRegistry();

        Person original = new Person("Rahul", 25, new Address("Delhi", "DL"));
        registry.addPrototype("person1", original);

        Person p1 = (Person) registry.getClone("person1");
        Person p2 = (Person) registry.getClone("person1");

        p1.setCity("Mumbai");

        System.out.println("Original Object:");
        original.showDetails();

        System.out.println("Cloned Object 1:");
        p1.showDetails();
    }
}