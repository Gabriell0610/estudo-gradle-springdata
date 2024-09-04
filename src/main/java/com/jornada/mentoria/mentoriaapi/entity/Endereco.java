package com.jornada.mentoria.mentoriaapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_endereco")
    @SequenceGenerator(name = "gerador_endereco", sequenceName = "endereco_seq", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "endereco")
    private Aluno aluno;

    public Endereco() {}

}
