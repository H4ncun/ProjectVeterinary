package com.gft.controllers;

import com.gft.dto.animalDTO.AnimalMapper;
import com.gft.dto.animalDTO.RequestAnimalDTO;
import com.gft.dto.animalDTO.ResponseAnimalDTO;
import com.gft.entities.Animal;
import com.gft.service.AnimalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @ApiOperation(value = "Cria um animal informando seu respectivo dono")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @PostMapping
    public ResponseEntity<ResponseAnimalDTO> salvarAnimal(@RequestBody @Valid RequestAnimalDTO dto) {
        Animal animal = animalService.salvar(AnimalMapper.fromDTO(dto));
        return ResponseEntity.ok(AnimalMapper.fromEntity(animal));
    }

    @ApiOperation(value = "Retorna todos os animais")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR','CLIENT')")
    @GetMapping
    public ResponseEntity<List<ResponseAnimalDTO>> listar() {
        return ResponseEntity.ok(animalService.listar()
                .stream().map(AnimalMapper::fromEntity)
                .collect(Collectors.toList()));
    }

    @ApiOperation(value = "Retorna um animal pelo id informado")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseAnimalDTO> buscar(@PathVariable Long id) {
        Animal animal = animalService.buscar(id);
        return ResponseEntity.ok(AnimalMapper.fromEntity(animal));
    }

    @ApiOperation(value = "Retorna os animais referentes ao cliente informado")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR','CLIENT')")
    @GetMapping("clientes/{id}")
    public ResponseEntity<List<ResponseAnimalDTO>> listaPorClienteId(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.listarPorClienteID(id)
                .stream().map(AnimalMapper::fromEntity)
                .collect(Collectors.toList()));
    }

    @ApiOperation(value = "Atualiza os dados do animal informado pelo id")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseAnimalDTO> atualizar(@PathVariable Long id, @Valid @RequestBody RequestAnimalDTO dto) {
        Animal animal = animalService.atualizar(AnimalMapper.fromDTO(dto), id);
        return ResponseEntity.ok(AnimalMapper.fromEntity(animal));
    }

    @ApiOperation(value = "Deleta os dados do animal informado pelo id")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        animalService.deletar(id);
    }
}
