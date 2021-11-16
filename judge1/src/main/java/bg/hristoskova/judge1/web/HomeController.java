package bg.hristoskova.judge1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(HttpSession httpSession) {

        return httpSession.getAttribute("user") == null ? "index" : "home";
    }
}
