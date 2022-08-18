package com.gft.controllers;

import com.gft.entities.Raca;
import com.gft.service.RacaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
@RequestMapping("/racas")
public class RacaController {

    private RacaService racaService;

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Raca>> buscarRaca(@PathVariable Long id) {
        Flux<Raca> raca = racaService.obterRacaPorId(id);
        return ResponseEntity.ok(raca);
    }

    @GetMapping
    public ResponseEntity<Flux<Raca>> listarRacas() {
        return ResponseEntity.ok(racaService.listarRacas());
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<Flux<Raca>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(racaService.buscarPorNome(nome));
    }
}
