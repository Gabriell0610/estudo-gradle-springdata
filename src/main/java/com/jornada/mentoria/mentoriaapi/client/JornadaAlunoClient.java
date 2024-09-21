package com.jornada.mentoria.mentoriaapi.client;

import com.jornada.mentoria.mentoriaapi.dto.AlunoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "jornadasys", url = "http://localhost:8081/")
public interface JornadaAlunoClient {

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    List<AlunoDto> buscarAlunos();

    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    AlunoDto inserir(@RequestBody AlunoDto alunoDto);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = "application/json",
            produces = "application/json" )
    AlunoDto atualizar(@PathVariable("id") Integer id, @RequestBody AlunoDto alunoDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Boolean remover(@PathVariable("id") Integer idAluno);
}
