package com.jornada.mentoria.mentoriaapi.controller;


import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.entity.Modulo;
import com.jornada.mentoria.mentoriaapi.exceptions.BusinessException;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import com.jornada.mentoria.mentoriaapi.repositories.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modulo")
public class ModuloController {

    @Autowired
    ModuloRepository moduloRepository;


    @GetMapping
    public List<Modulo> listar() {
        return moduloRepository.findAll();
    }

    @GetMapping("/findByName")
    public List<Modulo> findByNome(String nome) throws BusinessException {

        if(!nome.contains("Java")) {
            throw new BusinessException("O nome deve conter Java");
        }
        return moduloRepository.findByNome(nome);
    }
}
