package com.amachi.app.hospitalappservice.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private U createdBy;

    @CreatedDate
    @Column(name = "created_date", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", nullable = false)
    private U lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModifiedDate;
}
