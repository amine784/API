package com.pi.gest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;


@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AbstactEntity {


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
