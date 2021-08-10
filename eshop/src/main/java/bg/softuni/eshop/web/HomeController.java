package bg.softuni.eshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author helena81
 * @version 1.0
 * @since 7.08.21
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
