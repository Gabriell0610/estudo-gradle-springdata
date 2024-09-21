package com.jornada.mentoria.mentoriaapi.mapper;


import com.jornada.mentoria.mentoriaapi.dto.AlunoDto;
import com.jornada.mentoria.mentoriaapi.dto.EnderecoDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.entity.Endereco;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    // Mapeia AlunoDto para Aluno

    Aluno toEntity(AlunoDto alunoDto);

    // Mapeia Aluno para AlunoDto
    AlunoDto toDto(Aluno aluno);

    // Mapear EnderecoDto para Endereco e vice-versa
    Endereco toEntity(EnderecoDto enderecoDto);
    EnderecoDto toDto(Endereco endereco);

    // Mapear MentoriaDto para Mentoria e vice-versa
    @Mapping(target = "tipo", source = "tipoMentoria")
    Mentoria toEntity(MentoriaDto mentoriaDto);

    @Mapping(source = "tipo", target = "tipoMentoria")
    MentoriaDto toDto(Mentoria mentoria);
}
