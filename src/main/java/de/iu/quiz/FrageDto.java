package de.iu.quiz;

import java.util.Objects;

public class FrageDto {

    private Long id;
    private String frageText;
    private Boolean beantwortet;

    public Long getId() {
        return id;
    }

    public FrageDto setId(final Long id) {
        this.id = id;
        return this;
    }

    public String getFrageText() {
        return frageText;
    }

    public FrageDto setFrageText(final String frageText) {
        this.frageText = frageText;
        return this;
    }

    public Boolean getBeantwortet() {
        return beantwortet;
    }

    public FrageDto setBeantwortet(final Boolean beantwortet) {
        this.beantwortet = beantwortet;
        return this;
    }

    @Override
    public boolean equals(final Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FrageDto frageDto = (FrageDto) o;
        return Objects.equals(id, frageDto.id) && Objects.equals(frageText, frageDto.frageText) && Objects.equals(beantwortet, frageDto.beantwortet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, frageText, beantwortet);
    }
}
