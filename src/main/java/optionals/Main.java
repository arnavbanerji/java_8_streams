package optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //Optionals is used to manipulate null pointer objects in our own way
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());


        Optional<String> present = Optional.of("hello");
        System.out.println(present.isPresent());
        present.ifPresent(word -> {
            System.out.println(word);
        });


        Optional<String> nullPresent = Optional.ofNullable(null);
        System.out.println(nullPresent); //returns Optional.empty


        Person person = new Person("Arnav",null);

        person.getEmail().ifPresent(word -> {
                    System.out.println(word);
                });
    }
}
