package principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * 学校管理类
 *
 * @author Kelly
 * @create 2021-07-03 13:00
 */
public class SchoolManager {
    /**
     * 返回学校总部的员工
     *
     * @return
     */
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i < 5; i++) {
            // 这里我们增加了 5 个员工到 list
            Employee emp = new Employee();
            emp.setId("学校总部员工 id = " + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * 输出学校总部和学院员工信息(id)
     *
     * @param sub
     */
    void printAllEmployee(CollegeManager sub) {
        sub.printAllEmployee();

        // 获取到学校总部员工
        List<Employee> employee1 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : employee1) {
            System.out.println(e.getId());
        }

    }
}
