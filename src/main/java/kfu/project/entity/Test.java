package kfu.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nurislam on 13.07.2018.
 */
@Entity
@Table(name = "tests")
public class Test extends BogoClass {

    @NotNull
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TestAnswer> answers;
}
