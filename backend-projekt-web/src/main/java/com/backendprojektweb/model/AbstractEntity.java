package com.backendprojektweb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JsonIgnore
    @Version
    @Column(name = "version")
    private Long version;

    @JsonIgnore
    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

}
