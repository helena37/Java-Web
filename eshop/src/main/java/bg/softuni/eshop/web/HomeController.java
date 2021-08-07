package bg.softuni.eshop.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author helena81
 * @version 1.0
 * @since 7.08.21
 */

// Just a test
@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/index")
    public String sayHello () {
        return "index.html";
    }
}
