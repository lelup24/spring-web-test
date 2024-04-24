package de.iu.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragen")
public class FrageController {

    private final FrageRepository frageRepository;

    public FrageController(final FrageRepository frageRepository) {
        this.frageRepository = frageRepository;
    }

    @GetMapping
    public String getFragePage() {
        return "frage";
    }

    @PostMapping
    public String postFrage(@ModelAttribute FrageDto frageDto) {


        final Frage frage = new Frage().setFrageText(frageDto.getFrageText());

        frageRepository.saveAndFlush(frage);

        return "redirect:/";
    }



}
