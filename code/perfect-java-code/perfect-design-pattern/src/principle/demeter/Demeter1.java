package principle.demeter;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:54
 */
public class Demeter1 {
    /**
     * 违反了迪米特法则
     *
     * @param args
     */
    public static void main(String[] args) {
//        SchoolManager schoolManager = new SchoolManager();
//        schoolManager.printAllEmployee(new CollegeManager());

        System.out.println("~~~使用迪米特法则的改进~~~");
        //创建了一个 SchoolManager 对象
        SchoolManager schoolManager = new SchoolManager();
        //输出学院的员工 id 和 学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
    }
}
