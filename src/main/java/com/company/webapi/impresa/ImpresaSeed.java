package com.company.webapi.impresa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class ImpresaSeed {

    private static final Logger log = LoggerFactory.getLogger(ImpresaSeed.class);

    @Bean
    CommandLineRunner initDatabase(ImpresaRepository repository) {
        return args -> {
            for(int n = 0; n < 300; n++) {
                log.info("Preloading " + repository.save(getImpresa()));
            }
        };
    }

    private Impresa getImpresa(){
        return new Impresa(null, true, Arrays.asList(
                new ImpresaAnno(null, 2020, "Impresa"),
                new ImpresaAnno(null, 2021, "Impresa"),
                new ImpresaAnno(null, 2022, "Impresa"),
                new ImpresaAnno(null, 2023, "Impresa")
        ));
    }
}
