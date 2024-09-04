package com.jornada.mentoria.mentoriaapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_aluno")
    @SequenceGenerator(name = "gerador_aluno",  sequenceName = "aluno_seq", allocationSize = 1)
    @Column(name = "id_aluno")
    private Integer idAluno;

    @Embedded
    private DadosPessoais dadosPessoais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mentoria", referencedColumnName = "id_mentoria")
    @JsonIgnore
    private Mentoria mentoria;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    @JsonIgnore
    private Endereco endereco;

    public Aluno() {}
}
