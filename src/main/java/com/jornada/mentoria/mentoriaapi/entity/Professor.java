package com.jornada.mentoria.mentoriaapi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_professor")
    @SequenceGenerator(name = "gerador_professor", sequenceName = "id_professor" , allocationSize = 1)
    @Column(name = "id_professor")
    private Integer idProfessor;

    @Embedded
    private DadosPessoais dadosPessoais;

    @ManyToMany(mappedBy = "professores", fetch = FetchType.LAZY)
    private Set<Mentoria> mentorias;

    public Professor() {}
}
