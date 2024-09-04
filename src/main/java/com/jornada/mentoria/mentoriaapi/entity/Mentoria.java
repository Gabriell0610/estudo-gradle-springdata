package com.jornada.mentoria.mentoriaapi.entity;


import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "mentoria")
@Getter
@Setter
public class Mentoria {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_mentoria")
    @SequenceGenerator(name = "gerador_mentoria", sequenceName = "mentoria_seq", allocationSize = 1)
    @Column(name = "id_mentoria")
    private Integer idMentoria;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "tipo")
    private TipoMentoria tipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mentoria")
    private Set<Aluno> alunos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mentoria"  )
    private Set<Modulo> modulos; // SET NÃO REPETE ELEMENTO

    //Muitas mentorias para muitos professores
    @ManyToMany(fetch = FetchType.LAZY) //FAZ O CARREGAMENTO APENAS QUANDO O GET FOR UTILIZADO
    @JoinTable(name = "Mentoria_Professor",
            joinColumns = @JoinColumn(
                    name = "id_mentoria", // chave da tabela (MENTORIA)
                    referencedColumnName = "id_mentoria"
            ), //chave da tebela professor (PROFESSOR)
            inverseJoinColumns = @JoinColumn(
                    name = "id_professor",
                    referencedColumnName = "id_professor"
            )
    )
    private Set<Professor> professores;


    public Mentoria (MentoriaDto mentoriaDto) {
        this.nome = mentoriaDto.nome();
        this.dataInicio = mentoriaDto.data_inicio();
        this.tipo = mentoriaDto.tipoMentoria();
    }

    public Mentoria () {}
}
