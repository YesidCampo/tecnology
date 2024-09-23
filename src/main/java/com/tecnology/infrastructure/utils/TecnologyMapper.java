package com.tecnology.infrastructure.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnology.domain.models.Tecnology;
import com.tecnology.infrastructure.entities.TecnologyEntity;

public class TecnologyMapper {

    private TecnologyMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static TecnologyEntity fromDomainModel(Tecnology tecnology) {
        return new TecnologyEntity(tecnology.getId(), tecnology.getName(), tecnology.getDescription());
    }

    public static Tecnology toDomainModel(TecnologyEntity tecnologyEntity) {
        return new Tecnology(tecnologyEntity.getId(), tecnologyEntity.getName(), tecnologyEntity.getDescription());
    }

    public static List<TecnologyEntity> fromDomainModelList(List<Tecnology> technologies) {
        return technologies.stream()
                .map(tecnology -> new TecnologyEntity(tecnology.getId(),
                        tecnology.getName(),
                        tecnology.getDescription()))
                .collect(Collectors.toList());
    }

    public static List<Tecnology> toDomainModelList(List<TecnologyEntity> technologiesEntity) {
        return technologiesEntity.stream()
                .map(technologyEntity -> new Tecnology(technologyEntity.getId(),
                        technologyEntity.getName(),
                        technologyEntity.getDescription()))
                .collect(Collectors.toList());
    }

}
