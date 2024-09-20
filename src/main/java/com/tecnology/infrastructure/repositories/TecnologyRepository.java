package com.tecnology.infrastructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.tecnology.infrastructure.entities.TecnologyEntity;

import reactor.core.publisher.Mono;

@Repository
public interface TecnologyRepository extends ReactiveCrudRepository<TecnologyEntity, Long> {

    Mono<TecnologyEntity> findByName(String name);
}
