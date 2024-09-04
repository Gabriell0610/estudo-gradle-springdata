package com.jornada.mentoria.mentoriaapi.entity;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class DadosPessoais implements Serializable {

    private String nome;
    private String telefone;
}
