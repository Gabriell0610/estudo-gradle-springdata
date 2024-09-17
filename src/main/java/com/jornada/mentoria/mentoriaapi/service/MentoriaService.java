package com.jornada.mentoria.mentoriaapi.service;

import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaEditDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaGetDto;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import com.jornada.mentoria.mentoriaapi.mapper.AlunoMapper;
import com.jornada.mentoria.mentoriaapi.mapper.MentoriaMapper;
import com.jornada.mentoria.mentoriaapi.repositories.MentoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class MentoriaService {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    MentoriaMapper mentoriaMapper;


    public MentoriaDto postMentoria(MentoriaDto mentoriaDto) {

        var savedMentoria = mentoriaRepository.save(new Mentoria(mentoriaDto));
        return new MentoriaDto(savedMentoria.getNome(), savedMentoria.getTipo());
    }

    public List<MentoriaGetDto> getAllMentoria() {
        return mentoriaRepository.findAll().stream()
                .map(data -> new MentoriaGetDto(data.getNome(), data.getIdMentoria(), data.getDataInicio(),  data.getTipo()))
                .collect(Collectors.toList());

    }

    public MentoriaEditDto editMentoria(Integer id, MentoriaEditDto mentoriaEditDto) {

        var mentoriaExists = mentoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(mentoriaEditDto.nome() != null) {
            mentoriaExists.setNome(mentoriaEditDto.nome());
        }

        if(mentoriaEditDto.tipoMentoria() != null) {
            mentoriaExists.setTipo(mentoriaEditDto.tipoMentoria());
        }


        mentoriaRepository.save(mentoriaExists);
        return new MentoriaEditDto(mentoriaExists.getNome(), mentoriaExists.getTipo());


    }

    public MentoriaGetDto bucarPorId(int parseId) {
        var foundMentoria = mentoriaRepository.findById(parseId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new MentoriaGetDto(foundMentoria.getNome(), foundMentoria.getIdMentoria(), foundMentoria.getDataInicio(), foundMentoria.getTipo());
    }

    public void removerMentoria(int parseId) {
        mentoriaRepository.deleteById(parseId);
    }
}
