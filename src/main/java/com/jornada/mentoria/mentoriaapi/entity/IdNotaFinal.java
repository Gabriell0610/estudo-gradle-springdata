package com.jornada.mentoria.mentoriaapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdNotaFinal  implements Serializable {

    @Column(name = "id_modulo")
    private Integer idModulo;

    @Column(name = "id_aluno")
    private Integer idAluno;
}
