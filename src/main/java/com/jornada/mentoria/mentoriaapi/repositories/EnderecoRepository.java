package com.jornada.mentoria.mentoriaapi.repositories;

import com.jornada.mentoria.mentoriaapi.entity.Endereco;
import com.jornada.mentoria.mentoriaapi.entity.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

    List<Endereco> findByLogradouroIgnoreCase(String logradouro);
    
    @Query("select e from Endereco e where e.numero = :numero")
    List<Endereco> consultaPorNumero(Integer numero) ;

    @Query(value = "SELECT * FROM Endereco WHERE Endereco.bairro = :bairro", nativeQuery = true)
    List<Endereco> consultaPorBairro(String bairro);
}
