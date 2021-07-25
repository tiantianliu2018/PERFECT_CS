package optional;

import java.util.Optional;

/**
 * @author Kelly
 * @create 2021-07-18 10:53
 */
public class Person {
    private Car car;

    public Car getCar() {
        return car;
    }

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}
