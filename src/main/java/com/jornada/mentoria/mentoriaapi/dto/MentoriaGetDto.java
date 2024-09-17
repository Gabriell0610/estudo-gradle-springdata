package com.jornada.mentoria.mentoriaapi.dto;

import com.jornada.mentoria.mentoriaapi.entity.TipoMentoria;

import java.time.LocalDate;

public record MentoriaGetDto(String nome, Integer id_mentoria, LocalDate dataInicio, TipoMentoria tipoMentoria) {
}
