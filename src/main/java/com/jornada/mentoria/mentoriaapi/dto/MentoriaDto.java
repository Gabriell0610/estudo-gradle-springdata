package com.jornada.mentoria.mentoriaapi.dto;

import com.jornada.mentoria.mentoriaapi.entity.TipoMentoria;

import java.time.LocalDate;

public record MentoriaDto(String nome, TipoMentoria tipoMentoria, LocalDate data_inicio) {
}
