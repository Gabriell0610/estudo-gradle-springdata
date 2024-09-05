package com.jornada.mentoria.mentoriaapi.controller;

import com.jornada.mentoria.mentoriaapi.dto.NotaFinalPostDto;
import com.jornada.mentoria.mentoriaapi.entity.NotaFinal;
import com.jornada.mentoria.mentoriaapi.repositories.NotaFinalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/nota_final")
public class NotaFinalController {

    @Autowired
    NotaFinalRepository notaFinalRepository;


    @PostMapping
    public NotaFinal postNotalFinal(@RequestBody NotaFinalPostDto dto) {

        return notaFinalRepository.save(new NotaFinal(dto));
//        return new NotaFinalPostDto(notaExists.getIdNotaFinal().getIdModulo(), notaExists.getIdNotaFinal().getIdAluno(), notaExists.getNota());

    }
}
