package com.jornada.mentoria.mentoriaapi.controller;


import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.entity.Modulo;
import com.jornada.mentoria.mentoriaapi.exceptions.BusinessException;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import com.jornada.mentoria.mentoriaapi.repositories.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Modulo> findByNome(@RequestParam(name = "nome") String nome) throws BusinessException {

        var moduloExists = moduloRepository.findByNome(nome);

        if (moduloExists.isEmpty()) {
            throw new BusinessException("Digite o nome correto do módulo");
        }

        return moduloExists;
    }
}
