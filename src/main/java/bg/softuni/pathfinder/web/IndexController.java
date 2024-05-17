package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return"/index";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "/about";
    }
}
