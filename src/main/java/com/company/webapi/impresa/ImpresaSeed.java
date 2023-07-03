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
            var list = new ArrayList<Impresa>();

            for(int n = 0; n < 10; n++) {
                list.add(getImpresa(n));
            }

            repository.saveAll(list);
        };
    }

    private static Impresa getImpresa(Integer n) {
        var anno = 2013 + n;
        var impresa = new Impresa();

        impresa.setAnno(2020);
        impresa.setRagioneSociale("Impresa " + n);
        impresa.setIsDisattivata(false);
        impresa.setPivaCF("0000000000000000");

        var dittas = new ArrayList<Ditta>();

        var ditta1 = new Ditta();
        ditta1.setAnno(anno);
        ditta1.setDenominazione("Ditta 1");

        var ditta2 = new Ditta();
        ditta2.setAnno(anno);
        ditta2.setDenominazione("Ditta 2");

        var ditta3 = new Ditta();
        ditta3.setAnno(anno);
        ditta3.setDenominazione("Ditta 2");

        dittas.add(ditta1);
        dittas.add(ditta2);
        dittas.add(ditta3);

        impresa.setLstDitte(dittas);

        return impresa;
    }
}
