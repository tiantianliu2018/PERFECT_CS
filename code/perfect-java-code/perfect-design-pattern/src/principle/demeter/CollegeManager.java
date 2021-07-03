package principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理学院员工的管理类
 *
 * @author Kelly
 * @create 2021-07-03 12:58
 */
public class CollegeManager {
    /**
     * 返回学院的所有员工
     * @return 学院员工列表
     */
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            //这里我们增加了 10 个员工到 list
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工 id = " + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * 输出学院员工的信息
     */
    public void printAllEmployee() {
        List<CollegeEmployee> employeeList = getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : employeeList) {
            System.out.println(e.getId());
        }
    }
}
