package com.backendprojektweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "halls")
public class Hall extends AbstractEntity {
    @JsonIgnore
    @OneToMany(mappedBy = "hallId")
    private List<Screening> screeningList;
}
