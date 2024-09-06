package com.jornada.mentoria.mentoriaapi.dto;

import java.util.List;

public record PageDto<T>(Long totalElementos,
                         Integer totalPaginas,
                         Integer pagina,
                         Integer tamanho,
                         List<T> elementos) {
}
