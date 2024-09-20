package com.tecnology.infrastructure.utils;

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

}
