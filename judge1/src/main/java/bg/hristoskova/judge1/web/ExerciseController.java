package bg.hristoskova.judge1.web;

import bg.hristoskova.judge1.model.binding.ExerciseAddBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
            //todo
        }

        return "redirect:/";
    }

}
