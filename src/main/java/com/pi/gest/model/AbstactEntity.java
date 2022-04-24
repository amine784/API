package com.pi.gest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstactEntity {

    @GeneratedValue(strategy = GenerationType.AUTO )
    @Id
    private Integer Id;

    @JsonIgnore
    @Column(nullable = false)
    @CreatedDate
    private Instant createdAt ;

    @JsonIgnore
    @LastModifiedDate
    private Instant updatedAt;
}
