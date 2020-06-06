package com.backendprojektweb.model.dto;

import com.backendprojektweb.model.Screening;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScreeningDTO {
    private Screening screening;
    private Long movieId;
    private Long hallId;
}
