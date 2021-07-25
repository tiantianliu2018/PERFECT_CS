package uml.classgraph.dependency;

/**
 * @author Kelly
 * @create 2021-07-25 09:24
 */
public class PersonServiceBean {
    private PersonDto personDto;

    public void save(Person person) {

    }

    public IDCard getIDCard(Integer personId) {
        return new IDCard(personId);
    }

    Department department = new Department();
}
