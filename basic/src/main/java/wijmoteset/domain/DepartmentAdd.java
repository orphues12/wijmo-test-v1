package wijmoteset.domain;

import java.util.*;
import lombok.*;
import wijmoteset.domain.*;
import wijmoteset.infra.AbstractEvent;

@Data
@ToString
public class DepartmentAdd extends AbstractEvent {

    private Long id;
    private String name;

    public DepartmentAdd(Department aggregate) {
        super(aggregate);
    }

    public DepartmentAdd() {
        super();
    }
}
