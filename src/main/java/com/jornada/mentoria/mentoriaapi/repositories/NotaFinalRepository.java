package com.jornada.mentoria.mentoriaapi.repositories;

import com.jornada.mentoria.mentoriaapi.entity.IdNotaFinal;
import com.jornada.mentoria.mentoriaapi.entity.NotaFinal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFinalRepository extends JpaRepository<NotaFinal, IdNotaFinal> {
}
