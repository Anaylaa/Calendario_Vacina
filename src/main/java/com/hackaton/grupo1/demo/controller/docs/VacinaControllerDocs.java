package com.hackaton.grupo1.demo.controller.docs;

import com.hackaton.grupo1.demo.dto.VacinaDTO;
import com.hackaton.grupo1.demo.entity.Vacina;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Vacinas", description = "Endpoints para gerenciar vacinas")
public interface VacinaControllerDocs {

    @Operation(summary = "Consultar todas as vacinas",
            description = "Endpoint que retorna todas as vacinas cadastradas no sistema.",
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "200",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = VacinaDTO.class)))),
                    @ApiResponse(description = "Erro Interno", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<List<VacinaDTO>> listarTodas();

    @Operation(summary = "Consultar vacinas por faixa etária",
            description = "Retorna vacinas para uma determinada faixa etária (CRIANÇA, ADOLESCENTE, ADULTO, GESTANTE).",
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "200",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = VacinaDTO.class)))),
                    @ApiResponse(description = "Parâmetro Inválido", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Erro Interno", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<List<VacinaDTO>> listarPorFaixaEtaria(@PathVariable String faixa);

    @Operation(summary = "Consultar vacinas recomendadas acima de uma idade",
            description = "Retorna vacinas com recomendação de aplicação acima da idade informada em meses.",
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "200",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = VacinaDTO.class)))),
                    @ApiResponse(description = "Parâmetro Inválido", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Erro Interno", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<List<VacinaDTO>> listarPorIdadeMaior(@PathVariable int meses);
}