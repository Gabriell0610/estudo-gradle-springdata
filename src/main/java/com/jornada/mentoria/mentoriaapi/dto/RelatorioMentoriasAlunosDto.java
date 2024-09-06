package com.jornada.mentoria.mentoriaapi.dto;

public record RelatorioMentoriasAlunosDto(Integer idMentoria,
         String nomeMentoria,
         Integer idAluno,
         String nomeAluno,
         String telefoneAluno,
         Integer idEndereco,
         String logradouro) {
}
