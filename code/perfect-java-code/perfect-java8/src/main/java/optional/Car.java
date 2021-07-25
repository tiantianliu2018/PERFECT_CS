package optional;

import java.util.Optional;

/**
 * @author Kelly
 * @create 2021-07-18 11:17
 */
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
