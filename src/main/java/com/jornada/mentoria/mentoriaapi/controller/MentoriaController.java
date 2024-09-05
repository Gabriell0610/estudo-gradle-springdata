package com.jornada.mentoria.mentoriaapi.controller;


import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaEditDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaGetDto;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import com.jornada.mentoria.mentoriaapi.repositories.MentoriaRepository;
import com.jornada.mentoria.mentoriaapi.service.MentoriaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    MentoriaService mentoriaService;

    @Autowired
    MentoriaRepository mentoriaRepository;

    @PostMapping
    @Transactional
    public MentoriaDto postData(@RequestBody MentoriaDto mentoriaDto) {
        return mentoriaService.postMentoria(mentoriaDto);
    }

    @GetMapping
    public List<MentoriaGetDto> getAll() {
        return mentoriaService.getAllMentoria();
    }

    @PutMapping("/{id}")
    public MentoriaEditDto editData(@PathVariable("id") String id, @RequestBody MentoriaEditDto mentoriaEditDto) {
        var parseId = Integer.parseInt(id);
        return mentoriaService.editMentoria(parseId, mentoriaEditDto);
    }

    @GetMapping("/{id}")
    public MentoriaGetDto getDatapPorId(@PathVariable("id") String id) {
        var parseId = Integer.parseInt(id);
        return mentoriaService.bucarPorId(parseId);
    }

    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable("id") String id) {
        var parseId = Integer.parseInt(id);
        mentoriaService.removerMentoria(parseId);
        return "Mentoria Removida";
    }

    @GetMapping("/findByDateInicio")
    public List<Mentoria> findByDateInicio(LocalDate dataInicio) {
        return mentoriaRepository.findByDataInicioLessThan(dataInicio);
    }

}
