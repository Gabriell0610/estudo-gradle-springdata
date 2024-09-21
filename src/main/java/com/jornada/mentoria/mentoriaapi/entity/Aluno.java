package com.jornada.mentoria.mentoriaapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
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


    public Aluno(DadosPessoais dadosPessoais, Endereco endereco, Mentoria mentoria) {
        this.dadosPessoais = dadosPessoais;
        this.endereco = endereco;
        this.mentoria = mentoria;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public Mentoria getMentoria() {
        return mentoria;
    }

    public void setMentoria(Mentoria mentoria) {
        this.mentoria = mentoria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
