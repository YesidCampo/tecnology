package com.tecnology.infrastructure.repositories;

import org.springframework.stereotype.Component;

import com.tecnology.domain.models.Tecnology;
import com.tecnology.domain.ports.out.TecnologyRepositoryPort;
import com.tecnology.infrastructure.entities.TecnologyEntity;
import com.tecnology.infrastructure.utils.TecnologyMapper;

import reactor.core.publisher.Mono;

@Component
public class TecnologyAdapter implements TecnologyRepositoryPort {

    private final TecnologyRepository tecnologyRepository;

    public TecnologyAdapter(TecnologyRepository tecnologyRepository) {
        this.tecnologyRepository = tecnologyRepository;
    }

    @Override
    public Mono<Tecnology> save(Tecnology tecnology) {
        TecnologyEntity tecnologyEntity = TecnologyMapper.fromDomainModel(tecnology);
        return this.tecnologyRepository.save(tecnologyEntity).map(TecnologyMapper::toDomainModel);
    }

    @Override
    public Mono<Tecnology> findByName(String nameTecnology) {
        return this.tecnologyRepository.findByName(nameTecnology).map(TecnologyMapper::toDomainModel);
    }

}
