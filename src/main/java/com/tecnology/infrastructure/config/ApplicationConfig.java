package com.tecnology.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tecnology.application.services.TecnologyService;
import com.tecnology.application.services.impl.TecnologyServiceImpl;
import com.tecnology.application.usecases.CreateTecnologyUseCaseImpl;
import com.tecnology.application.usecases.RetrieveTecnologyUseCaseImpl;
import com.tecnology.domain.ports.out.TecnologyRepositoryPort;
import com.tecnology.infrastructure.repositories.TecnologyAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public TecnologyService tecnologyService(TecnologyRepositoryPort tecnologyRepositoryPort) {
        return new TecnologyServiceImpl(
                new CreateTecnologyUseCaseImpl(tecnologyRepositoryPort),
                new RetrieveTecnologyUseCaseImpl(tecnologyRepositoryPort));
    }

    @Bean
    public TecnologyRepositoryPort tecnologyRepositoryPort(TecnologyAdapter jpaTecnologyAdapter) {
        return jpaTecnologyAdapter;
    }

}
