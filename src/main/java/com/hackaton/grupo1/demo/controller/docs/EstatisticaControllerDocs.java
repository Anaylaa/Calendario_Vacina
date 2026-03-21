package com.hackaton.grupo1.demo.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatísticas", description = "Endpoints de contagem e indicadores")
public interface EstatisticaControllerDocs {

    @Operation(summary = "Quantidade de vacinas aplicadas por paciente")
    ResponseEntity<Long> qtdePorPaciente(Integer id);

    @Operation(summary = "Quantidade de vacinas aplicáveis no próximo mês")
    ResponseEntity<Long> qtdeProximoMes(Integer id);

    @Operation(summary = "Quantidade de vacinas atrasadas")
    ResponseEntity<Long> qtdeAtrasadas(Integer id);

    @Operation(summary = "Quantidade de vacinas acima de uma determinada idade")
    ResponseEntity<Long> qtdeAcimaIdade(int meses);
}
