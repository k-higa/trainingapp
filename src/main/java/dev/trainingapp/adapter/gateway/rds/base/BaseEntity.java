package dev.trainingapp.adapter.gateway.rds.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updte_date")
    private Date updateDate;

    @PrePersist
    private void prePersist() {
        this.createDate = new Date();
        this.updateDate = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        this.updateDate = new Date();
    }

}
