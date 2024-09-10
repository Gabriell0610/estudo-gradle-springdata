package com.jornada.mentoria.mentoriaapi.controller;


import com.jornada.mentoria.mentoriaapi.dto.PageDto;
import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;
    @GetMapping
    public List<Aluno> listar() throws Exception {
        throw new Exception();
        //return alunoRepository.findAll();
    }

    @GetMapping("/listarTodosAlunosPaginados")
    public PageDto<Aluno> listarTodosAlunosPaginados(int page, int size) {
        Sort ordenation = Sort.by("dadosPessoais.nome")
                .and(Sort.by("idAluno"));
        Pageable pageable = PageRequest.of(page, size, ordenation);
        var pageReturned = alunoRepository.findAll(pageable);

        return new PageDto<>(pageReturned.getTotalElements(), pageReturned.getTotalPages(), page, size, pageReturned.getContent());
    }
}
