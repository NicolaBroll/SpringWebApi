package com.company.webapi.impresa;

import com.company.webapi.impresa.entities.Impresa;
import com.company.webapi.impresa.entities.ImpresaAnno;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ImpresaSeed {
    @Bean
    CommandLineRunner initDatabase(ImpresaRepository repository) {
        return args -> {
            List<Impresa> list = new ArrayList<>();

            for(int n = 0; n < 50; n++) {
                list.add(getImpresa());
            }

            repository.saveAll(list);
        };
    }

    private Impresa getImpresa(){
        return new Impresa(null, "aziz", true, Arrays.asList(
                new ImpresaAnno(null, 2020, "Impresa"),
                new ImpresaAnno(null, 2021, "Impresa"),
                new ImpresaAnno(null, 2022, "Impresa"),
                new ImpresaAnno(null, 2023, "Impresa")
        ));
    }
}
