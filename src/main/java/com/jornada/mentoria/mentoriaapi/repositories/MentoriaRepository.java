package com.jornada.mentoria.mentoriaapi.repositories;

import com.jornada.mentoria.mentoriaapi.dto.RelatorioMentoriasAlunosDto;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MentoriaRepository extends JpaRepository<Mentoria, Integer>{

    List<Mentoria> findByDataInicioLessThan(LocalDate dataInicio);

    Optional<Mentoria> findByNome(String nameMentoria);
}
