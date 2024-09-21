package com.jornada.mentoria.mentoriaapi.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoais implements Serializable {

    private String nome;
    private String telefone;

//    public DadosPessoais(DadosPessoais dadosPessoais) {
//        this.nome = dadosPessoais.getNome();
//        this.telefone = dadosPessoais.getTelefone();
//    }
}
