package com.jornada.mentoria.mentoriaapi.mapper;


import com.jornada.mentoria.mentoriaapi.dto.AlunoDto;
import com.jornada.mentoria.mentoriaapi.dto.EnderecoDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.entity.Endereco;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    Aluno convertAlunoDtoToEntity(AlunoDto dto);
    AlunoDto convertAlunoEntityToDto(Aluno entity);

    Endereco convertEnderecoDtoToEntity(EnderecoDto dto);
    EnderecoDto convertEnderecoEntityToDto(Endereco entity);

    Mentoria convertMentoriaDtoToEntity(MentoriaDto dto);
    MentoriaDto convertMentoriaEntityToDto(Mentoria entity);
}
