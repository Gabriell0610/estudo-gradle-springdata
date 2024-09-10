package com.jornada.mentoria.mentoriaapi.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;

public record ExceptionDto(Date data, String erroMessage, Integer status) {
}
