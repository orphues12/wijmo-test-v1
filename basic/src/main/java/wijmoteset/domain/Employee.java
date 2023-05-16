package wijmoteset.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import wijmoteset.BasicApplication;
import wijmoteset.domain.EmployeeAdd;

@Entity
@Table(name = "Employee_table")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "rankId", nullable = true)
    )
    private RankId rankId;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "departmentId", nullable = true)
    )
    private DepartmentId departmentId;

    @ElementCollection
    private List<EmployeeUser> employeeUser;

    @PostPersist
    public void onPostPersist() {
        EmployeeAdd employeeAdd = new EmployeeAdd(this);
        employeeAdd.publishAfterCommit();
    }

    public static EmployeeRepository repository() {
        EmployeeRepository employeeRepository = applicationContext()
            .getBean(EmployeeRepository.class);
        return employeeRepository;
    }

    public static ApplicationContext applicationContext() {
        return BasicApplication.applicationContext;
    }
}
