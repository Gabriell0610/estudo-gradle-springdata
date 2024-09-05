package com.jornada.mentoria.mentoriaapi.entity;

import com.jornada.mentoria.mentoriaapi.dto.NotaFinalPostDto;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Nota_Final_Modulo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaFinal {

    @EmbeddedId
    private IdNotaFinal idNotaFinal;
    private Double nota;

    public NotaFinal(NotaFinalPostDto dto) {
        this.nota = dto.nota();
        this.idNotaFinal = new IdNotaFinal(dto.idModulo(), dto.idAluno());
    }
}
