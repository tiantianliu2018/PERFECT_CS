package stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Kelly
 * @create 2021-07-07 21:10
 */
@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private Integer age;   // 年龄
    private String gender;  // 性别
    private String firstName;
    private String lastName;
}
