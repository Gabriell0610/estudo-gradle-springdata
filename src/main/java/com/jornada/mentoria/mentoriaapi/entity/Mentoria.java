package com.jornada.mentoria.mentoriaapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "código identificador da mentoria", example = "1")
    @Column(name = "id_mentoria")
    private Integer idMentoria;

    @Schema(description = "Atributo que representa o nome da mentoria", example = "Mentoria de Medicina")
    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "tipo")
    private TipoMentoria tipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mentoria")
    private Set<Aluno> alunos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mentoria"  )
    private Set<Modulo> modulos; // SET É UMA LISTA NÃO REPETE ELEMENTO

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
    @JsonIgnore
    private Set<Professor> professores;


    public Mentoria (MentoriaDto mentoriaDto) {
        this.nome = mentoriaDto.nome();
        this.dataInicio = mentoriaDto.data_inicio();
        this.tipo = mentoriaDto.tipoMentoria();
    }

    public Mentoria () {}

    public Integer getIdMentoria() {
        return idMentoria;
    }

    public void setIdMentoria(Integer idMentoria) {
        this.idMentoria = idMentoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public TipoMentoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoMentoria tipo) {
        this.tipo = tipo;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }
}
