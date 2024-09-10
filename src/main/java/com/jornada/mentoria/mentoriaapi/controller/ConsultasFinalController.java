package com.jornada.mentoria.mentoriaapi.controller;

import com.jornada.mentoria.mentoriaapi.dto.NotaFinalPostDto;
import com.jornada.mentoria.mentoriaapi.entity.Endereco;
import com.jornada.mentoria.mentoriaapi.entity.NotaFinal;
import com.jornada.mentoria.mentoriaapi.repositories.EnderecoRepository;
import com.jornada.mentoria.mentoriaapi.repositories.NotaFinalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/consultas")
public class ConsultasFinalController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("/findByLogradouro")
    public List<Endereco> findConsultas(String logradouro) {

        return enderecoRepository.findByLogradouroIgnoreCase(logradouro);
    }

    @GetMapping("/findByNumero")
    public List<Endereco> consultaPorNumero(Integer numero) {

        return enderecoRepository.consultaPorNumero(numero);
    }

    @GetMapping("/findByBairro")
    public List<Endereco> consultaPorBairro(String bairro) {

        return enderecoRepository.consultaPorBairro(bairro);
    }
}
