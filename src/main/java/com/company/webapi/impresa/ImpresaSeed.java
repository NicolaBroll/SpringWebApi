package com.company.webapi.impresa;

import com.company.webapi.ditta.entities.Ditta;
import com.company.webapi.impresa.repositories.ImpresaRepository;
import com.company.webapi.impresa.entities.Impresa;
import com.company.webapi.impresa.entities.ImpresaAnno;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ImpresaSeed {

    @Bean
    CommandLineRunner initDatabase(ImpresaRepository repository) {
        return args -> {
            var lstImprese = new ArrayList<Impresa>();

            var impresa1 = new Impresa("A0001");
            addFakeData(impresa1);
            lstImprese.add(impresa1);

            var impresa2 = new Impresa("A0002");
            addFakeData(impresa2);
            lstImprese.add(impresa2);

            repository.saveAll(lstImprese);
        };
    }

    private static void addFakeData(Impresa impresa) {
        for(int n = 1; n <= 10; n++) {
            var anno = 2013 + n;
            var impresaAnno = new ImpresaAnno(anno, "Impresa " + n,  "0000000000000000", impresa);

            impresaAnno.addDitta(new Ditta("Ditta 1", impresaAnno));
            impresaAnno.addDitta(new Ditta("Ditta 2", impresaAnno));
            impresaAnno.addDitta(new Ditta("Ditta 3", impresaAnno));

            impresa.addImpresaAnno(impresaAnno);
        }
    }

}
