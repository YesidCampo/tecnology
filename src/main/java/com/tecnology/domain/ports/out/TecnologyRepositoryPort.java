package com.tecnology.domain.ports.out;

import org.springframework.data.domain.Pageable;

import com.tecnology.domain.models.Tecnology;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TecnologyRepositoryPort {

    Mono<Tecnology> save(Tecnology tecnology);

    Mono<Tecnology> findByName(String nameTecnology);

    Flux<Tecnology> findAll(Pageable pageable, boolean ascending);

}
