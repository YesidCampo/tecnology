package com.tecnology.domain.ports.out;

import com.tecnology.domain.models.Tecnology;

import reactor.core.publisher.Mono;

public interface TecnologyRepositoryPort {

    Mono<Tecnology> save(Tecnology tecnology);

    Mono<Tecnology> findByName(String nameTecnology);

}
