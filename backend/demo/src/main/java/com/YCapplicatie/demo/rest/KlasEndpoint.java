package com.YCapplicatie.demo.rest;

import com.YCapplicatie.demo.controllor.KlasService;
import com.YCapplicatie.demo.domein.Klas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class KlasEndpoint {

    @Autowired
    public KlasService sv;


    @GetMapping("/leesKlas/{lokaalnr}/{aantalleerlingen}/{afmetingen}/{docentNaam}")
    String addRow(@PathVariable String lokaalnr, @PathVariable String aantalleerlingen, @PathVariable String afmetingen, @PathVariable String docentNaam){
        Klas klas = setKlasValues(lokaalnr,aantalleerlingen, afmetingen,docentNaam);
        System.out.println("row got added");
        sv.addRow(klas);

        return ("row got added");
    }

    @GetMapping("/leesKlas/delete/{id}")
    String deleteRow(@PathVariable Long id){
        Optional<Klas> rowToDelete = sv.kr.findById(id);
        rowToDelete.ifPresent(klas -> sv.kr.delete(klas));
        System.out.println("row got deleted");

        return ("row got deleted");
    }

    Klas setKlasValues(String lokaalnr,String aantalleerlingen, String afmetingen, String docentNaam)  {
        Klas klas = new Klas();
        klas.setLokaalNr(lokaalnr);
        klas.setAantalLeerlingen(aantalleerlingen);
        klas.setAfmetingen(afmetingen);
        klas.setDocentNaam(docentNaam);
        return klas;
    }


}
