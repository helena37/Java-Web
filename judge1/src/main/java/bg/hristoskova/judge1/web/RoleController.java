package bg.hristoskova.judge1.web;

import bg.hristoskova.judge1.model.binding.RoleAddBindingModel;
import bg.hristoskova.judge1.service.RoleService;
import bg.hristoskova.judge1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author helena81
 * @version 1.0
 * @since 16.11.21
 */
@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RoleController(RoleService roleService, UserService userService, ModelMapper modelMapper) {
        this.roleService = roleService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.addObject("usernames", this.userService.findAllUsernames());

        modelAndView.setViewName("role-add");
        return modelAndView;
    }

    @PostMapping("/add")
    public String addConfirm(@ModelAttribute("roleAddBindingModel")
                                         RoleAddBindingModel roleAddBindingModel) {
        //todo validate
        this.userService.addRoleToUser(roleAddBindingModel.getUsername(), roleAddBindingModel.getRole());

        return "redirect:/";
    }
}
