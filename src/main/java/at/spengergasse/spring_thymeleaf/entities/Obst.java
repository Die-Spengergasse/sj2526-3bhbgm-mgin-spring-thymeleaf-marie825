package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
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
    @NumberFormat(pattern = "0.00")     // damit wird die Zahl mit 2 Nachkommastellen formatiert
    private BigDecimal gewicht;
    @NumberFormat(pattern = "0.00")
    private BigDecimal preis;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  // parst LocalDate im ISO-Format (yyyy-MM-dd).
    private LocalDate haltbarbis;


    // getter und setter
    public String getBezeichnung() {
        return bezeichnung;
    }
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }


    public BigDecimal getGewicht() {
        return gewicht;
    }
    public void setGewicht(BigDecimal gewicht) {
        this.gewicht = gewicht;
    }


    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }


    public LocalDate getHaltbarbis() {
        return haltbarbis;
    }

    public void setHaltbarbis(LocalDate haltbarbis) {
        this.haltbarbis = haltbarbis;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
