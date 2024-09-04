package com.jornada.mentoria.mentoriaapi.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Nota_Final_Modulo")
@Getter
@Setter
public class NotaFinal {

    @EmbeddedId
    private IdNotaFinal idNotaFinal;
    private Double nota;
}
