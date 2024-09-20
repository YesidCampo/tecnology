package com.tecnology.domain.ports.in;

import org.springframework.data.domain.Pageable;

import com.tecnology.domain.models.Tecnology;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RetrieveTecnologyUseCase {

    Mono<Tecnology> getTecnologyByName(String name);

    Flux<Tecnology> getAllTecnology(Pageable pageable, boolean ascending);

}
