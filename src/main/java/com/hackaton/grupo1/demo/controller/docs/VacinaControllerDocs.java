package com.hackaton.grupo1.demo.controller.docs;

import com.hackaton.grupo1.demo.entity.Vacina;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Vacinas", description = "Endpoints para gerenciar vacinas")
public interface VacinaControllerDocs {

    @Operation(
            summary = "Listar todas as vacinas",
            description = "Retorna uma lista com todas as vacinas registradas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de vacinas retornada com sucesso")
            }
    )
    ResponseEntity<List<Vacina>> getAllVacinas();

    @Operation(
            summary = "Buscar vacina por ID",
            description = "Retorna os dados de uma vacina específica pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Vacina encontrada"),
                    @ApiResponse(responseCode = "404", description = "Vacina não encontrada")
            }
    )
    ResponseEntity<Vacina> getVacinaById(
            @Parameter(description = "ID da vacina que será buscada") Integer id);

    @Operation(
            summary = "Cadastrar nova vacina",
            description = "Recebe os dados de uma vacina e cria um novo registro",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Vacina criada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    ResponseEntity<Vacina> createVacina(
            @Parameter(description = "Objeto com os dados da vacina") Vacina vacina);

    @Operation(
            summary = "Atualizar vacina",
            description = "Atualiza os dados de uma vacina existente pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Vacina atualizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Vacina não encontrada")
            }
    )
    ResponseEntity<Vacina> updateVacina(
            @Parameter(description = "ID da vacina que será atualizada") Integer id,
            @Parameter(description = "Objeto com os dados atualizados da vacina") Vacina vacinaAtualizada);

    @Operation(
            summary = "Excluir vacina",
            description = "Exclui uma vacina pelo ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Vacina excluída com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Vacina não encontrada")
            }
    )
    ResponseEntity<Void> deleteVacina(
            @Parameter(description = "ID da vacina que será excluída") Integer id);
}