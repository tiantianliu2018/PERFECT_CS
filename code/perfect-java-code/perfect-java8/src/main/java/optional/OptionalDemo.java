package optional;

import java.util.Optional;

/**
 * @author Kelly
 * @create 2021-07-18 11:20
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Person person = new Person();
        String name = getCarInsuranceName(Optional.of(person));
        System.out.println(name);
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCarAsOptional)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
