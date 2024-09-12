package com.jornada.mentoria.mentoriaapi.controller;


import com.jornada.mentoria.mentoriaapi.dto.AlunoDto;
import com.jornada.mentoria.mentoriaapi.dto.PageDto;
import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import com.jornada.mentoria.mentoriaapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping
    public AlunoDto save(@RequestBody AlunoDto alunoDto) {
        return alunoService.saveAluno(alunoDto);
    }

    @GetMapping
    public List<Aluno> listar() throws Exception {
        return alunoRepository.findAll();
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
