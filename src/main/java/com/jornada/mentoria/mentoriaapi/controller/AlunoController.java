package com.jornada.mentoria.mentoriaapi.controller;


import com.jornada.mentoria.mentoriaapi.client.JornadaAlunoClient;
import com.jornada.mentoria.mentoriaapi.dto.AlunoDto;
import com.jornada.mentoria.mentoriaapi.dto.PageDto;
import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import com.jornada.mentoria.mentoriaapi.service.AlunoService;
import com.jornada.mentoria.mentoriaapi.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EmailService emailService;

    @Autowired
    JornadaAlunoClient jornadaAlunoClient;

    @PostMapping
    @Transactional
    public AlunoDto save(@RequestBody @Valid AlunoDto alunoDto) {
        return alunoService.saveAluno(alunoDto);
    }

    //Enviando EMAIL
    @PostMapping("/email-simples")
    public void enviarEmailSimples(String para, String assunto, String texto ) {
        this.emailService.enviarEmailSimples(para, assunto, texto);
    }

    @PostMapping("/email-anexo")
    public void enviarEmailAnexo(String para, String assunto, String texto ) throws MessagingException {
        this.emailService.enviarEmailComAnexo(para, assunto, texto);
    }

    @PostMapping("/email-template")
    public void enviarEmailTemplate(String para, String assunto, String name ) throws MessagingException {
        this.emailService.enviarEmailComTemplate(para, assunto, name);
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

    // FeignClient
    @GetMapping("/aluno-sys")
    public List<AlunoDto> listAlunos() {
        return jornadaAlunoClient.buscarAlunos();
    }

    @PostMapping("/aluno-sys")
    public AlunoDto inserirAlunos(@PathVariable AlunoDto dto) {
        return jornadaAlunoClient.inserir(dto);
    }

    @PutMapping("/aluno-sys/{id}")
    public AlunoDto atualizarAlunos(@PathVariable("id") Integer id, @RequestBody AlunoDto dto) {
        return jornadaAlunoClient.atualizar(id, dto);
    }

    @DeleteMapping("/aluno-sys/{id}")
    public boolean removeAlunos(@PathVariable("id") Integer id) {
        return jornadaAlunoClient.remover(id);
    }

}
