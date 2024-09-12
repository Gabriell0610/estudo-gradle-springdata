package com.jornada.mentoria.mentoriaapi.dto;

public record EnderecoDto(  String logradouro,
                            Integer numero,
                            String bairro,
                            String cidade,
                            String estado) {
}
