package kfu.project.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nurislam on 13.07.2018.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BogoClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
