package com.jornada.mentoria.mentoriaapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "modulo")
@Getter
@Setter
public class Modulo {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_modulo")
    @SequenceGenerator(name = "gerador_modulo", sequenceName = "modulo_seq", allocationSize = 1)
    @Column(name = "id_modulo")
    private Integer idModulo;

    private String nome;

    @Column(name = "id_mentoria", insertable = false, updatable = false)
    private Integer idMentoria;

    @ManyToOne(fetch = FetchType.LAZY) // busca só quando o get for feito
    @JoinColumn(name = "id_mentoria", referencedColumnName = "id_mentoria")
    @JsonIgnore
    private Mentoria mentoria;


    public Modulo() {}



}
