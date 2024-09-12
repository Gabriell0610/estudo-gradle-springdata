package com.jornada.mentoria.mentoriaapi.service;

import com.jornada.mentoria.mentoriaapi.dto.AlunoDto;
import com.jornada.mentoria.mentoriaapi.dto.EnderecoDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.entity.Endereco;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import com.jornada.mentoria.mentoriaapi.mapper.AlunoMapper;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import com.jornada.mentoria.mentoriaapi.repositories.EnderecoRepository;
import com.jornada.mentoria.mentoriaapi.repositories.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    public AlunoDto saveAluno(AlunoDto alunoDto) {

        //Criando a instancia de endereco
        Endereco endereco = new Endereco(
                alunoDto.endereco().logradouro(),
                alunoDto.endereco().numero(),
                alunoDto.endereco().bairro(),
                alunoDto.endereco().cidade(),
                alunoDto.endereco().estado()
        );

        //Salvando endereco no banco de dados
        enderecoRepository.save(endereco);

        Mentoria mentoria = null;
        if(alunoDto.mentoria() != null) {
            mentoria = mentoriaRepository.findByNome(alunoDto.mentoria().nome())
                    .orElseThrow(() -> new RuntimeException());
        }

        //salvando a entidade aluno no banco de dados
       var aluno = alunoRepository.save(new Aluno(
                alunoDto.name(),
                endereco,
                alunoDto.telefone(),
                mentoria
       ));

        return new AlunoDto(
               aluno.getDadosPessoais().getNome(),
               aluno.getDadosPessoais().getTelefone(),
               new EnderecoDto(
                       endereco.getLogradouro(),
                       aluno.getEndereco().getNumero(),
                       aluno.getEndereco().getBairro(),
                       aluno.getEndereco().getCidade(),
                       aluno.getEndereco().getEstado()
               ),
               mentoria != null ? new MentoriaDto(
                       mentoria.getNome(),
                       mentoria.getTipo(),
                       mentoria.getDataInicio()
               ) : null

       );

    }
}
