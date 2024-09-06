package com.jornada.mentoria.mentoriaapi.repositories;

import com.jornada.mentoria.mentoriaapi.entity.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

    Page<Aluno> findAll(Pageable pageable);
}
