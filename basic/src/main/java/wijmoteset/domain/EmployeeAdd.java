package wijmoteset.domain;

import java.util.*;
import lombok.*;
import wijmoteset.domain.*;
import wijmoteset.infra.AbstractEvent;

@Data
@ToString
public class EmployeeAdd extends AbstractEvent {

    private Long id;
    private String userId;
    private RankId rankId;
    private DepartmentId departmentId;
    private List<EmployeeUser> employeeUser;

    public EmployeeAdd(Employee aggregate) {
        super(aggregate);
    }

    public EmployeeAdd() {
        super();
    }
}
