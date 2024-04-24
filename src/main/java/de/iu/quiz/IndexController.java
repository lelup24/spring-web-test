package de.iu.quiz;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  private final FrageRepository frageRepository;

  public IndexController(final FrageRepository frageRepository) {
    this.frageRepository = frageRepository;
  }

  @GetMapping
  public String getIndex(Model model) {

    final List<FrageDto> fragen =
        frageRepository.findAll().stream()
            .map(
                frage ->
                    new FrageDto()
                        .setId(frage.getId())
                        .setFrageText(frage.getFrageText())
                        .setBeantwortet(frage.getBeantwortet()))
            .toList();

    model.addAttribute("fragen", fragen);
    return "index";
  }
}
