package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        //imperative approach (do line by line coding for every logic)
        List<Person> females = new ArrayList<>();
        for(Person person : people) {
            if(person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);

        //declarative approach

        //filter
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        //sort
        System.out.println();
        System.out.println("sorted order by age");
        people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList()).forEach(System.out::println);

        //all match
        System.out.println();
        System.out.println("all match person age bigger than 5");
        boolean allMatch = people.stream().allMatch(person -> person.getAge() > 5);
        System.out.println(allMatch);

        //any match
        System.out.println();
        System.out.println("atleast 1 match person age bigger than 50");
        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 50);
        System.out.println(anyMatch);

        //None match
        System.out.println();
        System.out.println("none match person name is Unknown Name");
        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Unknown Name"));
        System.out.println(noneMatch);

        //Max
        System.out.println();
        System.out.println("returns person with max age - returns Optional<>");
//        Optional<streams.Person> max =
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(person -> {
                    System.out.println(person);
                });

        //Min
        System.out.println();
        System.out.println("returns person with min age - returns Optional<>");
//        Optional<streams.Person> min =
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(person -> {
                    System.out.println(person);
                });

        //Group
        System.out.println();
        System.out.println("create group map of male");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            });

        //all in one
        System.out.println();
        System.out.println("oldest female name");
        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemale.ifPresent(name -> System.out.println(name));
    }




    private static List<Person> getPeople() {
        List<Person> addPeople = new ArrayList<>();
        addPeople.add(new Person("James Bond", 20, Gender.MALE));
        addPeople.add(new Person("Alina Smith", 33, Gender.FEMALE));
        addPeople.add(new Person("Helen White", 57, Gender.FEMALE));
        addPeople.add(new Person("Alex Boz", 14, Gender.MALE));
        addPeople.add(new Person("Jamie Goa", 99, Gender.MALE));
        addPeople.add(new Person("Anna Cook", 7, Gender.FEMALE));
        addPeople.add(new Person("Zelda Brown", 120, Gender.FEMALE));
        return addPeople;
    }
}