package bg.hristoskova.judge1.web;

import bg.hristoskova.judge1.model.binding.ExerciseAddBindingModel;
import bg.hristoskova.judge1.model.service.ExerciseServiceModel;
import bg.hristoskova.judge1.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author helena81
 * @version 1.0
 * @since 16.11.21
 */
@Controller
@RequestMapping("/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public ExerciseController(ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(@Valid @ModelAttribute("exerciseAddBindingModel")
                                  ExerciseAddBindingModel exerciseAddBindingModel,
                      BindingResult bindingResult) {
        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("exerciseAddBindingModel")
                                     ExerciseAddBindingModel exerciseAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciseAddBindingModel", exerciseAddBindingModel);
            return "redirect:/exercises/add";
        } else {
            this.exerciseService.addExercise(this.modelMapper.map(exerciseAddBindingModel, ExerciseServiceModel.class));
            return "redirect:/";
        }
    }

}
