package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kelly
 * @create 2021-07-07 21:09
 */
public class StreamFilterPredicate {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, 23, "M", "Tom", "Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        List<Employee> employees = employeeList.stream()
                .filter(e -> e.getAge() > 70 && e.getGender().equals("M"))
                .collect(Collectors.toList());
        System.out.println(employees);

        List<Object> list = employeeList.stream().map(e -> {
            e.setAge(e.getAge() + 1);
            e.setGender(e.getGender().equals("M") ? "Male" : "Female");
            return e;
        }).collect(Collectors.toList());

        System.out.println(list);


    }
}
