package com.jornada.mentoria.mentoriaapi.dto;

import com.jornada.mentoria.mentoriaapi.entity.TipoMentoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MentoriaDto(
        @NotEmpty
        @Size(min = 10, max = 50, message = "O nome da mentoria deve estar entre 10 e 50")
        String nome,
        TipoMentoria tipoMentoria,
        LocalDate data_inicio) {
}
