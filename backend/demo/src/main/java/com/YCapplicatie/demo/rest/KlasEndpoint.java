package com.YCapplicatie.demo.rest;

import com.YCapplicatie.demo.controllor.KlasService;
import com.YCapplicatie.demo.domein.Klas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;


@RestController
public class KlasEndpoint {

    @Autowired
    public KlasService sv;


    @GetMapping("/leesKlas/{lokaalnr}/{aantalleerlingen}/{afmetingen}/{hoofddocent}")
    String lopen(@PathVariable String lokaalnr, @PathVariable String aantalleerlingen, @PathVariable String afmetingen, @PathVariable String hoofddocent){

        Klas kls = new Klas();
        kls.setLokaalNr(lokaalnr);
        kls.setAantalLeerlingen(aantalleerlingen);
        kls.setAfmetingen(afmetingen);
        kls.setHoofdDocent(hoofddocent);

        System.out.println("hoi het werkt");
        sv.proberen(kls);
        return ("antwoord naar frontend");
    }

}
