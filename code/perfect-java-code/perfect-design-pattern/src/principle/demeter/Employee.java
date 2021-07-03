package principle.demeter;

/**
 * @author Kelly
 * @description 学校总部员工类
 * @create 2021-07-03 12:55
 */
public class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
