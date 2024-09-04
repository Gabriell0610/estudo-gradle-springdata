package com.jornada.mentoria.mentoriaapi.controller;


import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }
}
