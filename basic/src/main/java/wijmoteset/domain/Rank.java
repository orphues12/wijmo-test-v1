package wijmoteset.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import wijmoteset.BasicApplication;
import wijmoteset.domain.Rank;

@Entity
@Table(name = "Rank_table")
@Data
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @PostPersist
    public void onPostPersist() {
        Rank rank = new Rank(this);
        rank.publishAfterCommit();
    }

    public static RankRepository repository() {
        RankRepository rankRepository = applicationContext()
            .getBean(RankRepository.class);
        return rankRepository;
    }

    public static ApplicationContext applicationContext() {
        return BasicApplication.applicationContext;
    }
}
