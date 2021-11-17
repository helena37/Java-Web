package bg.hristoskova.judge1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
@Controller
@RequestMapping("/homework")
public class HomeworkController {
    @GetMapping("/add")
    public String add() {
        return "homework-add";
    }

    @GetMapping("/check")
    public String checkHomework() {
        return "homework-check";
    }
}
