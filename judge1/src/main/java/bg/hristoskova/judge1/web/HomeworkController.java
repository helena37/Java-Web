package bg.hristoskova.judge1.web;

import bg.hristoskova.judge1.model.binding.CommentAddBindingModel;
import bg.hristoskova.judge1.model.binding.HomeworkAddBindingModel;
import bg.hristoskova.judge1.model.service.CommentServiceModel;
import bg.hristoskova.judge1.model.service.ExerciseServiceModel;
import bg.hristoskova.judge1.model.service.HomeworkServiceModel;
import bg.hristoskova.judge1.model.service.UserServiceModel;
import bg.hristoskova.judge1.service.CommentService;
import bg.hristoskova.judge1.service.ExerciseService;
import bg.hristoskova.judge1.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
@Controller
@RequestMapping("/homework")
public class HomeworkController {
    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public HomeworkController(ExerciseService exerciseService, HomeworkService homeworkService, CommentService commentService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("homeworkAddBindingModel")) {
            model.addAttribute("homeworkAddBindingModel", new HomeworkAddBindingModel());
            model.addAttribute("isLate", false);
        }

        model.addAttribute("allExercisesNames", this.exerciseService.findAllExercisesNames());

        return "homework-add";
    }

    @GetMapping("/check")
    public String checkHomework(Model model) {
        HomeworkServiceModel homeworkServiceModel =
                this.homeworkService.findOneToCheck();

        if (!model.containsAttribute("commentAddBindingModel")) {
            model.addAttribute("commentAddBindingModel", new CommentAddBindingModel());
        }

        model.addAttribute("homework", homeworkServiceModel);
        return "homework-check";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("homeworkAddBindingModel")
                                     HomeworkAddBindingModel homeworkAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession httpSession) {

        ExerciseServiceModel exercise =
                this.exerciseService.findByName(homeworkAddBindingModel.getExercise());

        boolean isLate = exercise.getDueDate().isBefore(LocalDateTime.now());

        if (bindingResult.hasErrors() || isLate) {
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.homeworkAddBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("isLate", isLate);

            return "redirect:add";
        }

        HomeworkServiceModel homeworkServiceModel = this.modelMapper
                .map(homeworkAddBindingModel, HomeworkServiceModel.class);
        homeworkServiceModel.setAddedOn(LocalDateTime.now());
        homeworkServiceModel.setExercise(exercise);
        homeworkServiceModel.setAuthor((UserServiceModel) httpSession.getAttribute("user"));

        this.homeworkService.add(homeworkServiceModel);
        return "redirect:/";
    }

    @PostMapping("/check")
    public String checkConfirm(@Valid @ModelAttribute("commentAddBindingModel") CommentAddBindingModel commentAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentAddBindingModel", commentAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.commentAddBindingModel", bindingResult);

            return "redirect:check";
        }

        CommentServiceModel commentServiceModel =
                this.modelMapper.map(commentAddBindingModel, CommentServiceModel.class);
        commentServiceModel.setAuthor((UserServiceModel) httpSession.getAttribute("user"));
        commentServiceModel.setHomework(this.homeworkService.findById(commentAddBindingModel.getHomeworkId()));
        this.commentService.add(commentServiceModel);

        return "redirect:/";
    }
}