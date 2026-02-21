package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity     // Annotation die es zur einer Enitity Klasse macht
public class Obst
{
    // id ist die PK und wird generiert
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // generiert den PK
    // Private Attribute
    private int id;

    private String bezeichnung;
    private float gewicht;
    private float preis;
    private LocalDate haltbarbis;

    // getter und setter
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public float getGewicht() {
        return gewicht;
    }

    public void setGewicht(float gewicht) {
        this.gewicht = gewicht;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public LocalDate getHaltbarbis() {
        return haltbarbis;
    }

    public void setHaltbarbis(LocalDate haltbarbis) {
        this.haltbarbis = haltbarbis;
    }




}
