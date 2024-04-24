package de.iu.quiz;

import jakarta.persistence.*;

@Entity
public class Frage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String frageText;
    private Boolean beantwortet;

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFrageText() {
        return frageText;
    }

    public Frage setFrageText(final String frageText) {
        this.frageText = frageText;
        return this;
    }

    public Boolean getBeantwortet() {
        return beantwortet;
    }

    public Frage setBeantwortet(final Boolean beantwortet) {
        this.beantwortet = beantwortet;
        return this;
    }
}
