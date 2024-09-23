package com.tecnology.infrastructure.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.tecnology.domain.models.Tecnology;
import com.tecnology.domain.ports.out.TecnologyRepositoryPort;
import com.tecnology.infrastructure.entities.TecnologyEntity;
import com.tecnology.infrastructure.utils.TecnologyMapper;

import reactor.core.publisher.Flux;
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

    @Override
    public Flux<Tecnology> findAll(Pageable pageable, boolean ascending) {
        return this.tecnologyRepository.findAll().map(TecnologyMapper::toDomainModel);
    }

    @Override
    public Mono<Tecnology> findById(Long id) {
        return this.tecnologyRepository.findById(id).map(TecnologyMapper::toDomainModel);
    }

    @Override
    public Flux<Tecnology> findAllByIds(List<Long> ids) {
        return this.tecnologyRepository.findAllById(ids).map(TecnologyMapper::toDomainModel);
    }

}
