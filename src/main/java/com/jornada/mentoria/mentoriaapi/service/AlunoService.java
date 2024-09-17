package com.jornada.mentoria.mentoriaapi.service;

import com.jornada.mentoria.mentoriaapi.dto.AlunoDto;
import com.jornada.mentoria.mentoriaapi.dto.DadosPessoaisDto;
import com.jornada.mentoria.mentoriaapi.dto.EnderecoDto;
import com.jornada.mentoria.mentoriaapi.dto.MentoriaDto;
import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import com.jornada.mentoria.mentoriaapi.entity.DadosPessoais;
import com.jornada.mentoria.mentoriaapi.entity.Endereco;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import com.jornada.mentoria.mentoriaapi.mapper.AlunoMapper;
import com.jornada.mentoria.mentoriaapi.repositories.AlunoRepository;
import com.jornada.mentoria.mentoriaapi.repositories.EnderecoRepository;
import com.jornada.mentoria.mentoriaapi.repositories.MentoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final EnderecoRepository enderecoRepository;
    private final MentoriaRepository mentoriaRepository;
    private final AlunoMapper alunoMapper;

    public AlunoDto saveAluno(AlunoDto alunoDto) {

        // Convertendo o DTO em entidade usando MapStruct
        Aluno alunoConvertido = alunoMapper.toEntity(alunoDto);

        // Salvando o endereço
        enderecoRepository.save(alunoConvertido.getEndereco());

        // Pegando a mentoria passada pelo usuário através do nome
        Mentoria mentoria = mentoriaRepository.findByNome(alunoDto.mentoria().nome())
                .orElseThrow(() -> new RuntimeException());

        // Associando a mentoria ao aluno
        alunoConvertido.setMentoria(mentoria);

        // Salvando o aluno no banco de dados
        var alunoSalvo = alunoRepository.save(alunoConvertido);

        // Retornando o DTO convertido a partir da entidade
        return alunoMapper.toDto(alunoSalvo);
    }
}
