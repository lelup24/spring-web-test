package de.iu.quiz;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fragen")
public class FrageRestController {

  private final FrageRepository frageRepository;

  public FrageRestController(final FrageRepository frageRepository) {
    this.frageRepository = frageRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<FrageDto>> getFragen() {

    final List<FrageDto> frageDtos = frageRepository.findAll().stream()
            .map(
                    frage ->
                            new FrageDto()
                                    .setId(frage.getId())
                                    .setFrageText(frage.getFrageText())
                                    .setBeantwortet(frage.getBeantwortet()))
            .toList();

    return new ResponseEntity<>(frageDtos, HttpStatus.OK);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<FrageDto>> createFrage(@RequestBody FrageDto frageDto) {

    final Frage neueFrage = new Frage();
    neueFrage.setFrageText(frageDto.getFrageText());
    neueFrage.setBeantwortet(Boolean.FALSE);

    frageRepository.saveAndFlush(neueFrage);

    final List<FrageDto> frageDtos = frageRepository.findAll().stream()
            .map(
                    frage ->
                            new FrageDto()
                                    .setId(frage.getId())
                                    .setFrageText(frage.getFrageText())
                                    .setBeantwortet(frage.getBeantwortet())).collect(Collectors.toList());

    Collections.shuffle(frageDtos);

    return new ResponseEntity<>(frageDtos, HttpStatus.OK);
  }

}
