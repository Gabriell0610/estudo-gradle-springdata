package com.jornada.mentoria.mentoriaapi.mapper;

import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MentoriaMapper {


    Mentoria convertDtoToEntity(MentoriaDto mentoriaDto);
}
