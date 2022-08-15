package com.gft.controllers;

import com.gft.dto.animal.AnimalMapper;
import com.gft.dto.animal.RequestAnimalDTO;
import com.gft.dto.animal.ResponseAnimalDTO;
import com.gft.entities.Animal;
import com.gft.service.AnimalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Cria um animal infromando seu respectivo dono")
    @PostMapping
    public ResponseEntity<ResponseAnimalDTO> salvarAnimal(@RequestBody @Valid RequestAnimalDTO dto) {

        Animal animal = animalService.salvar(AnimalMapper.fromDTO(dto));
        return ResponseEntity.ok(AnimalMapper.fromEntity(animal));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Retorna todos os animais")
    @GetMapping
    public ResponseEntity<List<ResponseAnimalDTO>> listar() {
        return ResponseEntity.ok(animalService.listar()
                .stream().map(AnimalMapper::fromEntity)
                .collect(Collectors.toList()));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Retorna os animais referentes ao cliente informado")
    @GetMapping("clientes/{id}")
    public ResponseEntity<List<ResponseAnimalDTO>> listaPoroClienteId(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.listarPorClienteID(id)
                .stream().map(AnimalMapper::fromEntity)
                .collect(Collectors.toList()));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Atualiza os dados do animal informado pelo id")
    @PutMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<ResponseAnimalDTO> atualizar(@PathVariable Long id, @RequestBody RequestAnimalDTO dto) {
        Animal animal = animalService.atualizar(AnimalMapper.fromDTO(dto), id);

        return ResponseEntity.ok(AnimalMapper.fromEntity(animal));
=======
    public ResponseEntity<ResponseAnimalDTO> atualizar(@PathVariable Long id,@Valid @RequestBody RequestAnimalDTO dto) {
    	Animal animal = animalService.atualizar(AnimalMapper.fromDTO(dto), id);
    	
    	return ResponseEntity.ok(AnimalMapper.fromEntity(animal));
>>>>>>> a097b8d5505f7bcc0bd5731b7d91c7e30ec42646
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Deleta os dados do animal informado pelo id")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        animalService.deletar(id);

    }
}
