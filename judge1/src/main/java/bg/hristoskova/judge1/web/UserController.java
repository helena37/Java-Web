package bg.hristoskova.judge1.web;

import bg.hristoskova.judge1.model.binding.UserAddBindingModel;
import bg.hristoskova.judge1.model.binding.UserLoginBindingModel;
import bg.hristoskova.judge1.model.service.UserServiceModel;
import bg.hristoskova.judge1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute("userAddBindingModel")
                                                UserAddBindingModel userAddBindingModel,
                                        BindingResult bindingResult,
                                        ModelAndView modelAndView,
                                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            //TODO validation
            modelAndView.setViewName("redirect:/users/register");
        } else {
            UserServiceModel userServiceModel = this.userService.registerUser(
                    this.modelMapper.map(userAddBindingModel, UserServiceModel.class));
            modelAndView.setViewName("redirect:/users/login");
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@Valid @ModelAttribute("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView,
                                     HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            //TODO Validation
            modelAndView.setViewName("redirect:/users/login");
        } else {
            modelAndView.setViewName("redirect:/");
        }
        //TODO Login in Service
        httpSession.setAttribute("user", "userServiceModel");
        httpSession.setAttribute("id", "userId");

        return modelAndView;

    }
}
