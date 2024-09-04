package com.jornada.mentoria.mentoriaapi.repositories;

import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoriaRepository extends JpaRepository<Mentoria, Integer>{

}
