package com.YCapplicatie.demo.domein;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String lokaalNr;
    private String aantalLeerlingen;
    private String afmetingen;
    private String hoofdDocent;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLokaalNr() {
        return lokaalNr;
    }

    public void setLokaalNr(String lokaalNr) {
        this.lokaalNr = lokaalNr;
    }

    public String getAantalLeerlingen() {
        return aantalLeerlingen;
    }

    public void setAantalLeerlingen(String aantalLeerlingen) {
        this.aantalLeerlingen = aantalLeerlingen;
    }

    public String getAfmetingen() {
        return afmetingen;
    }

    public void setAfmetingen(String afmetingen) {
        this.afmetingen = afmetingen;
    }

    public String getHoofdDocent() {
        return hoofdDocent;
    }

    public void setHoofdDocent(String hoofdDocent) {
        this.hoofdDocent = hoofdDocent;
    }
}
