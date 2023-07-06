package com.company.webapi.impresa;

import com.company.webapi.ditta.entities.Ditta;
import com.company.webapi.impresa.entities.Impresa;
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
            var lstImprese = new ArrayList<Impresa>();

            for(int n = 0; n < 10; n++) {
                var anno = 2013 + n;

                var impresa = new Impresa(anno, "Impresa " + n, false, "0000000000000000");

                impresa.addDitta(new Ditta(anno, "Ditta 1", impresa));
                impresa.addDitta(new Ditta(anno, "Ditta 2", impresa));
                impresa.addDitta(new Ditta(anno, "Ditta 3", impresa));

                lstImprese.add((impresa));
            }

            repository.saveAll(lstImprese);
        };
    }

}
